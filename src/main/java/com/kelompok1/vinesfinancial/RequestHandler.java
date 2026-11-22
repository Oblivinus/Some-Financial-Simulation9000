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

    public static class Deposit extends RequestInstance {
        public double amount;
        public account.Account account;

        @Override
        public void resolve() {
            VinesFinancial.queryDeposit(this);
        }

        @Override
        public void finish() {
            account.deposit(amount);
            super.finish();
        }



    }

    public static class Withdraw extends RequestInstance {
        public double amount;
        public account.Account account;

        @Override
        public void resolve() {
            VinesFinancial.queryWithdraw(this);
        }

        @Override
        public boolean checkValidity() {
            if (account == null) return false;
            if (account.balance < amount) return false;

            return true;
        }

        @Override
        public void finish() {
            account.withdraw(amount);
            super.finish();
        }


    }
}

abstract class RequestInstance {
    public Signal onDeny = new Signal();
    public Signal onFinish = new Signal();

    abstract public void resolve();

    public boolean checkValidity() {
        return true;
    }

    public void finish() {
        onFinish.emit(null);
    };

    public void deny() {
        onDeny.emit(null);
    };
}
