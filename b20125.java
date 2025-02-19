import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int x = -1, y = -1;

        for (int i = 0; i < n - 1 && x == -1; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '*' && map[i + 1][j] == '*') {
                    x = i + 1;
                    y = j;
                    break;
                }
            }
        }

        int leftArm = 0, rightArm = 0;
        for (int j = y - 1; j >= 0 && map[x][j] == '*'; j--) {
            leftArm++;
        }
        for (int j = y + 1; j < n && map[x][j] == '*'; j++) {
            rightArm++;
        }

        int waistLength = 0, waistEnd = x;
        for (int i = x + 1; i < n && map[i][y] == '*'; i++) {
            waistLength++;
            waistEnd = i;
        }

        int leftLegX = waistEnd + 1, rightLegX = waistEnd + 1;

        int leftLegY = -1, rightLegY = -1;
        for (int j = 0; j < n; j++) {
            if (map[leftLegX][j] == '*') {
                if (leftLegY == -1) {
                    leftLegY = j;
                } else {
                    rightLegY = j;
                    break;
                }
            }
        }

        int leftLeg = 0, rightLeg = 0;
        for (int i = leftLegX; i < n && map[i][leftLegY] == '*'; i++) {
            leftLeg++;
        }
        for (int i = rightLegX; i < n && map[i][rightLegY] == '*'; i++) {
            rightLeg++;
        }

        String sb = (x + 1) + " " + (y + 1) + "\n"
                + leftArm + " " + rightArm + " "
                + waistLength + " "
                + leftLeg + " " + rightLeg;

        System.out.println(sb);
    }
}
