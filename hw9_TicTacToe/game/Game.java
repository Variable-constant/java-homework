package game;

import java.util.Scanner;

public class  Game {
    private final boolean log;
    private final Player player1, player2;
    private final IOController controller;

    public Game(final boolean log, final Player player1, final Player player2) {
        this(log, player1, player2, new IOController());
    }

    public Game(final boolean log, final Player player1, final Player player2, IOController controller) {
        this.log = log;
        this.player1 = player1;
        this.player2 = player2;
        this.controller = controller;
    }

    public int play() {
        Board board = chooseBoard();
        while (true) {
            int result = 3;
            while (result == 3) {
                result = move(board, player1, 1);
                if (result != -1 && result != 3) {
                    log("Final position\n" + board.getPosition());
                    return result;
                }
            }
            result = 3;
            while (result == 3) {
                result = move(board, player2, 2);
                if (result != -1 && result != 3) {
                    log("Final position\n" + board.getPosition());
                    return result;
                }
            }
        }
    }

    private Board chooseBoard() {
        while (true) {
            controller.writeMessage("Choose a board for the game");
            controller.writeMessage("Type 1 for classical mnk Board, type 2 for rhombus board");
            int choice = controller.getValue("value");
            if (choice == 1) {
                return new MNKBoard();
            } else if (choice == 2) {
                return new RhombusBoard();
            } else {
                controller.writeMessage("Choose 1 or 2!");
            }
        }
    }

    private int move(final Board board, final Player player, final int no) {
        final Move move = player.move(board.getPosition(), board.getCell());
        final Result result = board.makeMove(move);
        log("Game.Player " + no + " move: " + move);
        log("Game.Position:\n" + board.getPosition());
        if (result == Result.WIN) {
            log("Game.Player " + no + " won");
            return no;
        } else if (result == Result.LOSE) {
            log("Game.Player " + no + " lose");
            return 3 - no;
        } else if (result == Result.DRAW) {
            log("Draw");
            return 0;
        } else if (result == Result.REPEAT) {
            log("One more turn");
            return 3;
        } else {
            return -1;
        }
    }

    private void log(final String message) {
        if (log) {
            controller.writeMessage(message);
        }
    }
}
