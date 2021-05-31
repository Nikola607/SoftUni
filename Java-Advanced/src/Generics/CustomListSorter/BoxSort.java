package Generics.CustomListSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoxSort<T extends Comparable<T>> {
    private List<T> list;

    public BoxSort() {
        this.list = new ArrayList<>();
    }

    public void addElement(T element) {
        this.list.add(element);
    }

    public void removeElement(int index) {
        if (index>=0 && index<list.size()) {
            this.list.remove(index);
        }
    }

    public boolean containsElement(T element) {
        return this.list.contains(element);
    }

    public void swapElements(int firstElement, int secondElement) {
        if (firstElement >= 0 && firstElement < this.list.size() &&
                secondElement >= 0 && secondElement < this.list.size()) {
            T first = this.list.get(firstElement);
            this.list.set(firstElement, this.list.get(secondElement));
            this.list.set(secondElement, first);
        }
    }

    public long greaterThan(T element) {
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

    public void sorter(){
        if(!this.list.isEmpty()) {
            this.list.sort(Comparable::compareTo);
        }
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
