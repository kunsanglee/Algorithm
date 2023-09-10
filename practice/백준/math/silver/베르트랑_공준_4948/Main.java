package practice.백준.math.silver.베르트랑_공준_4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isPrime = new boolean[123456 * 2 + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < Math.sqrt(isPrime.length); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;
            int count = 0;
            for (int i = num + 1; i <= num * 2; i++) {
                if (isPrime[i]) count++;
            }
            System.out.println(count);
        }
    }
}
