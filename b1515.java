import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int idx = 0;
        int num = 0;

        while (idx < s.length()) {
            num++;
            String numStr = String.valueOf(num);

            for (char c : numStr.toCharArray()) {
                if (idx < s.length() && c == s.charAt(idx)) {
                    idx++;
                }
            }
        }

        System.out.println(num);
    }
}
