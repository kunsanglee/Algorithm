package practice.백준.greedy.silver.YonseiTOTO_12018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<Integer> inputs = parseInput();
        int subjectCount = inputs.get(0);
        int totalMileage = inputs.get(1);
        int successCount = 0;
        List<Subject> subjects = new ArrayList<>();
        for (int i = 0; i < subjectCount; i++) {
            List<Integer> subjectInputs = parseInput();
            List<Integer> mileages = parseInput();

            Subject subject = new Subject(subjectInputs, mileages);
            subjects.add(subject);
        }

        subjects.sort(Comparator.comparing(Subject::getMinMileage));

        for (Subject subject : subjects) {
            int minMileage = subject.getMinMileage();
            if (totalMileage >= minMileage) {
                totalMileage -= minMileage;
                successCount++;
            }
        }

        System.out.println(successCount);
    }

    private static List<Integer> parseInput() throws IOException {
        return Arrays.stream(BR.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    static class Subject {
        int participants;
        int subjectTo;
        List<Integer> mileages;

        Subject(List<Integer> subjects, List<Integer> mileages) {
            this.participants = subjects.get(0);
            this.subjectTo = subjects.get(1);
            mileages.sort(Comparator.reverseOrder());
            this.mileages = mileages;
        }

        int getMaxMileage() {
            return mileages.get(0);
        }

        int getMinMileage() {
            if (subjectTo > participants) {
                return 1;
            }
            return mileages.get(subjectTo - 1);
        }
    }
}
