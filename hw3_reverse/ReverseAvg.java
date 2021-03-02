import java.util.*;
import java.io.*;

public class ReverseAvg {
    public static void main(String[] args){
        int row = 0, max = 2;
        int[][] result = new int[max][];
        int[] cntColumn = new int[max];
        long[] sumColumn = new long[max];
        long[] sumRow = new long[max];
        Scanner scanIn = new Scanner(System.in);
        int[] t = new int[max];
        while (scanIn.hasNextLine()) {
            int column = 0;
            Scanner currentLine = new Scanner(scanIn.nextLine());
            while (currentLine.hasNextInt()) {
                if (column == t.length) {
                    t = Arrays.copyOf(t, 2 * t.length);
                }
                t[column] = currentLine.nextInt();
                if (column == max) {
                    max *= 2;
                    cntColumn = Arrays.copyOf(cntColumn, max);
                    sumColumn = Arrays.copyOf(sumColumn, max);
                }
                sumColumn[column] += t[column];
                sumRow[row] += t[column]; 
                cntColumn[column] += 1;
                column++;
            }
            if (row + 1 == result.length) {
                result = Arrays.copyOf(result, 2 * result.length);
                sumRow = Arrays.copyOf(sumRow, 2 * result.length);
            }
            result[row] = Arrays.copyOf(t, column);
            row++;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print((sumRow[i] + sumColumn[j] - result[i][j]) / (cntColumn[j] + result[i].length - 1));
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}