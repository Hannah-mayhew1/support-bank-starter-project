package training.supportbank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String args[]) throws IOException {

        LOGGER.info("SupportBank starting up!");

        Bank bank = new Bank();

        ImportFile.importFile(bank);

        while (true) {
            ChooseFunction.chooseFunction(bank);
        }

    }

    public static void getUserInput(Bank bank) {
        System.out.println("Would you like to 'List All' or 'List [Account]'");
        Scanner userInputScanner = new Scanner(System.in);
        String userInput = userInputScanner.nextLine();

        if (userInput.equals("List All")) {
            ChooseFunction.listAllFunction(bank);
        } else if (userInput.startsWith("List ")) {
            String accountName = userInput.substring(5);
            ChooseFunction.listSingleAccount(bank, accountName);
        } else {
            System.out.println("Invalid input. Please try again.");
        }
    }

}
