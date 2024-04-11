package practice.백준.greedy.bronze.penpineappleapplepen_15881;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int length = Integer.parseInt(BR.readLine());
        String input = BR.readLine();

        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (i + 3 < length &&
                    input.charAt(i) == 'p' &&
                    input.charAt(i + 1) == 'P' &&
                    input.charAt(i + 2) == 'A' &&
                    input.charAt(i + 3) == 'p') {
                sum++;
                i += 3;
            }
        }
        System.out.println(sum);
    }
}
