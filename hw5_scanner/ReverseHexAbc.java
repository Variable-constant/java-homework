import java.util.*;
import java.io.*;

public class ReverseHexAbc {
    private static boolean wordChecker(char c) {
        return Character.isDigit(c) || c == '-' || Character.isLetter(c);
    }
    public static void main(String[] args){
        int row = 0, max = 2;
        int[][] result = new int[max][];
        int[] t = new int[max];
        try (Scanner scanIn = new Scanner(System.in)) {
            while (scanIn.hasNextInt(ReverseHexAbc::wordChecker) || scanIn.hasLine()) {
                int column = 0;
                while (!scanIn.isEndOfLine(ReverseHexAbc::wordChecker)) {
                    if (column == t.length) {
                        t = Arrays.copyOf(t, 2 * t.length);
                    }
                    t[column] = scanIn.nextInt(ReverseHexAbc::wordChecker);
                    column++;
                }
                if (row + 1 == result.length) {
                    result = Arrays.copyOf(result, 2 * result.length);
                }
                result[row] = Arrays.copyOf(t, column);
                row++;
            }
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = result[i].length - 1; j >= 0; j--) {
                System.out.print(result[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}