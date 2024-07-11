package b1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> queue = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        sb.append("<");

        int index = 0;
        while (!queue.isEmpty()) {
            index = (index + k - 1) % queue.size();
            sb.append(queue.remove(index));

            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");

        System.out.println(sb);
    }
}
