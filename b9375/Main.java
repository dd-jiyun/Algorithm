package b9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int n;
    static String[][] clothes;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        HashMap<String, Integer> map = new HashMap<>();

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            clothes = new String[n][2];

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                clothes[j][0] = st.nextToken();
                clothes[j][1] = st.nextToken();

                map.put(clothes[j][1], map.getOrDefault(clothes[j][1], 0) + 1);
            }

            result = 1;
            for (int value : map.values()) {
                result *= (value + 1);
            }

            sb.append(result - 1).append("\n");

            map.clear();
        }

        System.out.println(sb);
    }
}
