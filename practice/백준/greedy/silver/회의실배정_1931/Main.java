package practice.백준.greedy.silver.회의실배정_1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int totalCount = Integer.parseInt(read());

        List<Time> times = IntStream.range(0, totalCount)
                .mapToObj(ignore -> Time.from(read()))
                .sorted(Comparator.comparing(Time::getEnd).thenComparing(Time::getStart))
                .collect(Collectors.toList());

        int count = 0;
        int previousEndTime = 0;
        for (Time time : times) {
            if (previousEndTime <= time.getStart()) {
                previousEndTime = time.getEnd();
                count++;
            }
        }

        System.out.println(count);
    }

    private static String read() {
        try {
            return BR.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Time {
    private final int start;
    private final int end;

    private Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static Time from(String input) {
        List<String> list = Arrays.asList(input.split(" "));
        return new Time(Integer.parseInt(list.get(0)), Integer.parseInt(list.get(1)));
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
