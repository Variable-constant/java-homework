import java.util.*;
import java.io.*;

public class WordStatInput {
    public static void main(String[] args) {
        Map<String, Integer> wordCounter = new LinkedHashMap<String, Integer>();
        try{
            Reader input = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "UTF-8"));
            try {
                char[] cur = new char[2];
                int end = -1;
                char[] block = new char[256];
                int read = input.read(block);
                    while(read != -1) {
                        for (int i = 0; i < read; i++) {
                            if ((Character.getType(block[i]) == Character.DASH_PUNCTUATION) || (Character.isLetter(block[i])) || block[i] == '\'') {
                                end++;
                                if (end == cur.length) {
                                    cur = Arrays.copyOf(cur, cur.length * 2);
                                } 
                                cur[end] = block[i];
                            } else {
                                if (end != -1) {
                                    String str = new String(cur, 0, end + 1).toLowerCase();
                                    wordCounter.merge(str, 1, Integer::sum);
                                    end = -1;
                                }
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
        try {
            PrintWriter output = new PrintWriter(new File(args[1]), "UTF-8");
            try {
                String[] keys = wordCounter.keySet().toArray(new String[wordCounter.size()]);
                for (String key : keys) {
                    output.write(key);
                    output.write(" ");
                    output.write(wordCounter.get(key).toString());
                    output.write("\n");
                }
            } finally {
                output.close();
            }
        } catch (IOException e) {
            System.err.println("Output file error: " + e);
        }
    }
}