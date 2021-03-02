public class Tuple implements Comparable<Tuple> {
    private int curLine;
    private IntList list;
    private int counter;

    Tuple() {
        curLine = -1;
        list = new IntList();
        counter = 0;
    }

    public int getSize() {
        return list.getSize();
    }

    public void add(int line, int value) {
        counter++;
        if (line != curLine) {
            list.add(value);
            curLine = line;
        }
    }

    public int getCount() {
        return counter;
    }
    
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append(getCount()).append(list.listToString());
        return new String(buf);
    }

    @Override
    public int compareTo(Tuple l) {
        return Integer.compare(this.getCount(), l.getCount());
    }
}