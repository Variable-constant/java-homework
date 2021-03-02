import java.util.Scanner;
public class B {
    public static void main(String[] args) {
        int st = 710, start = -25000;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = start; i < start + n; i++) {
            System.out.println(i * st);
        }
    }
}
