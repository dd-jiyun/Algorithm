package b22233;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> memo = new HashSet<>();
        for (int i = 0; i < N; i++) {
            memo.add(br.readLine());
        }

        ArrayList<String> written = new ArrayList<>();
        for (int j = 0; j < M; j++) {
            written.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (String w : written) {
            String[] split = w.split(",");
            for (String s : split) {
                memo.remove(s);
            }
            sb.append(memo.size()).append("\n");
        }

        System.out.println(sb);
    }
}
