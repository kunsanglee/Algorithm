package practice.백준.greedy.silver.뒤집기_1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        List<Integer> numbers = readInputNumber();

        int zeroCount = 0;
        int oneCount = 0;
        int previous = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (previous != numbers.get(i)) {
                if (previous == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }
                previous = numbers.get(i);
            }
        }

        if (numbers.get(numbers.size() - 1) == 0) {
            zeroCount++;
        } else {
            oneCount++;
        }

        System.out.println(Math.min(zeroCount, oneCount));
    }

    private static List<Integer> readInputNumber() {
        try {
            return Arrays.stream(BR.readLine().split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
