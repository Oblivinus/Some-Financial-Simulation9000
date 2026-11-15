package gui.components;

import java.awt.Font;

public class MonospaceLabel extends javax.swing.JLabel {

    public MonospaceLabel() {
        setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        setText("Text Here");
    }
}
