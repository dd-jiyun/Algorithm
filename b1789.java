import java.util.*;

public class b1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();

        long sum = 0;
        int count = 0;

        int i = 1;
        while (sum + i <= s) {
            sum += i;
            count++;
            i++;
        }

        System.out.println(count);
        sc.close();
    }
}
