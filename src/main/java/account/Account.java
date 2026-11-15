package account;

import com.fasterxml.jackson.annotation.*;

public class Account {

    @JsonProperty public String username;
    @JsonProperty public String password;

    @JsonProperty public double balance = 0;

    public Account() {};

    public Account(String user, String pass) {
        this.username = user;
        this.password = pass;

        if(this.username.equals("admin")) {this.balance = 999_999;}
    }
}
