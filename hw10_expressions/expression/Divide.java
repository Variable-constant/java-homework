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
        return 1;
    }

    @Override
    public boolean checkBrackets() {
        return true;
    }

    protected int evaluate(int x, int y) {
        return x / y;
    }

    protected double evaluate(double x, double y) {
        return x / y;
    }
}
