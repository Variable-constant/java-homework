import java.util.*;

public class IntList {
    private int[] list;
    private int i;

    IntList() {
        list = new int[1];
        i = 0;
    }

    public int getSize() {
        return i;
    }

    public void add(int newElement) {
        if (list.length == i) {
            resize();
        }
        list[i++] = newElement;
    }

    private void resize() {
        list = Arrays.copyOf(list, list.length * 2);
    }
    
    public StringBuilder listToString() {
        StringBuilder buf = new StringBuilder();
        for (int j = 0; j < i; j++) {
            buf.append(" ").append(list[j]);
        }
        return buf;
    }
}