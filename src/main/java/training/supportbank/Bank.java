package training.supportbank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        getAccountForPerson(transaction.getFromName()).addTransaction(transaction);
        getAccountForPerson(transaction.getToName()).addTransaction(transaction);
    }

    private Account getAccountForPerson(String name) {
        for (int i = 0; i < accounts.size(); i++) {
            Account currentAccount = accounts.get(i);
            if (currentAccount.getAccountName().equals(name)) {
                return currentAccount;
            }
        }
        Account newAccount = new Account(name);
        accounts.add(newAccount);
        return newAccount;
    }
}
