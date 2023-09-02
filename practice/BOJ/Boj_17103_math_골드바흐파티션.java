package practice.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_17103_math_골드바흐파티션 {
    static boolean[] arr = new boolean[1000001];

    public static boolean isPrime(int k) {
        for (int i = 2; i <= (int)(Math.sqrt(k)); i++) {
            if (k % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 2; i < arr.length; i++) {
            arr[i] = isPrime(i);
        }

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            int count = 0;
            for (int j = 2; j <= x/2; j++) {
                if (arr[j] && arr[x-j]) count++;
            }
            System.out.println(count);
        }
    }
}