package com.kelompok1.vinesfinancial;

import account.*;
import gui.MainFrame;
import gui.RegisterFrame;
import java.util.HashMap;
import utility.*;

public class VinesFinancial {
    
    public static MainFrame mainFrame = new MainFrame();
    public static RegisterFrame registerFrame = new RegisterFrame();
    public static Account loggedAccount;
    
    public static void main(String[] args) {
        AccountServer.register(new Account("admin", "123"));
        System.out.println(Storage.PATH_DIR.toAbsolutePath());
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

        boolean isRegistered = AccountServer.isUserRegistered(user);
        if (isRegistered) {
            registerFrame.displayWarning("User already exist");
            return;
        }

        if (!pass.equals(passConfirm)) {
            registerFrame.displayWarning("Password in both must the same");
            return;
        }

        AccountServer.register(new Account(user, pass));
        registerFrame.clear();
        utility.util.ShowInformationWin("Information", "Sign in succesful.\n\nYou may login now ;)");
    }

    public static void queryLogin(HashMap<String, Object> loginInfo) {
        String user = (String) loginInfo.get("user");
        String pass = (String) loginInfo.get("pass");

        if (user == null || user.isBlank() || pass == null || pass.isEmpty()) {
            System.out.println("Invalid Login");
            mainFrame.displayWarning("Invalid Login");
            return;
        } else {
            mainFrame.displayWarning();
        }

        boolean isRegistered = AccountServer.isUserRegistered(user);
        Account account;

        if (!isRegistered) {
            mainFrame.displayWarning("User is not exist");
            return;
        }

        account = AccountServer.attemptLogin(user, pass);
        System.out.println("Login Account");
        mainFrame.clear();
        utility.util.ShowWarningWin("Get rekt.", "Deleting system32.");
    }
}
