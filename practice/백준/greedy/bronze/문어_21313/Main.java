package practice.백준.greedy.bronze.문어_21313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        if (count % 2 == 1) {
            System.out.println(getResult(count - 1) + " 3");
            return;
        }
        System.out.println(getResult(count));
    }

    private static String getResult(int count) {
        return IntStream.range(0, count)
                .mapToObj(Main::mapping)
                .collect(Collectors.joining(" "));
    }

    private static String mapping(int index) {
        if (index % 2 == 0) {
            return "1";
        }
        return "2";
    }
}
