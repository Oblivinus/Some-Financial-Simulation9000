package account;

public class Account {

    String username;
    String password;

    float balance = 0;


    public Account(String user, String pass) {
        this.username = user;
        this.password = pass;
    }

    public String getBalanceStr() {
        return "Rp. " + String.valueOf(this.balance);
    }
}
