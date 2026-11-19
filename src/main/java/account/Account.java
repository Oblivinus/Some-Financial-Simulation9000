package account;

import com.fasterxml.jackson.annotation.*;
import utility.generator.AccountIdGenerator;

public class Account {

    @JsonProperty public String username;
    @JsonProperty public String password;
    @JsonProperty public String id;

    @JsonProperty public double balance = 0;

    public Account() {};

    public Account(String user, String pass) {
        this.username = user;
        this.password = pass;
        this.id = AccountIdGenerator.generate();

        if(this.username.equals("admin")) {
            this.balance = 999_999;
            this.id = "012010101001";
        }
    }

    public void withdraw(double amount) {
        amount = Math.max(amount, 0);

        if (balance < amount) {return;}

        balance -= amount;
    }

    public void deposit(double amount) {
        amount = Math.max(amount, 0);
        balance += amount;
    }

    public void tranfer(Account to, double amount) {
        
    }
}
