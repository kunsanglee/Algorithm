package practice.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        
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
