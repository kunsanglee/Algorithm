package practice.백준.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int tryCount = Integer.parseInt(getReadLine().split(" ")[1]);

        List<Long> cards = Arrays.stream(getReadLine().split(" "))
                .map(Long::parseLong)
                .sorted()
                .collect(Collectors.toList());

        for (int i = 0; i < tryCount; i++) {
            long sum = cards.get(0) + cards.get(1);
            cards.set(0, sum);
            cards.set(1, sum);
            cards.sort(Comparator.naturalOrder());
        }

        long result = cards.stream()
                .mapToLong(Long::longValue)
                .sum();

        System.out.println(result);
    }

    private static String getReadLine() {
        try {
            return BR.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
