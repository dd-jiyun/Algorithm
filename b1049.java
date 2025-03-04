import java.io.*;
import java.util.*;

public class b1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int minPack = Integer.MAX_VALUE;
        int minEach = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int pack = Integer.parseInt(st.nextToken());
            int each = Integer.parseInt(st.nextToken());

            minPack = Math.min(minPack, pack);
            minEach = Math.min(minEach, each);
        }

        int allPackage = (n / 6 + 1) * minPack;
        int packageAndSingle = (n / 6) * minPack + (n % 6) * minEach;
        int allSingle = n * minEach;

        System.out.println(Math.min(allPackage, Math.min(packageAndSingle, allSingle)));
    }
}
