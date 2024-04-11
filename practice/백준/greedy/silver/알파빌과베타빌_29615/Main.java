package practice.백준.greedy.silver.알파빌과베타빌_29615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BR.readLine();
        List<Integer> list = parseInputList();
        List<Integer> friends = parseInputList();

        int size = friends.size();
        int sum = size;
        for (int i = 0; i < size; i++) {
            if (friends.contains(list.get(i))) {
                sum--;
                continue;
            }
        }

        System.out.println(sum);
    }

    private static List<Integer> parseInputList() throws IOException {
        return Arrays.stream(BR.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
