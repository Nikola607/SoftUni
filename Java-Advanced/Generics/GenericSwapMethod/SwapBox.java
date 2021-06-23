package Generics.GenericSwapMethod;

import java.util.ArrayList;
import java.util.List;

public class SwapBox<T> {
    private List<T> values;

    public SwapBox() {
        this.values = new ArrayList<>();
    }

    public void addElements(T element) {
        this.values.add(element);
    }

    public void swapElements(int indexOne, int indexTwo) {

        T firstElement = this.values.get(indexOne);
        values.set(indexOne, this.values.get(indexTwo));
        values.set(indexTwo, firstElement);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T value : values) {
            sb.append(String.format("%s: %s\n", value.getClass().getName(), value));
        }
        return sb.toString();
    }
}
