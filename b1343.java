import java.io.*;

public class b1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();

        System.out.println(convertBoard(board));
    }

    private static String convertBoard(String board) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (char c : board.toCharArray()) {
            if (c == 'X') {
                count++;
            } else {
                replacePolyomino(result, count);
                result.append(".");
                count = 0;
            }
        }
        replacePolyomino(result, count);

        return result.toString();
    }

    private static void replacePolyomino(StringBuilder result, int count) {
        if (count % 2 != 0) {
            result.setLength(0);
            result.append("-1");
            return;
        }

        while (count >= 4) {
            result.append("AAAA");
            count -= 4;
        }
        if (count == 2) {
            result.append("BB");
        }
    }
}
