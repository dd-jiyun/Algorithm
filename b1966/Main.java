package b1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcaseNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcaseNum; i++) {
            Queue<int[]> queue = new LinkedList<>();
            int checkIdx = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                queue.offer(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            while (true) {
                int[] now = queue.remove();
                boolean isMax = true;

                for (int[] printInfo : queue) {
                    if (printInfo[1] > now[1]) {
                        isMax = false;
                        break;
                    }
                }
                if (isMax) {
                    checkIdx++;
                    if (now[0] == m) {
                        sb.append(checkIdx).append("\n");
                        break;
                    }
                } else {
                    queue.offer(now);
                }
            }
        }
        System.out.println(sb);
    }

}
