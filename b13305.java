import java.io.*;
import java.util.*;

public class b13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] distances = new long[n - 1];
        long[] prices = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            distances[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Long.parseLong(st.nextToken());
        }

        long minPrice = prices[0];
        long total = 0;

        for (int i = 0; i < n - 1; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            total += minPrice * distances[i];
        }

        System.out.println(total);
    }
}
