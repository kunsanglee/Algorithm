package practice.백준.구현.silver.등수구하기_1205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] inputs = split(readLine(), " ");
        int n = parseInt(inputs[0]);
        int newScore = parseInt(inputs[1]);
        int maxRank = parseInt(inputs[2]);

        List<Integer> scores;
        if (n > 0) {
            scores = parseSplitToList(split(readLine(), " "));
        } else {
            scores = new ArrayList<>();
        }

        int result = getResult(n, maxRank, scores, newScore);
        System.out.println(result);
    }

    private static int getResult(int n, int maxRank, List<Integer> scores, int newScore) {
        scores.add(newScore);
        scores.sort(Comparator.reverseOrder());

        int rank = scores.indexOf(newScore) + 1;
        if (rank > maxRank) {
            return -1;
        }

        if (n == maxRank && scores.get(scores.size() - 1) == newScore) {
            return -1;
        }

        return rank;
    }

    private static String readLine() throws IOException {
        return br.readLine();
    }

    private static int parseInt(String input) {
        return Integer.parseInt(input);
    }

    private static String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }

    private static List<Integer> parseSplitToList(String[] inputs) {
        return Arrays.stream(inputs)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
