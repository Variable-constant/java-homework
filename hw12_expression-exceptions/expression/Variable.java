package expression;

public class Variable implements MyExpression {
    private final String variable;
    public Variable(String x) {
        this.variable = x;
    }

    public int evaluate(int x) {
        return x;
    }

    public int evaluate(int x, int y, int z) {
        switch (variable) {
            case "x": return x;
            case "y": return y;
            case "z": return z;
            default: return 0;
        }
    }

    public String toString() {
        return this.variable;
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
        if (obj instanceof Variable) {
            Variable v = (Variable) obj;
            return this.variable.equals(v.variable);
        }
        return false;
    }
    public int hashCode() {
        return this.variable.hashCode();
    }
}
