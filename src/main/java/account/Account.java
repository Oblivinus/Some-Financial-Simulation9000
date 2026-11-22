package account;

import com.fasterxml.jackson.annotation.*;
import java.util.ArrayList;
import utility.Signal;
import utility.generator.AccountIdGenerator;

public class Account {

    @JsonIgnore public Signal<Double> balanceChange = new Signal();

    @JsonProperty public String username;
    @JsonProperty public String password;
    @JsonProperty public String id;
    @JsonProperty public ArrayList<String> recentTranfer = new ArrayList<>();

    @JsonProperty public double balance = 0;

    public Account() {};

    public Account(String user, String pass) {
        this();
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

        setBalance(balance - amount);
    }

    public void deposit(double amount) {
        amount = Math.max(amount, 0);
        setBalance(balance + amount);
    }

    public void setBalance(double amount) {
        balance = amount;
        balanceChange.emit(amount);
    }

    @JsonSetter("recentTranfer")
    public void setRecentTranfer(ArrayList<String> list) {
        this.recentTranfer = (list == null) ? new ArrayList<>() : list;
        recentTranfer = new ArrayList<>(new java.util.LinkedHashSet<>(recentTranfer));
    }

    public void addRecentTranfer(Account to) {
        String result = "%s - %s".formatted(to.username, to.id);
        addRecentTranfer(result);
    }

    public void addRecentTranfer(String recent) {
        recentTranfer.removeIf(current -> current.equals(recent));
        recentTranfer.addFirst(recent);

        while (recentTranfer.size() > 7) {
            recentTranfer.removeLast();
        }
    }
}
