package com.epam.task05.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite implements Component {
    private List<Component> children;

    public Composite() {
        this.children = new ArrayList<>();
    }

    public Composite(List<Component> children) {
        this.children = children;
    }

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    public Component getChild(int index) {
        return children.get(index);
    }

    public List<Component> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        StringBuilder childrenToString = new StringBuilder();
        children.stream().forEach(child -> {
            childrenToString.append(child);
            childrenToString.append(" ");
        });
        return childrenToString.toString().trim();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Composite composite = (Composite) object;
        return Objects.equals(children, composite.children);
    }

    @Override
    public int hashCode() {
        return children.hashCode();
    }
}
