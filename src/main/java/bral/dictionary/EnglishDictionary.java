package bral.dictionary;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Reads the englishDictionary file ONCE
 */
public class EnglishDictionary {
    private final Map<String, List<String>> dictionaryMap;

    public Map<String, List<String>> getDictionaryMap() {
        return dictionaryMap;
    }

    public EnglishDictionary() throws CsvValidationException, IOException
    {
        dictionaryMap = new HashMap<>();

        // gets the file from the "resources" directory
        InputStream in = EnglishDictionary.class.getResourceAsStream(
                "/englishDictionary.csv");

        CSVReader reader = new CSVReader(new InputStreamReader(in));
        String[] record;

        while ((record = reader.readNext()) != null) {
            // record is ONE line of the CSV
            String word = record[0].trim().toLowerCase();
            // String type = record[1].trim();
            String definition = record[2].trim();

            // add each to the dictionary:
            // first check if word is already in dictionary:
            if (dictionaryMap.containsKey(word))
            {
                // add type to the list:
                // dictionaryMap.get(word).add(type);
                // add definition to the list:
                dictionaryMap.get(word).add(definition);
            } else {
                List<String> definitions = new ArrayList<>();
                definitions.add(definition);
                dictionaryMap.put(word, definitions);
            }

        }

        reader.close();
    }

    /**
     *
     * @param word to look up
     * @return a list of defenitions or an empty list if the word doesn't exist
     */
    public List<String> getDefinition(String word)
    {
        word = word.trim().toLowerCase();
        return dictionaryMap.get(word);
    }
}
