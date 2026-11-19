package account;

import java.util.HashMap;
import tools.jackson.core.type.TypeReference;
import utility.Storage;
import utility.generator.AccountIdGenerator;


public class AccountServer {
     private static final String FILE = "accounts/accounts.json";

    static HashMap<String, Account> registeredAccount = new HashMap<String, Account>();
    static HashMap<String, Account> registeredAccountId = new HashMap<String, Account>();

    static {
        HashMap<String, Account> loaded = Storage.load(FILE, new TypeReference<HashMap<String, Account>>() {});

        if (loaded != null) {

            for (Account account : loaded.values()) {
                AccountIdGenerator.addToGenerated(account.id);
            }
            registeredAccount = loaded;

            for (Account account : registeredAccount.values()) {
                registeredAccountId.put(account.id, account);
            }
        }
    }

    public static Account register(Account account) throws AccountException.AlreadyRegisteredExeception {
        if (isUserRegisteredByName(account.username)) {
            throw new AccountException.AlreadyRegisteredExeception("Account already registered");
        }

        registeredAccountId.put(account.id, account);
        registeredAccount.put(account.username, account);
        Storage.save(registeredAccount, FILE);
        return account;
    }

   public Account getAccountById(String Id) {
       return registeredAccountId.get(Id);
   }

    public static boolean isUserRegisteredByName(String user) {
        return registeredAccount.containsKey(user);
    }

    public static Account attemptLogin(String user, String pass) {
        if (!isUserRegisteredByName(user)) {return null;}
        Account thisAcc = registeredAccount.get(user);
        return thisAcc.password.equals(pass) ? thisAcc : null;
    }
}

