package practice.백준.greedy.silver.보물_1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BR.readLine();
        List<Integer> listA = readList();
        List<Integer> listB = readList();

        // listB 정렬
        List<Integer> sortedListB = new ArrayList<>(listB);
        Collections.sort(sortedListB);

        // listA 내림차순 정렬
        List<Integer> sortedListA = new ArrayList<>(listA);
        sortedListA.sort(Collections.reverseOrder());

        // 정렬된 listB를 기준으로 listA의 원소를 재배치하여 최소값 계산
        int sum = 0;
        for (int i = 0; i < sortedListB.size(); i++) {
            sum += sortedListA.get(i) * sortedListB.get(i);
        }

        System.out.println(sum);
    }

    private static List<Integer> readList() throws IOException {
        String[] input = BR.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for (String value : input) {
            list.add(Integer.parseInt(value));
        }
        return list;
    }
}
