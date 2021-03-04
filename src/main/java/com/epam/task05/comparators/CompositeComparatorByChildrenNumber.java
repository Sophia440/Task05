package com.epam.task05.comparators;

import com.epam.task05.entities.Component;
import com.epam.task05.entities.Composite;

import java.util.Comparator;
import java.util.List;

public class CompositeComparatorByChildrenNumber implements Comparator<Component> {

    @Override
    public int compare(Component firstComposite, Component secondComposite) {
        List<Component> firstChildren = ((Composite) firstComposite).getChildren();
        List<Component> secondChildren = ((Composite) secondComposite).getChildren();
        int firstLength = firstChildren.size();
        int secondLength = secondChildren.size();
        return Integer.compare(firstLength, secondLength);
    }
}