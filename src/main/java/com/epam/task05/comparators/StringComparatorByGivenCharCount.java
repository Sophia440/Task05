package com.epam.task05.comparators;

import java.util.Comparator;

public class StringComparatorByGivenCharCount implements Comparator<String> {
    private static final String REPLACEMENT_TO_COUNT_CHARACTERS = "";
    private char characterToCount;

    public StringComparatorByGivenCharCount(char characterToCount) {
        this.characterToCount = characterToCount;
    }

    @Override
    public int compare(String firstWord, String secondWord) {
        int firstWordCharCount = countGivenCharactersInWord(firstWord);
        int secondWordCharCount = countGivenCharactersInWord(secondWord);
        int compareResult = -Integer.compare(firstWordCharCount, secondWordCharCount);
        if (compareResult == 0) {
            return compareAlphabetically(firstWord, secondWord);
        }
        return compareResult;
    }

    private int compareAlphabetically(String firstWord, String secondWord) {
        int result = String.CASE_INSENSITIVE_ORDER.compare(firstWord, secondWord);
        if (result == 0) {
            result = firstWord.compareTo(secondWord);
        }
        return result;
    }

    private int countGivenCharactersInWord(String input) {
        String characterString = String.valueOf(characterToCount);
        String inputCharactersRemoved = input.replace(characterString, REPLACEMENT_TO_COUNT_CHARACTERS);
        int lengthWithoutCharacters = input.length() - inputCharactersRemoved.length();
        return lengthWithoutCharacters;
    }
}
