package expression.parser;

import expression.MyExpression;

public class BaseParser {
    public static final char END = '\0';
    private CharSource source;
    protected char ch = 0xffff;

    protected BaseParser(final StringSource source) {
        this.source = source;
        nextChar();
    }

    public BaseParser() {

    }

    protected void changeSource(final StringSource source) {
        this.source = source;
    }

    protected void nextChar() {
        ch = source.hasNext() ? source.next() : END;
    }

    protected boolean test(char expected) {
        if (ch == expected) {
            nextChar();
            return true;
        }
        return false;
    }

    protected void expect(final char c) {
        if (ch != c) {
            throw error("Expected '" + c + "', found '" + ch + "'");
        }
        nextChar();
    }

    protected void expect(final String value) {
        for (char c : value.toCharArray()) {
            expect(c);
        }
    }

    protected boolean eof() {
        return test(END);
    }

    protected ParseException error(final String message) {
        return source.error(message);
    }

    protected boolean between(final char from, final char to) {
        return from <= ch && ch <= to;
    }

    protected void copyDigits(final StringBuilder sb) {
        while (between('0', '9')) {
            sb.append(ch);
            nextChar();
        }
    }

    protected void copyInteger(final StringBuilder sb) {
        if (test('-')) {
            sb.append('-');
        }
        if (test('0')) {
            sb.append('0');
        } else if (between('1', '9')) {
            copyDigits(sb);
        }
    }

    protected void skipWhitespace() {
        while (test(' ') || test('\r') || test('\n') || test('\t')) {
        }
    }
}
