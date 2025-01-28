import java.util.*;

public class b1124 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        boolean[] isPrime = findPrime(b);

        int[] primeFactorsCount = new int[b + 1];

        calculatePrimeFactorsCount(b, isPrime, primeFactorsCount);

        int underPrimeCount = 0;
        for (int i = a; i <= b; i++) {
            if (isPrime[primeFactorsCount[i]]) {
                underPrimeCount++;
            }
        }

        System.out.println(underPrimeCount);
        sc.close();
    }

    private static boolean[] findPrime(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    private static void calculatePrimeFactorsCount(int limit, boolean[] isPrime, int[] primeFactorsCount) {
        for (int i = 2; i <= limit; i++) {
            int num = i;
            for (int prime = 2; prime * prime <= num; prime++) {
                while (isPrime[prime] && num % prime == 0) {
                    primeFactorsCount[i]++;
                    num /= prime;
                }
            }
            if (num > 1) {
                primeFactorsCount[i]++;
            }
        }
    }
}
