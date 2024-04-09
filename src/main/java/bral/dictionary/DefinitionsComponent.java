package bral.dictionary;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DefinitionsComponent extends JComponent
{
//    private final EnglishDictionary englishDictionary;
    private List<String> currDefinitions;

    public DefinitionsComponent(java.util.List<String> currDefinitions)
    {
//        this.englishDictionary = englishDictionary;
        this.currDefinitions = currDefinitions;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);

        /*
        Please note:
        comments will be deleted; they are only here to show
        the effort I invested.

        for (String definition : currDefinitions)
        {
            g.drawString(definition);
        }*/
    }

    /*public void setCurrDefinitions(java.util.List<String> currDefinitions)
    {
        this.currDefinitions = currDefinitions;
        repaint();
    }*/

}
