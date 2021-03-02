package expression;

public interface MyExpression extends TripleExpression, Expression {
    int getPriority();
    boolean checkBrackets();
}
