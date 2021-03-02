package game;

import java.io.PrintStream;
import java.util.Scanner;

public class IOController {
    private final PrintStream out;
    private final Scanner in;

    public IOController(PrintStream out, Scanner in) {
        this.out = out;
        this.in = in;
    }

    public IOController() {
        this(System.out, new Scanner(System.in));
    }

    public int getValue(String s) {
        while (true) {
            out.print("Enter " + s + ": ");
            try {
                if (!in.hasNextLine()) {
                    throw new IllegalStateException("Input is closed");
                }
                return Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                out.println("Input one integer, without anything else!");
            }
        }
    }

    public void writeMessage(String s) {
        out.println(s);
    }
}
