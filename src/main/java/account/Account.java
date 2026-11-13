package account;

import com.fasterxml.jackson.annotation.*;

public class Account {

    @JsonProperty String username;
    @JsonProperty String password;

    @JsonProperty float balance = 0;

    public Account() {};

    public Account(String user, String pass) {
        this.username = user;
        this.password = pass;
    }

    @JsonIgnore
    public String getBalanceStr() {
        return "Rp. " + String.valueOf(this.balance);
    }
}
