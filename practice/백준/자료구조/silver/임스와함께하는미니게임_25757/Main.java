
package practice.백준.자료구조.silver.임스와함께하는미니게임_25757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int currentCount = 0;

    public static void main(String[] args) throws IOException {

        String[] inputs = split(readLine(), " ");
        int count = parseInt(inputs[0]);
        String game = inputs[1];
        int playerCount = getPlayerCount(game);

        List<String> inputNames = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            inputNames.add(readLine());
        }
        Set<String> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < inputNames.size(); i++) {
            String name = inputNames.get(i);
            if (set.contains(name)) {
                continue;
            }
            set.add(name);
            currentCount++;
            if (currentCount == playerCount) {
                result++;
                setCurrentCount();
            }
        }
        System.out.println(result);
    }

    private static void setCurrentCount() {
        currentCount = 0;
    }

    private static int getPlayerCount(String game) {
        if (game.equals("Y")) {
            return 1;
        }
        if (game.equals("F")) {
            return 2;
        }
        if (game.equals("O")) {
            return 3;
        }
        return 0;
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
