package expression;

public class Or extends AbstractOperation{
    public Or(MyExpression left, MyExpression right) {
        super(left, right);
    }

    protected String getOperation() {
        return "|";
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
        return x | y;
    }
}