package training.supportbank;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {

        Bank bank = new Bank();

        List<Transaction> transactionsList = readingCSVFile.getTransactionsFromFile("Transactions2014.csv");

        for (int i = 0; i < transactionsList.size(); i++) {
            bank.addTransaction(transactionsList.get(i));
        }

        getUserInput(bank);

    }

    public static void getUserInput(Bank bank) {
        System.out.println("Would you like to 'List All' or 'List [Account]'");
        Scanner userInputScanner = new Scanner(System.in);
        String userInput = userInputScanner.nextLine();

        if (userInput.equals("List All")) {
            listAllFunction(bank);
        }

        else if (userInput.startsWith("List ")) {
            String accountName = userInput.substring(5);
            listSingleAccount(bank, accountName);
        }

    }

    public static void listAllFunction (Bank bank) {
        for (int i = 0; i < bank.getAccounts().size(); i++) {
            System.out.println(bank.getAccounts().get(i).getAccountName());
            System.out.println(bank.getAccounts().get(i).getBalance());
        }
    }

    public static void listSingleAccount(Bank bank, String accountName) {
        List<Transaction> transactions = bank.getAccountForPerson(accountName).getTransactions();
        for (int i = 0; i < transactions.size() ; i++) {
            Transaction transaction = transactions.get(i);
            System.out.println(transaction.getDate() + ": " + transaction.getFromName() + " paid " + transaction.getToName() + " £" + transaction.getAmount() + " for " + transaction.getNarrative());
        }
    }
}
