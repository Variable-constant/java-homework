package expression.exceptions;

import expression.MyExpression;
import expression.UnaryOperation;

public class CheckedNegate extends UnaryOperation {
    public CheckedNegate(MyExpression first) {
        super(first);
    }

    @Override
    protected int calculate(int x) {
        if (x == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
        return -x;
    }

    @Override
    protected String getOperation() {
        return "-";
    }

    @Override
    public int getPriority() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean checkBrackets() {
        return true;
    }
}
