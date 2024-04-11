package practice.백준.greedy.silver.원숭이매달기_2716;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(BR.readLine());

        while (count-- > 0) {
            List<String> list = Arrays.asList(BR.readLine().split(""));
            int maxDepth = 0;
            int currentDepth = 0;
            for (String s : list) {
                if (s.equals("[")) {
                    currentDepth++;
                    maxDepth = Math.max(maxDepth, currentDepth);
                    continue;
                }
                currentDepth--;
            }
            System.out.println((int) Math.pow(2, maxDepth));
        }
    }
}
