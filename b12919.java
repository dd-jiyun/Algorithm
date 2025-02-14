import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b12919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        System.out.println(canTransform(s, t) ? 1 : 0);
    }

    private static boolean canTransform(String s, String t) {

        if (s.equals(t)) {
            return true;
        }
        if (t.length() < s.length()) {
            return false;
        }

        boolean result = false;

        if (t.charAt(t.length() - 1) == 'A') {
            result = canTransform(s, t.substring(0, t.length() - 1));
        }
        if (!result && t.charAt(0) == 'B') {
            String reversed = new StringBuilder(t.substring(1)).reverse().toString();
            result = canTransform(s, reversed);
        }

        return result;
    }
}
