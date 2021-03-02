package game;

public class Main {
    final static IOController controller = new IOController();

    public static Player getPlayer(int no) {
        while (true) {
            int choice = controller.getValue("player " + no);
            if (choice >= 0 && choice <= 3) {
                switch (choice) {
                    case 1:
                        return new RandomPlayer();
                    case 2:
                        return new SequentialPlayer();
                    case 3:
                        return new HumanPlayer();
                }
            }
            controller.writeMessage("It should be value from 1 to 3");
        }
    }

    public static void main(String[] args) {
        controller.writeMessage("Choose players for the game, 1 - for random player, 2 - for sequential, 3 - for human");
        try {
            final Game game = new Game(true, getPlayer(1), getPlayer(2));
            int result;
            do {
                result = game.play();
                System.out.println("Game.Game result: " + result);
            } while (result != 0);
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }
}
