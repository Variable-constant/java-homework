package expression;

import java.util.Objects;

public abstract class AbstractOperation implements MyExpression {
    private final MyExpression left, right;

    public AbstractOperation(MyExpression left, MyExpression right) {
        this.left = left;
        this.right = right;
    }

    protected abstract String getOperation();
    protected abstract int evaluate(int x, int y);
    protected abstract double evaluate(double x, double y);

    @Override
    public int evaluate(int x) {
        return evaluate(left.evaluate(x), right.evaluate(x));
    }

    @Override
    public double evaluate(double x) {
        return evaluate(left.evaluate(x), right.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return evaluate(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }

    @Override
    public String toString() {
        return "(" + left + " " + getOperation() + " " + right + ")";
    }

    @Override
    public String toMiniString() {
        String first = left.toMiniString();
        if (left.getPriority() < this.getPriority()) {
            first = "(" + first + ")";
        }
        String second = right.toMiniString();
        if (right.getPriority() < this.getPriority()
                || right.getPriority() == this.getPriority() && (this.checkBrackets() || right.checkBrackets())) {
            second = "(" + second + ")";
        }
        return first + " " + getOperation() + " " + second;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AbstractOperation) {
            AbstractOperation Operation = (AbstractOperation) obj;
            return this.getClass() == Operation.getClass()
                    && this.left.equals(Operation.left)
                    && this.right.equals(Operation.right);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(left, right, this.getClass());
    }
}
