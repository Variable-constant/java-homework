package expression;

public interface MyExpression extends DoubleExpression, TripleExpression, Expression {
    int getPriority();
    boolean checkBrackets();
}
