package training.supportbank;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String args[]) throws IOException {

        Bank bank = new Bank();

        List<Transaction> transactionsList = readingCSVFile.getTransactionsFromFile("Transactions2014.csv");

        for (int i = 0; i < transactionsList.size(); i++) {
            bank.addTransaction(transactionsList.get(i));
        }

        System.out.println("Breakpoint");
    }
}
