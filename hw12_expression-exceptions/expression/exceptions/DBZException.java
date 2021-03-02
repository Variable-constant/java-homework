package expression.exceptions;

public class DBZException extends ExpressionException {
    public DBZException() {
        super("Division by zero");
    }
}
