package game;

public class HumanPlayer implements Player {
    IOController controller;

    public HumanPlayer(IOController controller) {
        this.controller = controller;
    }

    public HumanPlayer() {
        this(new IOController());
    }

    @Override
    public Move move(final Position position, final Cell cell) {
        while (true) {
            controller.writeMessage("Game.Position");
            controller.writeMessage(position + "");
            controller.writeMessage(cell + "'s move");
            int r = controller.getValue("row");
            int c = controller.getValue("column");
            final Move move = new Move(r, c, cell);
            if (position.isValid(move)) {
                return move;
            }
            controller.writeMessage("Move " + move + " is incorrect. Try again");
        }
    }
}
