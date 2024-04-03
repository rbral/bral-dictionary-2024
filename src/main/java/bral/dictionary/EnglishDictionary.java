package bral.dictionary;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Reads the englishDictionary file ONCE
 */
public class EnglishDictionary {

    public EnglishDictionary() throws CsvValidationException, IOException
    {
        // gets the file from the "resources" directory
        InputStream in = EnglishDictionary.class.getResourceAsStream(
                "/englishDictionary.csv");
//        InputStream in = EnglishDictionary.class.getResourceAsStream("englishDictionary.csv");

        CSVReader reader = new CSVReader(new InputStreamReader(in));
        String[] record = null;

        while ((record = reader.readNext()) != null) {
            // record is ONE line of the CSV
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
        return null;
    }
}
