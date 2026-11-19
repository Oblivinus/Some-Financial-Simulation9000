package com.kelompok1.vinesfinancial;

public class RequestHandler {
    public static class Tranfer extends RequestInstance{
        public String accountNumber;
        public double amount;

        @Override
        public void resolve() {
            VinesFinancial.tranferQuery(this);
        }
    }
}

abstract class RequestInstance {
    abstract public void resolve();
}
