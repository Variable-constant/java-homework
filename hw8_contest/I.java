import java.util.Scanner;
import java.lang.Math;
public class I {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int xl = Integer.MAX_VALUE;
        int xr = Integer.MIN_VALUE;
        int yl = Integer.MAX_VALUE;
        int yr = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int h = scanner.nextInt();
            xl = Math.min(x - h, xl);
            xr = Math.max(x + h, xr);
            yl = Math.min(y - h, yl);
            yr = Math.max(y + h, yr);
        }
        int h = (Math.max(xr - xl, yr - yl) + 1) / 2;
        int x = (xl + xr) / 2;
        int y = (yl + yr) / 2;
        System.out.println(x + " " + y + " " + h);
    }
}
