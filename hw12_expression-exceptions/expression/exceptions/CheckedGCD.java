package expression.exceptions;

import expression.AbstractOperation;
import expression.MyExpression;

public class CheckedGCD extends AbstractOperation {
    public CheckedGCD(MyExpression left, MyExpression right) {
        super(left, right);
    }

    protected String getOperation() {
        return "gcd";
    }

    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public boolean checkBrackets() {
        return true;
    }

    protected int evaluate(int x, int y) {
        int res = gcd(x, y);
        if (x == Integer.MIN_VALUE && y == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
        return res > 0 ? res : -res;
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(x, x % y);
    }
}
