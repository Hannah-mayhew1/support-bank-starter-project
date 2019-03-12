package training.supportbank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class readingCSVFile {

    public static List<Transaction> getTransactionsFromFile(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("Transactions2014.csv"));
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            transactions.add(convertLineToTransaction(lines.get(i)));
        }
        return transactions;
    }

    private static Transaction convertLineToTransaction(String line) {
        List<String> splitWords = Arrays.asList(line.split(","));
        return new Transaction(LocalDate.parse(splitWords.get(0), DateTimeFormatter.ofPattern("dd/MM/yyyy")), splitWords.get(1), splitWords.get(2), splitWords.get(3), Double.parseDouble(splitWords.get(4)));
    }
}
