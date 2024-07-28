package practice.백준.구현.silver.줄세우기_10431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int count = parseInput();
        HashMap<Integer, Integer> result = new HashMap<>();

        for (int i = 1; i <= count; i++) {
            List<String> strings = Arrays.asList(split(readLine(), " "));
            List<Integer> heights = strings.subList(1, strings.size()).stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int sortCount = sortHeight(heights, 0);
            result.put(i, sortCount);
        }

        for (Integer key : result.keySet()) {
            System.out.println(key + " " + result.get(key));
        }
    }

    private static int sortHeight(List<Integer> heights, int sortCount) {
        for (int i = 1; i < heights.size(); i++) {
            Integer current = heights.get(i);
            for (int j = 0; j < i; j++) {
                Integer other = heights.get(j);
                if (current < other) {
                    heights.remove(current);
                    heights.add(j, current);
                    return sortHeight(heights, sortCount + (i - j));
                }
            }
        }
        return sortCount;
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

