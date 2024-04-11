package practice.백준.dp.silver.피보나치함수_1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static Map<Integer, Pair> cache = new HashMap<>();

    static {
        cache.put(0, new Pair(1, 0));
        cache.put(1, new Pair(0, 1));
    }
    // 0 -> 0 * 1, 1 * 0
    // 1 -> 0 * 0, 1 * 1
    // 2 -> 0 * 1, 1 * 1
    // 3 = 0 * 1, 1 * 2
    // 4 = 0 * 2, 1 * 3
    // 5 = 0 * 3, 1 * 5
    // ...
    // f(n) = f(n-1) + f(n-2)
    public static void main(String[] args) {
        int count = readInputNumber();
        List<Integer> numbers = IntStream.range(0, count)
                .map(index -> readInputNumber())
                .boxed()
                .collect(Collectors.toList());

        int maxNumber = numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        for (int i = 2; i <= maxNumber; i++) {
            int zeroCount = cache.get(i - 1).zeroCount + cache.get(i - 2).zeroCount;
            int oneCount = cache.get(i - 1).oneCount + cache.get(i - 2).oneCount;
            cache.put(i, new Pair(zeroCount, oneCount));
        }

        numbers.forEach(number -> System.out.println(cache.get(number)));
    }

    private void dynamic(int number) {
        if (number == 0) {
        } else if (number == 1) {
        } else {
            dynamic(number - 1);
            dynamic(number - 2);
        }
    }

    private static int readInputNumber() {
        try {
            return Integer.parseInt(BR.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
        }
    }

    static class Pair {
        private final int zeroCount;
        private final int oneCount;

        public Pair(int zeroCount, int oneCount) {
            this.zeroCount = zeroCount;
            this.oneCount = oneCount;
        }

        @Override
        public String toString() {
            return zeroCount + " " + oneCount;
        }
    }
}
