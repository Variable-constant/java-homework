import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            String temp = scanner.next();
            for (int j = 0; j < n; j++) {
                a[i][j] = temp.charAt(j) - '0';
            }
        }

        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i][j] != 0) {
                    res[i][j] = 1;
                    for (int k = j + 1; k < n; k++) {
                        a[i][k] = (a[i][k] - a[j][k] + 10) % 10;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }
}
