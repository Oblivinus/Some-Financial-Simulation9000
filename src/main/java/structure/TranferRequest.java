package structure;

public class TranferRequest {
        public String accountNumber;
        public double amount;

        public TranferRequest(String accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }
