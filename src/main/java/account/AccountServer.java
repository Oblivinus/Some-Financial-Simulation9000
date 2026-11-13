package account;

import java.util.HashMap;


public class AccountServer {
     private static final String FILE = "accounts/accounts.json";

    static HashMap<String, Account> registeredAccount = new HashMap<String, Account>();

    public static Account register(Account account) {
        registeredAccount.put(account.username, account);
        return account;
    }

    public static boolean isUserRegistered(String user) {
        return registeredAccount.containsKey(user);
    }

    public static Account attemptLogin(String user, String pass) {
        if (!isUserRegistered(user)) {return null;}

        Account thisAcc = registeredAccount.get(user);

        if (thisAcc.password.equals(pass)) {
            return thisAcc;
        } else {
            return null;
        }
    }
}
