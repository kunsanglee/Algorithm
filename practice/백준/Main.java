package practice.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = parseInt(readLine());
        List<Integer> numbers = parseSplitToList(split(readLine(), " "));
        int studentCount = parseInt(readLine());
        for (int i = 0; i < studentCount; i++) {
            List<Integer> studentInput = parseSplitToList(split(readLine(), " "));
            int sex = studentInput.get(0);
            int number = studentInput.get(1);
            if (sex == 1) {
                // number 배수를 변경
                for (int j = number - 1; j < n; j += number) {
                    switchOpposite(numbers, j);
                }
                continue;
            }
            // number 기준으로 좌우대칭 일치하는숫자 전부 변경
            int j = number - 1;
            int k = number - 1;
            switchOpposite(numbers, j);
            while (true) {
                j++;
                k--;
                if (j < n && k >= 0 && numbers.get(j).equals(numbers.get(k))) {
                    switchOpposite(numbers, j);
                    switchOpposite(numbers, k);
                    continue;
                }
                break;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= numbers.size(); i++) {
            int number = numbers.get(i - 1);
            if (i % 20 == 0) {
                sb.append(number).append("\n");
                continue;
            }
            sb.append(number).append(" ");
        }
        System.out.println(sb);
    }

    private static void switchOpposite(List<Integer> numbers, int j) {
        int current = numbers.get(j);
        numbers.set(j, current == 1 ? 0 : 1);
    }

    private static String readLine() throws IOException {
        return br.readLine();
    }

    private static int parseInt(String input) {
        return Integer.parseInt(input);
    }

    private static String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }

    private static List<Integer> parseSplitToList(String[] inputs) {
        return Arrays.stream(inputs)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
