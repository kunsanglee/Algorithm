package practice.백준.math.silver.숫자1_4375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

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
