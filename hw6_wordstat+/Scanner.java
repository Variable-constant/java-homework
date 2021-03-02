import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
public class Scanner implements AutoCloseable{
    private int nextInt;
    private BufferedReader in;
    private int last;
    private int lineBreaks = 0;
    private String token = null;
    private boolean endOfLine = false;

    //interface
    public interface Checker {
        boolean check(char c);
    }

    //constructors
    Scanner(File file) throws IOException {
        this(new FileInputStream(file));
    }

    Scanner(String s) throws IOException {
        in = new BufferedReader(new StringReader(s));
        last = in.read();
    }

    Scanner(InputStream input) throws IOException {
        in = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        last = in.read();
    }

    //hasNext methods
    private boolean hasNext() {
        return last != -1;
    }

    public boolean hasNext(Checker charChecker) throws IOException{
        nextToken(charChecker);
        return token != null;
    }

    public boolean hasNextInt(Checker charChecker) throws IOException {
        try {
            nextToken(charChecker);
            String buf = token.toLowerCase();
				if ((buf.length() > 2) && (buf.charAt(0) == '0') && (buf.charAt(1) == 'x')) {
					nextInt = (int) Long.parseLong(buf.substring(2, buf.length()), 16);
				} else {
					buf = new String(toInt(buf));
					nextInt = Integer.parseInt(buf);
			}
            return true;
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean hasLine() {
        return endOfLine;
    }

    // next methods
    private void nextChar() throws IOException{
        last = in.read();
    }

    private void nextToken(Checker charChecker) throws IOException{
        if (token != null) {
            return;
        }
        StringBuilder buffer = new StringBuilder();
        int prev = 1;
        while(!charChecker.check((char) last) && hasNext()) {
            if (isLineSeparator(last)) {
                if (prev != 13) {
                    endOfLine = true;
                    lineBreaks++;
                }
            }
            prev = last;
            nextChar();
        }
        while(charChecker.check((char) last) && hasNext()) {
            buffer.append((char) last);
            nextChar();
        }
        if (buffer.length() != 0) {
            token = new String(buffer);
        } else {
            token = null;
        }
    }


    public String next(Checker charChecker) throws IOException{
        nextToken(charChecker);
        String s = new String(token);
        token = null;
        return s;
    }

    public int nextInt(Checker charChecker) throws IOException {
		if (hasNextInt(charChecker)) {
            token = null;
            return nextInt;
        }
        return 0;
    }

    //utilities
    private boolean isLineSeparator(int c) {
        return c == 10 || c == 13;
    }

    public boolean isEndOfLine(Checker charChecker) throws IOException{
        nextToken(charChecker);
        boolean temp = endOfLine;
        if (lineBreaks > 0) {
            lineBreaks--;
            endOfLine = lineBreaks > 0;
        }
        return temp;
    }

    private StringBuilder toInt(String s) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) >= 'a') && (s.charAt(i) <= 'j')) {
				buf.append(s.charAt(i) - 'a');
			} else {
				buf.append(s.charAt(i));
			}
		}
		return buf;
	}

    //close method
    public void close() throws IOException {
        in.close();
    }
}
