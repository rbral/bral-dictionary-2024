package bral.dictionary;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnglishDictionaryTest {

    @Test
    public void getDefinition() throws CsvValidationException, IOException {
        // given:
        EnglishDictionary dictionary = new EnglishDictionary();

        // when:
        List<String> definitions = dictionary.getDefinition("Aback");

        // then:
        assertEquals("Toward the back or rear; backward.", definitions.get(0));
        assertEquals("Behind; in the rear.", definitions.get(1));
        assertEquals("Backward against the mast; -- said of the sails when pressed by the wind.", definitions.get(2));
        assertEquals("An abacus.", definitions.get(3));
    }

}