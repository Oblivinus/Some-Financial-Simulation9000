package account;

import account.exception.AlreadyRegisteredException;
import java.util.HashMap;
import tools.jackson.core.type.TypeReference;
import utility.Storage;


public class AccountServer {
     private static final String FILE = "accounts/accounts.json";

    static HashMap<String, Account> registeredAccount = new HashMap<String, Account>();

    static {
        HashMap<String, Account> loaded = Storage.load(FILE, new TypeReference<HashMap<String, Account>>() {});
        if (loaded != null) {registeredAccount = loaded;}
    }

    public static Account register(Account account) throws AlreadyRegisteredException {
        if (isUserRegistered(account.username)) {
            throw new AlreadyRegisteredException("Account already registered");
        }

        registeredAccount.put(account.username, account);
        Storage.save(registeredAccount, FILE);
        return account;
    }

    public static boolean isUserRegistered(String user) {
        return registeredAccount.containsKey(user);
    }

    public static Account attemptLogin(String user, String pass) {
        if (!isUserRegistered(user)) {return null;}
        Account thisAcc = registeredAccount.get(user);
        return thisAcc.password.equals(pass) ? thisAcc : null;
    }
}

