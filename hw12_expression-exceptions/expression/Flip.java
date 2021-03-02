package expression;

import jdk.jfr.Unsigned;

public final class Flip extends UnaryOperation {

    public Flip(MyExpression first) {
        super(first);
    }

    @Override
    protected int calculate(int x) {
        long res = Integer.toUnsignedLong(Integer.reverse(x));
        return res != 0 ? (int) (res / Long.lowestOneBit(res)) : 0;
    }

    @Override
    protected String getOperation() {
        return "flip";
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