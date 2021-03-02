package game;

import java.lang.Math;

public class RhombusBoard extends MNKBoard {
    private int size;

    public RhombusBoard() {
        super();
    }

    public RhombusBoard(IOController controller) {
        super(controller);
    }

    @Override
    protected void readValues() {
        while (true) {
            controller.writeMessage("Enter rhombus size and k");
            size = controller.getValue("size");
            k = controller.getValue("k");
            if (size > 0 && k > 0 && (2 * size + 1 >= k)) {
                m = 2 * size + 1;
                n = m;
                break;
            }
            controller.writeMessage("It should be integers and 2 * size + 1 should be greater or equal to k");
        }
    }

    @Override
    protected void fill() {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (Math.abs(r - size) + Math.abs(c - size) > size) {
                    cells[r][c] = Cell.R;
                    empty--;
                } else {
                    cells[r][c] = Cell.E;
                }
            }
        }
    }
}

