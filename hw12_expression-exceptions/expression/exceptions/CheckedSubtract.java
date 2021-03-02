package expression.exceptions;

import expression.AbstractOperation;
import expression.MyExpression;

public class CheckedSubtract extends AbstractOperation {
    public CheckedSubtract(MyExpression left, MyExpression right) {
        super(left, right);
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public boolean checkBrackets() {
        return true;
    }

    protected String getOperation() {
        return "-";
    }

    protected int evaluate(int x, int y) {
        int res = x - y;
        if (x > 0 && y < 0 && res < 0 ||
            x < 0 && y > 0 && res > 0 ||
            x == 0 && y == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
        return res;
    }
}
