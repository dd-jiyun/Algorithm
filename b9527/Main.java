package b9527;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        long A = Long.parseLong(inputs[0]);
        long B = Long.parseLong(inputs[1]);

        System.out.println(bitCount(B) - bitCount(A - 1));
        br.close();
    }

    private static long bitCount(long x) {
        if (x < 0) return 0;

        long count = 0;
        long bit = 1;
        while (bit <= x) {
            long totalPairs = (x + 1) / (bit * 2);
            long remainder = (x + 1) % (bit * 2);

            count += totalPairs * bit;
            if (remainder > bit) {
                count += remainder - bit;
            }

            bit *= 2;
        }
        return count;
    }
}
