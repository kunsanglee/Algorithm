package practice.백준.greedy.silver.지뢰_2232;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int count = readInputNumber();
        List<Integer> numbers = IntStream.range(0, count)
                .mapToObj(index -> readInputNumber())
                .collect(Collectors.toList());
        numbers.add(0, 0);
        numbers.add(numbers.size(), 0);

        for (int index = 1; index < numbers.size() - 1; index++) {
            int previous = numbers.get(index - 1);
            int current = numbers.get(index);
            int next = numbers.get(index + 1);
            if (previous <= current && current >= next) {
                System.out.println(index);
            }
        }
    }

    private static int readInputNumber() {
        try {
            return Integer.parseInt(BR.readLine());
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
