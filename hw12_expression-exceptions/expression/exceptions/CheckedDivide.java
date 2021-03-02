package expression.exceptions;

import expression.AbstractOperation;
import expression.MyExpression;

public class CheckedDivide extends AbstractOperation {
    public CheckedDivide(MyExpression left, MyExpression right) {
        super(left, right);
    }

    protected String getOperation() {
        return "/";
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public boolean checkBrackets() {
        return true;
    }

    protected int evaluate(int x, int y) {
        if (y == 0) {
            throw new DBZException();
        }
        if (x == Integer.MIN_VALUE && y == -1) {
            throw new OverflowException();
        }
        return x / y;
    }
}
