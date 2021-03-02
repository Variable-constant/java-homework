package expression.exceptions;

import expression.MyExpression;
import expression.UnaryOperation;

public class CheckedAbs extends UnaryOperation {
    public CheckedAbs(MyExpression first) {
        super(first);
    }

    @Override
    protected int calculate(int x) {
        if (x == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
        return x > 0 ? x : -x;
    }

    @Override
    protected String getOperation() {
        return "abs";
    }

    @Override
    public int getPriority() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean checkBrackets() {
        return false;
    }
}
