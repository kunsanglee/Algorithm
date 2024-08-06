package practice.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = parseInput();
        int count = parseInput();
        List<Integer> positions = parseSplitToList(split(readLine(), " "));
        // 연속된 가로등 간의 거리가 가장 먼것, 시작부터 처음 가로등, 마지막 가로등부터 끝 가로등 셋 중 가장 큰 값 찾기.
        int max = positions.get(0);
        for (int i = 0; i < positions.size() - 1; i++) {
            int left = positions.get(i);
            int right = positions.get(i + 1);
            max = Math.max(max, calculate(right, left));
        }
        max = Math.max(max, n - positions.get(positions.size() - 1));

        System.out.println(max);
    }

    private static int calculate(int right, int left) {
        int subtract = right - left;
        if (subtract % 2 == 0) {
            return subtract / 2;
        }
        return (subtract + 1) / 2;
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
