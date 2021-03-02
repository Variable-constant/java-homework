package expression.exceptions;

import java.lang.Math;

import expression.MyExpression;
import expression.UnaryOperation;

public class CheckedSqrt extends UnaryOperation {
    public CheckedSqrt(MyExpression first) {
        super(first);
    }

    @Override
    protected int calculate(int x) {
        if (x <= 0) {
            throw new SqrtOfNegativeNumber();
        }
        return (int) Math.sqrt(x);
    }

    @Override
    protected String getOperation() {
        return "sqrt";
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
