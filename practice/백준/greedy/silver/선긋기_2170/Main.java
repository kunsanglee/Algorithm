package practice.백준.greedy.silver.선긋기_2170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int count = Integer.parseInt(getReadLine());
        PriorityQueue<Line> lines = new PriorityQueue<>();
        for (int i = 0; i < count; i++) {
            List<String> inputs = Arrays.asList(getReadLine().split(" "));
            int start = Integer.parseInt(inputs.get(0));
            int end = Integer.parseInt(inputs.get(1));
            lines.offer(new Line(start, end));
        }

        Line current = lines.poll();
        int start = current.start;
        int end = current.end;
        int result = 0;
        while (!lines.isEmpty()) {
            current = lines.poll();
            if (current.start > end) {
                result += end - start;
                start = current.start;
                end = current.end;
                continue;
            }
            if (current.end > end) {
                end = current.end;
            }
        }
        result += end - start;

        System.out.println(result);
    }

    private static String getReadLine() {
        try {
            return BR.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    static class Line implements Comparable {
        int start;
        int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Object o) {
            Line other = (Line) o;
            if (this.start == other.start) {
                return other.end - this.end;
            }
            return this.start - other.start;
        }
    }
}
