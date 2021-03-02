package expression.exceptions;

public class ParseException extends RuntimeException {
    public ParseException(String message, int position) {
        super(message + "; position " + position);
    }
}
