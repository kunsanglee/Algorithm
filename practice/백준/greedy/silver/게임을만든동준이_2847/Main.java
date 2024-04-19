package practice.백준.greedy.silver.게임을만든동준이_2847;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        List<Integer> numbers = IntStream.range(0, readInput())
                .map(index -> readInput())
                .boxed()
                .collect(Collectors.toList());


        int sum = 0;
        for (int i = numbers.size() - 2; i >= 0; i--) {
            int previous = numbers.get(i + 1);
            int current = numbers.get(i);
            int gap = current - previous;
            if (gap >= 0) {
                int subtract = gap + 1;
                sum += subtract;
                numbers.set(i, current - subtract);
            }
        }

        System.out.println(sum);
    }

    private static int readInput() {
        try {
            return Integer.parseInt(BR.readLine());
        } catch (IOException | NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }
}
