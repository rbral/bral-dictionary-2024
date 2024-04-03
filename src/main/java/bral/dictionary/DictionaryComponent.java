package bral.dictionary;

import javax.swing.*;
import java.awt.*;

public class DictionaryComponent extends JComponent
{
    private final EnglishDictionary englishDictionary;

    public DictionaryComponent(EnglishDictionary englishDictionary)
    {
        this.englishDictionary = englishDictionary;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
    }

}
