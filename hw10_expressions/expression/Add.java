package expression;

public class Add extends AbstractOperation{

    public Add(MyExpression left, MyExpression right) {
        super(left, right);
    }

    protected String getOperation() {
        return "+";
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public boolean checkBrackets() {
        return false;
    }

    @Override
    protected int evaluate(int x, int y) {
        return x + y;
    }

    @Override
    protected double evaluate(double x, double y) {
        return x + y;
    }
}
