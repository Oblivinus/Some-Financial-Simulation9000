package account;

public class AccountException{
    private AccountException() {}

    static public class AlreadyRegisteredExeception extends RuntimeException {
        public AlreadyRegisteredExeception(String msg) {
            super(msg);
        }
    }

    static public class InvalidLoggedAccountException extends RuntimeException {
        public InvalidLoggedAccountException(String msg) {
            super(msg);
        }
    }
}
