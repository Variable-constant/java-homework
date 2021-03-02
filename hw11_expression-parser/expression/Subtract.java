package expression;

public class Subtract extends AbstractOperation {

    public Subtract(MyExpression left, MyExpression right) {
        super(left, right);
    }

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public boolean checkBrackets() {
        return true;
    }

    protected String getOperation() {
        return "-";
    }

    protected int evaluate(int x, int y) {
        return x - y;
    }
}
