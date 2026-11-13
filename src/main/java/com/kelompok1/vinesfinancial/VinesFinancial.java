package com.kelompok1.vinesfinancial;

import account.*;
import account.exception.AlreadyRegisteredException;
import gui.LoginFrame;
import gui.RegisterFrame;
import java.util.HashMap;
import utility.*;

public class VinesFinancial {
    public static LoginFrame loginFrame = new LoginFrame();
    public static RegisterFrame registerFrame = new RegisterFrame();
    public static Account loggedAccount;
    
    public static void main(String[] args) {
        if (!AccountServer.isUserRegistered("admin")) { AccountServer.register(new Account("admin", "123")); }
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

        if (!pass.equals(passConfirm)) {
            registerFrame.displayWarning("Password in both must the same");
            return;
        }

        try {
            AccountServer.register(new Account(user, pass));
            registerFrame.clear();
            utility.util.ShowInformationWin("Information", "Sign in succesful.\n\nYou may login now ;)");

        } catch (AlreadyRegisteredException e) {
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
            utility.util.ShowWarningWin("Get rekt.", "Deleting system32.");
        } else {
            loginFrame.displayWarning("Password is wrong");
        }
        
    }
}
