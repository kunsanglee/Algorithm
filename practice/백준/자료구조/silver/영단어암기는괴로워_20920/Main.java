package practice.백준.자료구조.silver.영단어암기는괴로워_20920;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input = readLine();
        List<Integer> integers = parseSplitToList(split(input, " "));
        int n = integers.get(0);
        int length = integers.get(1);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = readLine();
            if (word.length() < length) {
                continue;
            }
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> list = map.entrySet().stream()
                .sorted((o1, o2) -> {
                    if (!o1.getValue().equals(o2.getValue())) {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                    if (o1.getKey().length() != o2.getKey().length()) {
                        return o2.getKey().length() - o1.getKey().length();
                    }
                    return o1.getKey().compareTo(o2.getKey());
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        for (String word : list) {
            bw.write(word);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    private static String readLine() throws IOException {
        return br.readLine();
    }

    private static List<Integer> parseSplitToList(String[] inputs) {
        return Arrays.stream(inputs)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }
}
