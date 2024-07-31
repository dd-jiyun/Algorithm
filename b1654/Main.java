package b1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static int [] LANs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        LANs = new int[K];
        for(int i = 0; i < K; i++) {
            LANs[i] = Integer.parseInt(br.readLine());
        }

        long min = 1;
        long max = Arrays.stream(LANs).max().getAsInt();
        long result = 0;

        while(min <= max) {
            long mid = (min + max) / 2;
            long count = 0;

            for (int i = 0; i < K; i++) {
                count += LANs[i] / mid;
            }

            if (count >= N) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(result);
    }
}
