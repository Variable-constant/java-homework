package expression;

public final class Low extends UnaryOperation {

    public Low(MyExpression first) {
        super(first);
    }

    @Override
    protected int calculate(int x) {
        return Integer.lowestOneBit(x);
    }

    @Override
    protected String getOperation() {
        return "low";
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