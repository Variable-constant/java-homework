package expression;

public class Const implements MyExpression {
    private final Number value;

    public Const(int x) {
        this.value = x;
    }

    public Const(double x) {
        this.value = x;
    }

    public int evaluate(int x) {
        return this.value.intValue();
    }

    public int evaluate(int x, int y, int z) {
        return this.value.intValue();
    }

    public String toString() {
        return this.value.toString();
    }

    public String toMiniString() {
        return toString();
    }

    @Override
    public int getPriority() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean checkBrackets() {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Const) {
            return ((Const) obj).value.equals(this.value);
        }
        return false;
    }

    public int hashCode() {
        return this.value.hashCode();
    }
}
