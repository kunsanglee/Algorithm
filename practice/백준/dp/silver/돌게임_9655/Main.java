package practice.백준.dp.silver.돌게임_9655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] map = new boolean[1001];

    public static void main(String[] args) throws IOException {
        int number = parseInput();
        map[1] = true;
        map[2] = false;
        map[3] = true;

        for (int i = 4; i <= number; i++) {
            map[i] = !map[i - 1] || !map[i - 3];
        }

        System.out.println(map[number] ? "SK" : "CY");
    }

    private static String readLine() throws IOException {
        return br.readLine();
    }

    private static int parseInput() throws IOException {
        return Integer.parseInt(readLine());
    }

    private static int parseInt(String input) {
        return Integer.parseInt(input);
    }

    private static String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }
}
