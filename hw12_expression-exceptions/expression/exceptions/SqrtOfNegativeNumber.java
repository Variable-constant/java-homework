package expression.exceptions;

public class SqrtOfNegativeNumber extends ExpressionException {
    public SqrtOfNegativeNumber() {
        super("Sqrt of a negative number");
    }
}
