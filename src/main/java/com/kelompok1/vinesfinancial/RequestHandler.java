package com.kelompok1.vinesfinancial;

import account.AccountServer;
import utility.Signal;

public class RequestHandler {
    public static class Tranfer extends RequestInstance{
        public String accountNumber;
        public double amount;

        @Override
        public void resolve() {
            VinesFinancial.tranferQuery(this);
        }

        public void finish(account.Account origin) {
            AccountServer.tranfer(origin, accountNumber, amount);
            finish();
        }
    }
}

abstract class RequestInstance {
    public Signal onDeny = new Signal();
    public Signal onFinish = new Signal();

    abstract public void resolve();

    public void finish() {
        onFinish.emit(null);
    };

    public void deny() {
        onDeny.emit(null);
    };
}
