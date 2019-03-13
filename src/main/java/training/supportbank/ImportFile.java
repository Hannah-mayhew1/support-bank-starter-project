package training.supportbank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;
import java.util.Scanner;

public class ImportFile {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void importFile(Bank bank) throws IOException {
        while (true) {
            System.out.println("Please type filename to import:");
            Scanner fileInputScanner = new Scanner(System.in);
            String fileInput = fileInputScanner.nextLine();

            try {
                if (fileInput.endsWith(".json")) {
                    List<Transaction> transactionsList = ReadingJSONFile.readJsonFile(fileInput);
                    for (int i = 0; i < transactionsList.size(); i++) {
                        bank.addTransaction(transactionsList.get(i));
                    }
                    break;
                } else if (fileInput.endsWith(".csv")) {
                    List<Transaction> transactionsList = ReadingCSVFile.getTransactionsFromFile(fileInput);
                    for (int i = 0; i < transactionsList.size(); i++) {
                        bank.addTransaction(transactionsList.get(i));
                    }
                    break;
                } else {
                    System.out.println("Invalid file type. Please try again:");
                    LOGGER.info("Invalid file type");

                }
            } catch (NoSuchFileException | FileNotFoundException e) {
                continue;
            }
        }
    }
}
