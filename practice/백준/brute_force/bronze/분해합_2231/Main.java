package practice.백준.brute_force.bronze.분해합_2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int i = 1;
        while (i <= n) {
            if (d(i) == n){
                System.out.println(i);
                return ;
            }

            i++;
        }
        System.out.println(0);
    }

    public static int d(int i) {
        int sum = i;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}
