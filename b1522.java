import java.io.*;

public class b1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(getMinSwapCount(s));
    }

    private static int getMinSwapCount(String s) {
        int n = s.length();
        int aCount = getACount(s);

        if (aCount == 0 || aCount == n) {
            return 0;
        }

        int bCount = getBCount(s, aCount);

        int minSwap = bCount;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) == 'b') {
                bCount--;
            }
            int nextIndex = (i + aCount - 1) % n;
            if (s.charAt(nextIndex) == 'b') {
                bCount++;
            }

            minSwap = Math.min(minSwap, bCount);
        }

        return minSwap;
    }

    private static int getACount(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                count++;
            }
        }

        return count;
    }

    private static int getBCount(String s, int length) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i % s.length()) == 'b') {
                count++;
            }
        }

        return count;
    }
}
