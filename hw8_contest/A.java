import java.util.Scanner;
public class A {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int n = scanner.nextInt();
    System.out.println(2 * ((n - a - 1) / (b - a)) + 1);
    }
}
