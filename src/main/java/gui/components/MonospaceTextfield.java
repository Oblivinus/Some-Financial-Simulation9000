package gui.components;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import utility.Signal;

public class MonospaceTextfield extends javax.swing.JTextField {
    public Signal onEntered = new Signal();
    public Signal onFocusLost = new Signal();
    public Signal<String> onChanged = new Signal();

    public MonospaceTextfield() {
        setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));

        getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e)  { onChanged.emit(getText()); }
            @Override public void removeUpdate(DocumentEvent e)  { onChanged.emit(getText()); }
            @Override public void changedUpdate(DocumentEvent e) { }
        });

        addActionListener(this::onEntered);
         addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                onFocusLost();
            }
        });
    }

    private void onFocusLost() {
        onFocusLost.emit(ABORT);
    }

    private void onEntered(java.awt.event.ActionEvent e) {
        onEntered.emit(ABORT);
        getParent().requestFocusInWindow();
    }

    // "\\d*" - number
    public void setAllowedPattern(String regex) {
        ((AbstractDocument) getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr)
                    throws BadLocationException {
                replace(fb, offset, 0, text, attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                String current = fb.getDocument().getText(0, fb.getDocument().getLength());
                String result = new StringBuilder(current)
                        .replace(offset, offset + length, text == null ? "" : text)
                        .toString();
                if (result.matches(regex)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            @Override
            public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
                replace(fb, offset, length, "", null);
            }
        });
    }
}
