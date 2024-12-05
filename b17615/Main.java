package b17615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String balls = br.readLine();

        int leftRed = 0, rightRed = 0;
        int leftBlue = 0, rightBlue = 0;

        char leftColor = balls.charAt(0);
        for (int i = 0; i < n; i++) {
            if (balls.charAt(i) != leftColor) {
                break;
            }
            if (leftColor == 'R') {
                leftRed++;
            } else {
                leftBlue++;
            }
        }

        char rightColor = balls.charAt(n - 1);
        for (int i = n - 1; i >= 0; i--) {
            if (balls.charAt(i) != rightColor) {
                break;
            }
            if (rightColor == 'R') {
                rightRed++;
            } else {
                rightBlue++;
            }
        }

        int totalRed = 0, totalBlue = 0;
        for (int i = 0; i < n; i++) {
            if (balls.charAt(i) == 'R') {
                totalRed++;
            } else {
                totalBlue++;
            }
        }

        int minMoves = Math.min(
                Math.min(totalRed - leftRed, totalRed - rightRed),
                Math.min(totalBlue - leftBlue, totalBlue - rightBlue)
        );

        System.out.println(minMoves);
    }
}
