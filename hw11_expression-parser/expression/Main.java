package expression;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new Add(
                new Const(5),
                new Subtract(
                        new Const(2),
                        new Const(3)
                )).toMiniString());
    }
}
