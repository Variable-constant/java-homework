import java.util.*;
import java.io.*;
public class Scanner implements AutoCloseable{
    private BufferedReader in;
    private int last;
    public int lineBreaks = 0;
    private String token = null;
    private boolean endOfLine = false;
    Scanner(File file) throws IOException {
        this(new FileInputStream(file));
    }

    Scanner(String s) throws IOException {
        in = new BufferedReader(new StringReader(s));
        last = in.read();
    }

    Scanner(InputStream input) throws IOException {
        in = new BufferedReader(new InputStreamReader(input, "UTF-8"));
        last = in.read();
    }

    public void close() throws IOException {
        in.close();
    }

    private boolean hasNext() {
        return last != -1;
    }

    private void nextChar() throws IOException{
        last = in.read();
    }

    private boolean isLineSeparator(int c) {
        return c == 10 || c == 13;
    }

    public interface Checker {
        boolean check(char c);
    }
    // public boolean check(char c) {
    //     return true;
    // }
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

    public boolean hasNext(Checker charChecker) throws IOException{
        nextToken(charChecker);
        return token != null;
    }

    public String next(Checker charChecker) throws IOException{
        nextToken(charChecker);
        String s = new String(token);
        token = null;
        return s;
    }

    public boolean hasNextInt(Checker charChecker) throws IOException {
        try {
            nextToken(charChecker);
            String buf = token.toLowerCase();
				if ((buf.length() > 2) && (buf.charAt(0) == '0') && (buf.charAt(1) == 'x')) {
					Long.parseLong(buf.substring(2, buf.length()), 16);
				} else {
					buf = new String(toInt(buf));
					Integer.parseInt(buf);
			}
            return true;
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public int nextInt(Checker charChecker) throws IOException {
		try {
            int n;
			String buf = token.toLowerCase();
			if ((buf.length() > 2) && (buf.charAt(0) == '0') && (buf.charAt(1) == 'x')) {
				n = (int) Long.parseLong(buf.substring(2, buf.length()), 16);
			} else {
				buf = new String(toInt(buf));
				n = Integer.parseInt(buf);
			}
            token = null;
            return n;
		} catch (NumberFormatException e) {
			throw new InputMismatchException();
		}
    }

    public boolean isEndOfLine(Checker charChecker) throws IOException{
        nextToken(charChecker);
        boolean temp = endOfLine;
        // endOfLine = false;
        // return temp;
        if (lineBreaks > 0) {
            lineBreaks--;
            endOfLine = lineBreaks > 0;
        }
        return temp;
    }

    public boolean hasLine() {
        return endOfLine;
    }

    public StringBuilder toInt(String s) {
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
}