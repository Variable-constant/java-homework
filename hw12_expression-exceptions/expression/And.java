package expression;

public class And extends AbstractOperation{
    public And(MyExpression left, MyExpression right) {
        super(left, right);
    }

    protected String getOperation() {
        return "&";
    }

    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public boolean checkBrackets() {
        return false;
    }

    @Override
    protected int evaluate(int x, int y) {
        return x & y;
    }
}
