package Generics.GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box(){
        this.values = new ArrayList<>();
    }

    public void addElements(T element){
        this.values.add(element);
    }

    public int compare(T element){
        int count = (int) this.values.stream().filter(e -> e.compareTo(element) > 0).count();

        return count;
    }

}
