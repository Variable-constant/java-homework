package expression.exceptions;

import expression.AbstractOperation;
import expression.Const;
import expression.MyExpression;

public class CheckedLCM extends AbstractOperation {
    public CheckedLCM(MyExpression left, MyExpression right) {
        super(left, right);
    }

    protected String getOperation() {
        return "lcm";
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
        int res = (new CheckedGCD(new Const(x), new Const(y))).evaluate(0);
        res = (new CheckedDivide(new Const(x), new Const(res))).evaluate(0);
        res = (new CheckedMultiply(new Const(y), new Const(res))).evaluate(0);
        return res;
    }
}
