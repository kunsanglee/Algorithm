package practice.백준.greedy.bronze.증가수열_30236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(BR.readLine());

        while (count-- > 0) {
            BR.readLine();
            List<Integer> list = Arrays.stream((BR.readLine().split(" ")))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                int current = list.get(i);
                if (result.isEmpty()) {
                    result.add(getFirstNumber(current));
                    continue;
                }
                int lastAddedNumber = result.get(result.size() - 1);

                int candidateNumber = lastAddedNumber + 1;
                while (true) {
                    if (candidateNumber == current) {
                        candidateNumber++;
                        continue;
                    }
                    break;
                }
                result.add(candidateNumber);
            }

            System.out.println(result.get(result.size() - 1));
        }
    }

    private static int getFirstNumber(int current) {
        if (current == 1) {
            return 2;
        }
        return 1;
    }
}
