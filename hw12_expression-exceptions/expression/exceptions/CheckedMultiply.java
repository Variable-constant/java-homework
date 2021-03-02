package expression.exceptions;

import expression.AbstractOperation;
import expression.MyExpression;

public class CheckedMultiply extends AbstractOperation {

    public CheckedMultiply(MyExpression left, MyExpression right) {
        super(left, right);
    }

    protected String getOperation() {
        return "*";
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public boolean checkBrackets() {
        return false;
    }

    protected int evaluate(int x, int y) {
        int res = x * y;
        if (x != 0 && y != 0 && (res / x != y || res / y != x)) {
            throw new OverflowException();
        }
        return res;
    }
}
