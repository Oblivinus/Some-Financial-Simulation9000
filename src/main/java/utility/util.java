package utility;

import javax.swing.JOptionPane;

public class util {
    public static void ShowWarningWin(String title, String msg) {
        JOptionPane.showMessageDialog(
            null,
            msg,
            title,
            JOptionPane.WARNING_MESSAGE);
    }

    public static void ShowInformationWin(String title, String msg) {
        JOptionPane.showMessageDialog(
            null,
            msg,
            title,
            JOptionPane.INFORMATION_MESSAGE);
    }
}
