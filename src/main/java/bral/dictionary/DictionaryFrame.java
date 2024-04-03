package bral.dictionary;

import com.opencsv.exceptions.CsvValidationException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class DictionaryFrame extends JFrame
{
    private final EnglishDictionary englishDictionary = new EnglishDictionary();
    public DictionaryFrame() throws CsvValidationException, IOException {
        setSize(800, 600);
        setTitle("English Dictionary");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        // tells the JFrame to use this JPanel
        setContentPane(main);

        DictionaryComponent dictionaryComponent = new DictionaryComponent(englishDictionary);
        add(dictionaryComponent, BorderLayout.CENTER);

        JTextField searchField = new JTextField("WORD");
        main.add(searchField, BorderLayout.NORTH);

        JTextArea definitionsTextArea = new JTextArea("Lorem Ipsum...");
        definitionsTextArea.setEditable(false);
        main.add(definitionsTextArea, BorderLayout.CENTER);

    }

}
