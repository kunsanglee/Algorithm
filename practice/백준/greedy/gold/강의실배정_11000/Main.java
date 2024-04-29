package practice.백준.greedy.gold.강의실배정_11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String input = readInput();
        int count = Integer.parseInt(input);

        ArrayList<Schedule> schedules = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> times = Arrays.stream(readInput().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            schedules.add(new Schedule(times));
        }
        schedules.sort(Schedule::compareTo);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int endTime = 0;
        for (Schedule schedule : schedules) {
            endTime = schedule.end;
            if (!pq.isEmpty() && pq.peek() <= schedule.start) {
                pq.poll();
            }
            pq.offer(endTime);
        }
        System.out.println(pq.size());
    }

    private static String readInput() {
        try {
            return BR.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    static class Schedule implements Comparable<Schedule> {
        int start;
        int end;

        public Schedule(List<Integer> times) {
            this(times.get(0), times.get(1));
        }

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Schedule other) {
            if (this.start == other.start) {
                return this.end - other.end;
            }
            return this.start - other.start;
        }
    }
}
