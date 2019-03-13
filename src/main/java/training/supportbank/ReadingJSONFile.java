package training.supportbank;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.stream.JsonReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class ReadingJSONFile {

    private static final Logger LOGGER = LogManager.getLogger();

    public static List<Transaction> readJsonFile(String filename) throws IOException {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (jsonElement, type, jsonDeserializationContext) ->
            LocalDate.parse(jsonElement.getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        );
        Gson gson = gsonBuilder.create();

        try {
            JsonReader reader = new JsonReader(new FileReader(filename));
            Transaction[] data = gson.fromJson(reader, Transaction[].class);
            return Arrays.asList(data);
        }
        catch (IOException e) {
            System.out.println("File not found.");
            LOGGER.info("File not found.");
            throw e;
        }
    }
}
