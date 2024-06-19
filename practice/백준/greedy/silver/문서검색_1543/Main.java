package practice.백준.greedy.silver.문서검색_1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String source = getInput();
        String target = getInput();
        int count = 0;
        while (true) {
            int index = source.indexOf(target);
            if (index == -1) {
                break;
            }
            count++;
            source = source.substring(index + target.length());
        }
        System.out.println(count);
    }

    private static String getInput() throws IOException {
        return BR.readLine();
    }
}
