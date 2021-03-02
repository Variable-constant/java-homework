package expression.parser;

import expression.*;

public class Main {
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser(new StringSource("((x + z) + y)"));
        System.out.println(Operation.SYMBOL.get(" "));
    }
}
