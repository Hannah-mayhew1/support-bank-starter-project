package training.supportbank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadingCSVFile {

    private static final Logger LOGGER = LogManager.getLogger();

    public static List<Transaction> getTransactionsFromFile(String filename) throws IOException {
        List<Transaction> transactions = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            LOGGER.info("Reading file...");
            for (int i = 0; i < lines.size(); i++) {
                Transaction convertedTransaction = convertLineToTransaction(lines.get(i));
                if (convertedTransaction != null) {
                    transactions.add(convertedTransaction);
                }
                else {
                    System.out.println("Skipping line...");
                    LOGGER.info("Skipping line due to incorrect data input");
                }
            }
            return transactions;
        }
        catch (IOException e) {
            System.out.println("File not found.");
            LOGGER.info("File not found.");
            throw e;
        }
    }

    private static Transaction convertLineToTransaction(String line) {
        try {
            LOGGER.debug("Converting line " + line);
            List<String> splitWords = Arrays.asList(line.split(","));
            return new Transaction(LocalDate.parse(splitWords.get(0), DateTimeFormatter.ofPattern("dd/MM/yyyy")), splitWords.get(1), splitWords.get(2), splitWords.get(3), Double.parseDouble(splitWords.get(4)));
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid input for 'amount' on line: " + line + ". File adjustment required.");
            return null;
        }
        catch (DateTimeParseException e) {
            System.out.println("Invalid input for 'date' on line: " + line + ". File adjustment required.");
            return null;
        }
    }
}
