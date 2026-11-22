package com.kelompok1.vinesfinancial;

import account.*;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import gui.LoginFrame;
import gui.MainFrame;
import gui.RegisterFrame;
import gui.main.tranfer.TranferOveviewWindow;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.UIManager;
import utility.*;

public class VinesFinancial {
    public static boolean busy = false;
    public static LoginFrame loginFrame;
    public static RegisterFrame registerFrame;
    public static MainFrame mainFrame;
    public static Account loggedAccount;

    public static TranferOveviewWindow tranferOveviewFrame;
    
    public static void main(String[] args) {
        init();
        if (!AccountServer.isUserRegisteredByName("admin")) { AccountServer.register(new Account("admin", "123")); }
        System.out.println(Storage.PATH_DIR.toAbsolutePath());
    }

    public static boolean isBusy() {
        return isShowing(mainFrame.tWindow)
                || isShowing(mainFrame.dWindow)
                || isShowing(mainFrame.wWindow)
                ;
    }

    private static boolean isShowing(java.awt.Window w) {
        return w != null && w.isVisible();
    }

    private static void init() {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }


        mainFrame = new  MainFrame();
        loginFrame = new LoginFrame();
        registerFrame = new RegisterFrame();

        swingWrapper(mainFrame);
        swingWrapper(loginFrame);
        swingWrapper(registerFrame);

        tranferOveviewFrame = new TranferOveviewWindow();

        loginFrame.open();

        loginFrame.onLoginClicked.connect(VinesFinancial::queryLogin);
        registerFrame.onSigninClicked.connect(VinesFinancial::querySignin);
    }

    private static void swingWrapper(JFrame frame) {
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                AccountServer.saveAll();
                System.out.println("Window is closing");
            }
        });
    }

    public static void querySignin(HashMap<String, Object> loginInfo) {
        String user = (String) loginInfo.get("user");
        String pass = (String) loginInfo.get("pass");
        String passConfirm = (String) loginInfo.get("passConfirm");

        boolean isInvalid = user == null || user.isBlank() || pass == null || pass.isEmpty() || passConfirm == null || passConfirm.isEmpty();

        if (isInvalid) {
            registerFrame.displayWarning("Invalid sign in");
            return;
        } else {
            registerFrame.displayWarning();
        }

        if (!pass.equals(passConfirm)) {
            registerFrame.displayWarning("Password in both must the same");
            return;
        }

        try {
            AccountServer.register(new Account(user, pass));
            registerFrame.clear();
            utility.VinesUtil.ShowInformationWin("Information", "Sign in succesful.\n\nYou may login now ;)");

        } catch (AccountException.AlreadyRegisteredExeception e) {
            registerFrame.displayWarning("User already exist");
            return;
        }
    }

    public static void queryLogin(HashMap<String, Object> loginInfo) {
        String user = (String) loginInfo.get("user");
        String pass = (String) loginInfo.get("pass");

        if (user == null || user.isBlank() || pass == null || pass.isEmpty()) {
            System.out.println("Invalid Login");
            loginFrame.displayWarning("Invalid Login");
            return;
        } else {
            loginFrame.displayWarning();
        }

        boolean isRegistered = AccountServer.isUserRegisteredByName(user);

        if (!isRegistered) {
            loginFrame.displayWarning("User is not exist");
            return;
        }

        loggedAccount = AccountServer.attemptLogin(user, pass);
        if (loggedAccount != null) {
            System.out.println("Login Account");
            loginFrame.clear();
            mainFrame.open();
            loginFrame.close();
        } else {
            loginFrame.displayWarning("Password is wrong");
        }
    }

    public static void querylogout() {
        if (isBusy()) return;

        loggedAccount = null;
        mainFrame.dispose();
        loginFrame.open();
    }

    //--------------------------------------------------------------------------------
    //account.json: 012221126849
    protected static void tranferQuery(RequestHandler.Tranfer request) {
        double total = request.amount + AccountServer.FEE;

        if (!AccountServer.isUserRegistered(request.accountNumber)) {
            request.deny();
            VinesUtil.ShowWarningWin("Invalid Input", "Account Target does not exist.");
            return;
        } else if (loggedAccount.id.equals(request.accountNumber)) {
            request.deny();
            VinesUtil.ShowWarningWin("Invalid Input", "Account Target cannot be yourself.");
            return;
        }

        if (loggedAccount.balance < total) {
            request.deny();
            VinesUtil.ShowWarningWin("Invalid Input", "Balance is not sufficient.");
            return;
        }

        tranferOveviewFrame.setInformation(request.accountNumber, request.amount, loggedAccount.balance);
        tranferOveviewFrame.open();
        tranferOveviewFrame.confirmButton().onClicked.connect(e -> {
            request.finish(loggedAccount);
            tranferOveviewFrame.close();
            mainFrame.tWindow.close();
        });

        //System.out.println(request.amount);
    }

    //--------------------------------------------------------------------------------
    protected static void queryDeposit(RequestHandler.Deposit request) {
        request.account = loggedAccount;

        if (request.amount <= 0) {
            request.deny();
            VinesUtil.ShowWarningWin("Invalid Input", "Amount must not be 0.");
            return;
        }

        request.finish();
        mainFrame.dWindow.close();
    }

    //--------------------------------------------------------------------------------
    protected static void queryWithdraw(RequestHandler.Withdraw request) {
        request.account = loggedAccount;

        if (request.amount <= 0) {
            request.deny();
            VinesUtil.ShowWarningWin("Invalid Input", "Amount must not be 0.");
            return;
        }

        if (!request.checkValidity()) {
            request.deny();
            VinesUtil.ShowWarningWin("Invalid Input", "Request Invalid. \ndid you check your balance?");
            return;
        }

        request.finish();
        mainFrame.wWindow.close();
    }
}
