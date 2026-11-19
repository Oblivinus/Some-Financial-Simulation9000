package utility;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class VinesUtil {
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

    public static String formatNumber(double n) {
         DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');

        DecimalFormat df = new DecimalFormat("#,###", symbols);
        String result = df.format(n);
        return result;
    }

    public static String getDate(String formatStr) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatStr);

        String formattedDate = currentDate.format(formatter);
        return formattedDate;
    }
}
