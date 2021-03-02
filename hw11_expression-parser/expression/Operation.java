package expression;
import java.util.Map;

public enum Operation {
    AND, OR, XOR, ADD, SUB, MUL, DIV, CONST, VAR;

    public static final Map<Operation, Integer> PRIORITIES = Map.of(
            OR, 0,
            XOR,  1,
            AND, 2,
            ADD, 3,
            SUB, 3,
            MUL, 4,
            DIV, 4,
            CONST, 5,
            VAR, 5
    );

    public static final Map<Character, Operation> SYMBOL = Map.of(
            '&', AND,
            '|', OR,
            '^', XOR,
            '+', ADD,
            '-', SUB,
            '*', MUL,
            '/', DIV
    );
}
