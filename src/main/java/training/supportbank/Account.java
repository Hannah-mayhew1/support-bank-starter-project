package training.supportbank;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String accountName;
    private List<Transaction> transactions;
    private Double balance;

    public String getAccountName() {
        return accountName;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Double getBalance() {
        return balance;
    }

    public Account(String accountName) {
        this.accountName = accountName;
        this.transactions = new ArrayList<>();
        this.balance = 0.0;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);

        if (transaction.getFromName().equals(accountName)) {
            balance = balance - transaction.getAmount();
        }
        if (transaction.getToName().equals(accountName)) {
            balance = balance + transaction.getAmount();
        }
    }
}
