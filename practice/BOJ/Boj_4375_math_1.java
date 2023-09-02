package practice.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_4375_math_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int a = 0;
        for (int i = 1;;i++) {
            a = (a * 10 + 1) % n;
            if (a == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
