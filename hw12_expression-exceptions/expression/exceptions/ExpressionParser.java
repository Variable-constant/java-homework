package expression.exceptions;

import expression.*;

public class ExpressionParser extends BaseParser implements Parser {

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
            final Operation curOperation =;
            if (curOperation == null) {
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
            try {
                expect(')');
            } catch (ParseException e){
                throw new MissingClosingParenthese("lol");
            }
            return parsed;
        } else if (test('-')) {
            skipWhitespace();
            if (between('0', '9')) {
                return parseConst(false);
            }
            return new CheckedNegate(parseValue());
        } else if (between('0', '9')) {
            return parseConst(true);
        } else {
            return parseVariable();
        }
    }

    private MyExpression buildOperation(MyExpression left, MyExpression right,
                                            Operation oper) {
        switch (oper) {
            case GCD: return new CheckedGCD(left, right);
            case LCM: return new CheckedLCM(left, right);
            case ADD: return new CheckedAdd(left, right);
            case SUB: return new CheckedSubtract(left, right);
            case MUL: return new CheckedMultiply(left, right);
            case DIV: return new CheckedDivide(left, right);
            default: return null;
        }
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
