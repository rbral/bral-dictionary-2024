package bral.dictionary;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws CsvValidationException, IOException {
        DictionaryFrame frame = new DictionaryFrame();
        frame.setVisible(true);
    }
}
