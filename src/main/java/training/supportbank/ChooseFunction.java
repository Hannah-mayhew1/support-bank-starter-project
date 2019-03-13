package training.supportbank;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

public class ChooseFunction {

    public static void chooseFunction(Bank bank) throws IOException {
        System.out.println("Which function would you like to use?: Import File, List All, List [Account]");
        Scanner userInputScanner = new Scanner(System.in);
        String userInput = userInputScanner.nextLine();

        if (userInput.equals("Import File")) {
            ImportFile.importFile(bank);
        }
        else if (userInput.equals("List All")) {
            listAllFunction(bank);
        }
        else if (userInput.startsWith("List ")) {
            String accountName = userInput.substring(5);
            ChooseFunction.listSingleAccount(bank, accountName);
        }
        else {
            System.out.println("Invalid input. Please select another function");
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
            System.out.println(transaction.getDate() + ": " + transaction.getFromAccount() + " paid " + transaction.getToAccount() + " " + NumberFormat.getCurrencyInstance().format(transaction.getAmount()) + " for " + transaction.getNarrative());
        }
    }
}
