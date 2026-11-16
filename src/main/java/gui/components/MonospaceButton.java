package gui.components;

import java.awt.Font;
import utility.Signal;

public class MonospaceButton extends javax.swing.JButton {

    public Signal onClicked = new Signal();
    public MonospaceButton() {
        setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        setText("Text Here");

        addActionListener(this::onClick);
    }

    private void onClick(java.awt.event.ActionEvent evt) {
        onClicked.emit(ABORT);
    }
}
