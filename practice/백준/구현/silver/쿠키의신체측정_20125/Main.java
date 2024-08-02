package practice.백준.구현.silver.쿠키의신체측정_20125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = parseInput();
        boolean[][] map = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String input = readLine();
            for (int j = 0; j < n; j++) {
                if (String.valueOf(input.charAt(j)).equals("*")) {
                    map[i][j] = true;
                }
            }
        }

        int[] head = getHead(n, map);
        int axisX = head[1];
        int heartY = head[0] + 1;
        System.out.println((heartY + 1) + " " + (axisX + 1));

        int leftArm = 0;
        for (int i = axisX - 1; i >= 0; i--) {
            if (map[heartY][i]) {
                leftArm++;
            }
        }

        int rightArm = 0;
        for (int i = axisX + 1; i < n; i++) {
            if (map[heartY][i]) {
                rightArm++;
            }
        }

        int body = 0;
        for (int i = heartY + 1; i < n; i++) {
            if (map[i][axisX]) {
                body++;
            }
        }

        int leftLeg = 0;
        for (int i = heartY + body + 1; i < n; i++) {
            if (map[i][axisX - 1]) {
                leftLeg++;
            }
        }

        int rightLeg = 0;
        for (int i = heartY + body + 1; i < n; i++) {
            if (map[i][axisX + 1]) {
                rightLeg++;
            }
        }

        System.out.println(String.format("%d %d %d %d %d", leftArm, rightArm, body, leftLeg, rightLeg));
    }

    private static int[] getHead(int n, boolean[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    private static String readLine() throws IOException {
        return br.readLine();
    }

    private static int parseInput() throws IOException {
        return Integer.parseInt(readLine());
    }

    private static int parseInt(String input) {
        return Integer.parseInt(input);
    }

    private static String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }

    private static List<String> splitToList(String[] inputs) {
        return Arrays.stream(inputs)
                .collect(Collectors.toList());
    }

    private static List<Integer> parseSplitToList(String[] inputs) {
        return Arrays.stream(inputs)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
