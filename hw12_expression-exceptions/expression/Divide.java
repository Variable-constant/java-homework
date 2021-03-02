package expression;

public class Divide extends AbstractOperation{
    public Divide(MyExpression left, MyExpression right) {
        super(left, right);
    }

    protected String getOperation() {
        return "/";
    }

    @Override
    public int getPriority() {
        return 4;
    }

    @Override
    public boolean checkBrackets() {
        return true;
    }

    protected int evaluate(int x, int y) {
        return x / y;
    }
}
