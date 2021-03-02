package expression;

public final class UnaryMinus extends UnaryOperation {

    public UnaryMinus(MyExpression first) {
        super(first);
    }

    @Override
    protected int calculate(int x) {
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