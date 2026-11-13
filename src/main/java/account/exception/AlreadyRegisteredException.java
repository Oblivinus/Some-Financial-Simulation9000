package account.exception;

public class AlreadyRegisteredException extends RuntimeException {
    public AlreadyRegisteredException(String msg) {
        super(msg);
    }
}
