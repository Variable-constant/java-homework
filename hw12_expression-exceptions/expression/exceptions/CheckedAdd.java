package expression.exceptions;

import expression.AbstractOperation;
import expression.MyExpression;

public class CheckedAdd extends AbstractOperation{
    public CheckedAdd(MyExpression left, MyExpression right) {
        super(left, right);
    }

    protected String getOperation() {
        return "+";
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public boolean checkBrackets() {
        return false;
    }

    @Override
    protected int evaluate(int x, int y) {
        int res = x + y;
        if (x > 0 && y > 0 && res < 0 ||
            x < 0 && y < 0 && res > 0) {
            throw new OverflowException();
        }
        return res;
    }
}
