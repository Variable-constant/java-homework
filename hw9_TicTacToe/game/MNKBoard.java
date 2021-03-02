package game;

import java.util.Arrays;
import java.util.Map;

public class MNKBoard implements Board {
    private static final Map<Cell, Character> SYMBOLS = Map.of(
            Cell.X, 'X',
            Cell.O, 'O',
            Cell.E, '.',
            Cell.R, ' '
    );

    protected final Cell[][] cells;
    protected final IOController controller;
    private Cell turn;
    protected int m, n, k, empty;
    private final int nLength, mLength;
    private final String nSpaces, mSpaces;

    private final Position position = new Position() {
        @Override
        public boolean isValid(final Move move) {
            return move != null &&
                    0 <= move.getRow() && move.getRow() < m
                    && 0 <= move.getColumn() && move.getColumn() < n
                    && getCell(move.getRow(), move.getColumn()) == Cell.E
                    && turn == move.getValue()
                    && getCell(move.getRow(), move.getColumn()) != Cell.R;
        }

        @Override
        public Cell getCell(final int r, final int c) {
            return cells[r][c];
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(mSpaces);
            for (int c = 0; c < n; c++) {
                sb.append(" ".repeat(nLength + 1 - Integer.toString(c).length())).append(c);
            }
            for (int r = 0; r < m; r++) {
                sb.append("\n");
                sb.append(" ".repeat(mLength - Integer.toString(r).length())).append(r);
                for (int c = 0; c < n; c++) {
                    sb.append(nSpaces).append(SYMBOLS.get(cells[r][c]));
                }
            }
            return sb.toString();
        }

        @Override
        public int getM() {
            return m;
        }

        @Override
        public int getN() {
            return n;
        }
    };

    public MNKBoard(IOController controller) {
        this.controller = controller;
        readValues();
        nLength = Integer.toString(n - 1).length();
        mLength = Integer.toString(m - 1).length();
        nSpaces = " ".repeat(nLength);
        mSpaces = " ".repeat(mLength);
        empty = m * n;
        this.cells = new Cell[m][n];
        fill();
        turn = Cell.X;
    }

    public MNKBoard() {
        this(new IOController());
    }

    protected void readValues() {
        while (true) {
            controller.writeMessage("Input m, n, k for the board");
            m = controller.getValue("m");
            n = controller.getValue("n");
            k = controller.getValue("k");
            if (m > 0 && n > 0 && k > 0 && (m >= k || n >= k))
                break;
            controller.writeMessage("It should be positive values and k should be less or equal to board side");
        }
    }

    protected void fill() {
        for (Cell[] row : cells) {
            Arrays.fill(row, Cell.E);
        }
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public Cell getCell() {
        return turn;
    }

    @Override
    public Result makeMove(final Move move) {
        if (!position.isValid(move)) {
            return Result.LOSE;
        }
        cells[move.getRow()][move.getColumn()] = move.getValue();
        empty--;
        if (hasWin(move)) {
            return Result.WIN;
        } else if (empty == 0) {
            return Result.DRAW;
        } else if (hasSequence(move, 4)) {
            return Result.REPEAT;
        }
        turn = turn == Cell.X ? Cell.O : Cell.X;
        return Result.UNKNOWN;
    }

    private boolean hasWin(Move move) {
            return hasSequence(move, k);
    }

    private boolean hasSequence(Move move, int s) {
        return checkDirections(move, 0, 1, s)
                || checkDirections(move, 1, 0, s)
                || checkDirections(move, 1, 1, s)
                || checkDirections(move, -1, 1, s);
    }

    private boolean checkDirections(Move move, int dRow, int dColumn, int s) {
        return countCells(move, dRow, dColumn)
                + countCells(move, -dRow, -dColumn) + 1>= s;
    }

    private int countCells(Move move, int dRow, int dColumn) {
        int count = 0;
        int curRow = move.getRow() + dRow, curColumn = move.getColumn() + dColumn;
        while (curRow < m && curColumn < n
                && curRow >= 0 && curColumn >= 0
                && cells[curRow][curColumn] == turn) {
            count++;
            curRow += dRow;
            curColumn += dColumn;
        }
        return count;
    }
}
