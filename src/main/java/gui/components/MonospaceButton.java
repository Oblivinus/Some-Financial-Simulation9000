package gui.components;

import java.awt.Font;

public class MonospaceButton extends javax.swing.JButton {

    public MonospaceButton() {
        setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        setText("Text Here");
    }
}
