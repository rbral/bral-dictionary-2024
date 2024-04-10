package bral.dictionary;

import com.opencsv.exceptions.CsvValidationException;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.IOException;
import java.util.List;

public class DictionaryFrame extends JFrame
{

    private final EnglishDictionary englishDictionary = new EnglishDictionary();


    private JTextField searchField;

    private JTextArea definitionsTextArea;

    public DictionaryFrame() throws CsvValidationException, IOException
    {
        setSize(1000, 800);
        setTitle("English Dictionary");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        // tells the JFrame to use this JPanel
        setContentPane(main);


        searchField = new JTextField("");
        main.add(searchField, BorderLayout.NORTH);

        definitionsTextArea = new JTextArea("Definitions will show here...");
        definitionsTextArea.setEditable(false);
        definitionsTextArea.setLineWrap(true);
        definitionsTextArea.setWrapStyleWord(true);
        main.add(definitionsTextArea, BorderLayout.CENTER);

        searchField.getDocument().addDocumentListener((new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                reDisplay();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                reDisplay();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                reDisplay();
            }

        }));

    }

    private void reDisplay()
    {
        // clear the old contents:
        definitionsTextArea.setText("");
        String currWord = searchField.getText();
        List<String> currDefinitions = englishDictionary.getDefinition(currWord);
        for (String definition : currDefinitions)
        {
            definitionsTextArea.append(definition + "\n\n");
        }
    }

}
