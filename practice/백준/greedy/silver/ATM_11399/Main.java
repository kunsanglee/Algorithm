package practice.백준.greedy.silver.ATM_11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        List<Integer> times = Stream.of(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        int sum = 0;
        int total = 0;
        for (int time : times) {
            sum += time;
            total += sum;
        }

        System.out.println(total);
    }
}
