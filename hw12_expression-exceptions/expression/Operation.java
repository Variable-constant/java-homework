package expression;
import java.util.Map;

public enum Operation {
    ADD, SUB, MUL, DIV, GCD, LCM, CONST, VAR;

    public static final Map<Operation, Integer> PRIORITIES = Map.of(
            ADD, 0,
            SUB, 0,
            MUL, 1,
            DIV, 1,
            GCD, 2,
            LCM, 2,
            CONST, 3,
            VAR, 3
    );

}
