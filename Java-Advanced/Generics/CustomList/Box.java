package Generics.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void addElement(T element) {
        this.list.add(element);
    }

    public void removeElement(int index) {
            this.list.remove(index);
    }

    public boolean containsElement(T element) {
        return this.list.contains(element);
    }

    public void swapElements(int firstElement, int secondElement) {
            T first = this.list.get(firstElement);
            this.list.set(firstElement, this.list.get(secondElement));
            this.list.set(secondElement, first);
    }

    public int greaterThan(T element) {
        int count = (int) this.list.stream().filter(e -> e.compareTo(element) > 0).count();
        return count;
    }

    public T getMax() {
        if (!this.list.isEmpty()) {
            return Collections.max(this.list);
        }
        return null;
    }

    public T getMin() {
        if (!this.list.isEmpty()) {
            return Collections.min(this.list);
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T element : list) {
            sb.append(element).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
