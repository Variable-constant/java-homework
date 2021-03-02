package expression;

public class Xor extends AbstractOperation{
    public Xor(MyExpression left, MyExpression right) {
        super(left, right);
    }

    protected String getOperation() {
        return "^";
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public boolean checkBrackets() {
        return false;
    }

    @Override
    protected int evaluate(int x, int y) {
        return x ^ y;
    }
}