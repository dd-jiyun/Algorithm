import java.io.*;
import java.util.*;

public class b14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] height = new int[w];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getWater(w, height));
    }

    private static int getWater(int w, int[] block) {

        if (w < 3) {
            return 0;
        }

        int[] leftMax = new int[w];
        int[] rightMax = new int[w];

        leftMax[0] = block[0];
        for (int i = 1; i < w; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], block[i]);
        }

        rightMax[w - 1] = block[w - 1];
        for (int i = w - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], block[i]);
        }

        int water = 0;
        for (int i = 0; i < w; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - block[i];
        }

        return water;
    }
}
