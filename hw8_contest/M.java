import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class M {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            int n = scanner.nextInt();
            int[] curTest = new int[n];
            for (int i = 0; i < n; i++) {
                curTest[i] = scanner.nextInt();
            }
            int res = 0;
            Map<Integer, Integer> C = new HashMap<>();
            for (int j = n - 1; j >= 0; j--) {
                for (int i = 0; i < j; i++) {
                    int value = 2 * curTest[j] - curTest[i];
                    if (C.get(value) != null) {
                        res += C.get(value);
                    }
                }
                C.merge(curTest[j], 1, Integer::sum);
            }
            System.out.println(res);
            t--;
        }
    }
}
