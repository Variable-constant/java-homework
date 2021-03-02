package expression;

import java.util.Objects;

public abstract class UnaryOperation implements MyExpression {
    protected final MyExpression expression;

    public UnaryOperation(MyExpression expression) {
        this.expression = expression;
    }

    protected abstract int calculate(int x);
    protected abstract String getOperation();

    @Override
    public int evaluate(int x, int y, int z) {
        return calculate(expression.evaluate(x, y, z));
    }

    @Override
    public int evaluate(int x) {
        return calculate(expression.evaluate(x));
    }

    @Override
    public String toString() {
        return "(" + getOperation() + expression + ")";
    }

    @Override
    public String toMiniString() {
        if (this.checkBrackets()) {
            return "(" + getOperation() + expression.toMiniString() + ")";
        } else {
            return expression.toMiniString();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression, getOperation());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UnaryOperation) {
            UnaryOperation Operation = (UnaryOperation) obj;
            return this.getClass() == Operation.getClass()
                    && this.expression.equals(Operation.expression);
        }
        return false;
    }
}

