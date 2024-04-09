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
    private final DefinitionsComponent definitionsComponent;
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

        definitionsComponent = new DefinitionsComponent(englishDictionary.getDefinition(""));
        add(definitionsComponent, BorderLayout.CENTER);

        searchField = new JTextField("");
        main.add(searchField, BorderLayout.NORTH);

        definitionsTextArea = new JTextArea("Definitions will show here...");
        definitionsTextArea.setEditable(false);
        definitionsTextArea.setLineWrap(true);
        definitionsTextArea.setWrapStyleWord(true);
//        definitionsTextArea.setPreferredSize();
        main.add(definitionsTextArea, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(definitionsTextArea);
//        scrollPane.setPreferredSize(new Dimension(1000, 800));
        main.add(scrollPane, BorderLayout.CENTER);

//        main.add(definitionsTextArea, BorderLayout.CENTER);

        // redisplay as user enters new word:
        /*searchField.getDocument().addDocumentListener((SimpleDocumentListener) e -> reDisplay());
        searchField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                reDisplay();
            }
        });*/
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
        try
        {

            String currWord = searchField.getText();
            // update the definitionsComponent based on the current word:
            List<String> currDefinitions = englishDictionary.getDefinition(currWord);
//            definitionsComponent.setCurrDefinitions(currDefinitions);

            // clear the old contents:
            definitionsTextArea.setText("");
            for (String definition : currDefinitions)
            {
                definitionsTextArea.append(definition + "\n\n");
            }
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }

    }

}
