package expression.exceptions;

public class MissingClosingParenthese extends ExpressionException {
    public MissingClosingParenthese(String message) {
        super("Missing parenthese at the and of expression" + message);
    }
}
