import java.io.*;

public class b12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder t = new StringBuilder(br.readLine());

        while (t.length() > s.length()) {
            if (t.charAt(t.length() - 1) == 'A') {
                t.deleteCharAt(t.length() - 1);
            } else {
                t.deleteCharAt(t.length() - 1);
                t.reverse();
            }
        }

        System.out.println(t.toString().equals(s) ? 1 : 0);
        br.close();
    }
}
