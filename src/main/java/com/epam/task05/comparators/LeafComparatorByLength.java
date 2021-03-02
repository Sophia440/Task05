package com.epam.task05.comparators;

import com.epam.task05.entities.Component;
import com.epam.task05.entities.Leaf;

import java.util.Comparator;

public class LeafComparatorByLength implements Comparator<Component> {

    @Override
    public int compare(Component firstLeaf, Component secondLeaf) {
        String firstToken = ((Leaf) firstLeaf).getToken();
        String secondToken = ((Leaf) secondLeaf).getToken();
        int firstLength = firstToken.length();
        int secondLength = secondToken.length();
        return Integer.compare(firstLength, secondLength);
    }
}