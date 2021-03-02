import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class WordStatCountFirstIndex {
    private static boolean wordChecker(char c) {
        return Character.getType(c) == Character.DASH_PUNCTUATION 
                || Character.isLetter(c) 
                || c == '\'';
    }

    public static void main(String[] args) {
        Map<String, Tuple> wordCounter = new LinkedHashMap<>();
        try{
            Scanner sc = new Scanner(new File(args[0]));
            int line = 0;
            int counter = 0;
            try {
                while(sc.hasNext(WordStatCountFirstIndex::wordChecker)) {
                    if (!sc.isEndOfLine(WordStatCountFirstIndex::wordChecker)) {
                        String s = sc.next(WordStatCountFirstIndex::wordChecker).toLowerCase();
                        wordCounter.computeIfAbsent(s, k -> new Tuple()).add(line, ++counter);
                    } else {
                        line++;
                        counter = 0;
                    }
                }
            } finally {
                sc.close();
            }
        } catch (IOException e) {
            System.err.println("Input file error: " + e);
        }

        try {
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8));
            try {
                List<Map.Entry<String, Tuple>> result = new ArrayList<>(wordCounter.entrySet());
                result.sort(Map.Entry.comparingByValue());
                for (Map.Entry<String, Tuple> entry : result) {
                    output.write(entry.getKey());
                    output.write(" ");
                    output.write(entry.getValue().toString());
                    output.newLine();
                }
            } finally {
                output.close();
            }

        } catch (IOException e) {
            System.err.println("Output file error: " + e);
        }
    }
}

