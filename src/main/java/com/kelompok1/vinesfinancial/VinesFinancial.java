package com.kelompok1.vinesfinancial;

import account.*;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import gui.LoginFrame;
import gui.MainFrame;
import gui.RegisterFrame;
import java.util.HashMap;
import javax.swing.UIManager;
import structure.TranferRequest;
import utility.*;

public class VinesFinancial {

    public static LoginFrame loginFrame;
    public static RegisterFrame registerFrame;
    public static MainFrame mainFrame;
    public static Account loggedAccount;
    
    public static void main(String[] args) {
        init();
        if (!AccountServer.isUserRegistered("admin")) { AccountServer.register(new Account("admin", "123")); }
        System.out.println(Storage.PATH_DIR.toAbsolutePath());
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
        loginFrame.open();

        loginFrame.onLoginClicked.connect(VinesFinancial::queryLogin);
        registerFrame.onSigninClicked.connect(VinesFinancial::querySignin);

        mainFrame.onTranferRequest.connect(VinesFinancial::tranferQuery);
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

        boolean isRegistered = AccountServer.isUserRegistered(user);

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

    private static void tranferQuery(TranferRequest info) {
        System.out.println(info.amount);
    }
}
