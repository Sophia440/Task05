package com.epam.task05.logic;

import com.epam.task05.comparators.CompositeComparatorByChildrenNumber;
import com.epam.task05.comparators.LeafComparatorByLength;
import com.epam.task05.entities.Component;
import com.epam.task05.entities.Composite;
import com.epam.task05.parser.ParagraphParser;
import com.epam.task05.parser.SentenceParser;
import com.epam.task05.parser.TextParser;
import com.epam.task05.reader.DataException;
import com.epam.task05.reader.DataReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextLogic {
    private DataReader reader;
    private TextParser textParser;

    public TextLogic() {
        this.reader = new DataReader();
        this.textParser = new TextParser(new ParagraphParser(new SentenceParser(null)));
    }

    public Component parseIntoComponents(String filename) throws DataException {
        String data = reader.readData(filename);
        Component text = textParser.parse(data);
        return text;
    }

    public String composeIntoString(Composite text) {
        return text.toString();
    }

    public Component sortParagraphsBySentenceCount(Composite text) {
        List<Component> paragraphs = text.getChildren();
        Collections.sort(paragraphs, new CompositeComparatorByChildrenNumber());
        return new Composite(paragraphs);
    }

    public Component sortWordsByLength(Composite text) {
        List<Component> sortedText = new ArrayList<>();
        List<Component> paragraphs = text.getChildren();
        paragraphs.stream().forEach(paragraph -> {
            List<Component> sentences = ((Composite) paragraph).getChildren();
            List<Component> sortedParagraph = new ArrayList<>();
            sentences.stream().forEach(sentence -> {
                List<Component> words = ((Composite) sentence).getChildren();
                Collections.sort(words, new LeafComparatorByLength());
                Composite sortedSentence = new Composite(words);
                sortedParagraph.add(sortedSentence);
            });
            Composite sortedParagraphs = new Composite(sortedParagraph);
            sortedText.add(sortedParagraphs);
        });
        return new Composite(sortedText);
    }

    public List<Component> sortTokensBySymbolCount() {
        return null;
    }
}
