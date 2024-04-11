package practice.백준.greedy.bronze.풍선_6246;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<Integer> inputs = parseInputs();
        int totalSlot = inputs.get(0);
        int tryCount = inputs.get(1);

        List<Boolean> list = IntStream.range(0, totalSlot)
                .mapToObj(operand -> false)
                .collect(Collectors.toList());

        for (int i = 0; i < tryCount; i++) {
            List<Integer> inputTarget = parseInputs();
            int startSlot = inputTarget.get(0) - 1;
            int offset = inputTarget.get(1);

            int currentSlot = startSlot;
            while (currentSlot < totalSlot) {
                list.set(currentSlot, true);
                currentSlot += offset;
            }
        }

        long result = list.stream()
                .filter(bool -> !bool)
                .count();

        System.out.println(result);
    }

    private static List<Integer> parseInputs() {
        return Arrays.asList(readInput().split(" ")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String readInput() {
        try {
            return BR.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
