import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

class Pair implements Comparable<Pair> {
    int value;
    String key;
    public Pair(String key, int value) {
        this.value = value;
        this.key = key;
    }
    @Override
    public int compareTo(Pair x) {
        return Integer.compare(this.value, x.value);
    }
}

public class WordStatCountShingles {
    public static void main(String[] args) {
        Map<String, Integer> wordCounter = new LinkedHashMap<>();
        try{
            Reader input = new InputStreamReader(new FileInputStream(args[0]), StandardCharsets.UTF_8);
            try {
                int end = 0, range = 3;
                char[] cur = new char[range];
                char[] block = new char[256];
                int read = input.read(block);
                    while(read != -1) {
                        for (int i = 0; i < read; i++) {
                            if ((Character.getType(block[i]) == Character.DASH_PUNCTUATION) || (Character.isLetter(block[i])) || block[i] == '\'') {
                                for (int j = 0; j < range - 1; j++) {
                                    cur[j] = cur[j + 1];
                                }
                                cur[range - 1] = Character.toLowerCase(block[i]);
                                end += 1;
                                if (end == range) {
                                    String str = new String(cur, 0, range);
                                    wordCounter.merge(str, 1, Integer::sum);
                                    end -= 1;
                                }
                            } else {
                                end = 0;  
                            }
                        }
                        read = input.read(block);
                    }
                }
            finally {
                input.close();
            }
        }
        catch (IOException e) {
            System.err.println("Input file error: " + e);
        }
        int i = 0;
        Pair[] pair = new Pair[wordCounter.size()];
        for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
            pair[i++] = new Pair(entry.getKey(), entry.getValue());
        }
        Arrays.sort(pair);
        try {
            PrintWriter output = new PrintWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8));
            try {
                for (Pair x : pair) {
                    output.print(x.key);
                    output.print(" ");
                    output.print(String.valueOf(x.value));
                    output.println();
                }
            } finally {
                output.close();
            }
        
        } catch (IOException e) {
            System.err.println("Output file error: " + e);
        }
    }
}