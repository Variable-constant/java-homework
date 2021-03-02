import java.math.BigInteger;

public class SumBigIntegerSpace {
    public static void main(String[] args) {
        BigInteger result = BigInteger.ZERO;
        for (String arg : args) {
            int left = 0;
            for (int right = 0; right <= arg.length(); right++) {
                if (right == arg.length() || Character.SPACE_SEPARATOR == Character.getType(arg.charAt(right))) {
                    if (left != right) {
                        result = result.add(new BigInteger(arg.substring(left, right)));
                    }
                    left = right + 1;
                }
            }
        }
        System.out.println(result);
    }
}