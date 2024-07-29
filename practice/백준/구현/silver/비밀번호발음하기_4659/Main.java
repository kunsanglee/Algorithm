package practice.백준.구현.silver.비밀번호발음하기_4659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input;

        while (!"end".equals(input = readLine())) {
            if (isContainConsonant(input) && !isInARow(input) && !isEOInARow(input)) {
                System.out.println("<" + input + "> is acceptable.");
                continue;
            }
            System.out.println("<" + input + "> is not acceptable.");
        }
    }

    private static boolean isEOInARow(String input) {
        String[] split = input.split("");
        for (int i = 0; i < split.length - 1; i++) {
            String s = split[i];
            if (s.equals("e") || s.equals("o")) {
                continue;
            }
            if (s.equals(split[i + 1])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInARow(String input) {
        int length = input.length();
        if (length < 3) {
            return false;
        }
        for (int i = 0; i < length - 2; i++) {
            String a = String.valueOf(input.charAt(i));
            String b = String.valueOf(input.charAt(i + 1));
            String c = String.valueOf(input.charAt(i + 2));
            if (isContainConsonant(a) && isContainConsonant(b) && isContainConsonant(c)) {
                return true;
            }
            if (!isContainConsonant(a) && !isContainConsonant(b) && !isContainConsonant(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isContainConsonant(String input) {
        return input.contains("a") ||
                input.contains("e") ||
                input.contains("i") ||
                input.contains("o") ||
                input.contains("u");
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

    private static List<String> splitToList(String[] inputs) {
        return Arrays.stream(inputs)
                .collect(Collectors.toList());
    }

    private static List<Integer> parseSplitToList(String[] inputs) {
        return Arrays.stream(inputs)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
