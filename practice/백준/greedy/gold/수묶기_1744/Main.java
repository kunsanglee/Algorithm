package practice.백준.greedy.gold.수묶기_1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        Map<Boolean, List<Integer>> numbers = IntStream.range(0, readLine())
                .mapToObj(index -> readLine())
                .collect(Collectors.partitioningBy(number -> number <= 0));

        List<Integer> positiveNumbers = numbers.get(false);
        positiveNumbers.sort(Comparator.reverseOrder());
        List<Integer> negativeNumbers = numbers.get(true);
        negativeNumbers.sort(Comparator.naturalOrder());

        PriorityQueue<Integer> positiveQueue = new PriorityQueue<>();
        PriorityQueue<Integer> negativeQueue = new PriorityQueue<>();

        int sum1 = calculate(positiveNumbers, positiveQueue);
        int sum2 = calculate(negativeNumbers, negativeQueue);

        System.out.println(sum1 + sum2);
    }

    private static int calculate(List<Integer> positiveNumbers, PriorityQueue<Integer> positiveQueue) {
        return calculateSum(positiveNumbers, positiveQueue);
    }

    private static int calculateSum(List<Integer> numbers, PriorityQueue<Integer> queue) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            queue.offer(number);
            if (queue.size() == 2) {
                int num1 = queue.poll();
                int num2 = queue.poll();
                sum += Math.max(num1 + num2, num1 * num2);
            }
        }
        if (!queue.isEmpty()) {
            sum += queue.poll();
        }
        return sum;
    }

    public static int readLine() {
        try {
            return Integer.parseInt(BR.readLine());
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
