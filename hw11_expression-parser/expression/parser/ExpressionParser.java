package expression.parser;

import expression.*;

public class ExpressionParser extends BaseParser implements Parser{

    public ExpressionParser(StringSource stringSource) {
        super(stringSource);
    }

    public ExpressionParser() {

    }

    @Override
    public MyExpression parse(String expression) {
        changeSource(new StringSource(expression));
        nextChar();
        return parseToken(0);
    }

    private MyExpression parseToken(int priority) {
        skipWhitespace();
        if (priority == Operation.PRIORITIES.get(Operation.CONST)) {
            return parseValue();
        }

        MyExpression token = parseToken(priority + 1);

        while (true) {
            skipWhitespace();
            final Operation curOperation = Operation.SYMBOL.get(ch);
            if (curOperation == null || priority != Operation.PRIORITIES.get(curOperation)) {
                return token;
            }
            nextChar();
            token = buildOperation(token, parseToken(priority + 1), curOperation);
        }
    }




    private MyExpression parseValue() {
        if (test('(')) {
            MyExpression parsed = parseToken(0);
            skipWhitespace();
            expect(')');
            return parsed;
        } else if (test('f')) {
            return parseFlip();
        } else if (test('l')) {
            return parseLow();
        } else if (test('-')) {
            skipWhitespace();
            if (between('0', '9')) {
                return parseConst(false);
            }
            return new UnaryMinus(parseValue());
        } else if (between('0', '9')) {
            return parseConst(true);
        } else {
            return parseVariable();
        }
    }

    private MyExpression buildOperation(MyExpression left, MyExpression right,
                                            Operation oper) {
        switch (oper) {
            case ADD: return new Add(left, right);
            case SUB: return new Subtract(left, right);
            case MUL: return new Multiply(left, right);
            case DIV: return new Divide(left, right);
            case AND: return new And(left, right);
            case OR: return new Or(left, right);
            case XOR: return new Xor(left, right);
            default: return null;
        }
    }

    private MyExpression parseFlip(){
        expect("lip");
        skipWhitespace();
        return new Flip(parseValue());
    }

    private MyExpression parseLow(){
        expect("ow");
        skipWhitespace();
        return new Low(parseValue());
    }

    private MyExpression parseVariable() {
        skipWhitespace();
        final String variable = Character.toString(ch);
        nextChar();
        return new Variable(variable);
    }

    private MyExpression parseConst(boolean positive) {
        final StringBuilder sb = new StringBuilder();
        if (!positive) {
            sb.append('-');
        }
        copyInteger(sb);
        return new Const(Integer.parseInt(sb.toString()));
    }
}
