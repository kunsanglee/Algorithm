package practice.백준.구현.silver.집합_11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer stringBuffer = new StringBuffer();
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int count = parseInput();
        for (int i = 0; i < count; i++) {
            String[] inputs = split(readLine(), " ");
            String command = inputs[0];
            if (command.equals("all") || command.equals("empty")) {
                Command.doCommand(null, command);
                continue;
            }
            int target = parseInt(inputs[1]);
            Command.doCommand(target, command);
        }
        System.out.println(stringBuffer);
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

    enum Command {
        /**
         * add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
         * remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
         * check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
         * toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
         * all: S를 {1, 2, ..., 20} 으로 바꾼다.
         * empty: S를 공집합으로 바꾼다.
         */
        ADD("add") {
            @Override
            public void process(Integer target) {
                list.add(target);
            }
        },
        REMOVE("remove") {
            @Override
            public void process(Integer target) {
                list.remove(target);
            }
        },
        CHECK("check") {
            @Override
            public void process(Integer target) {
                if (list.contains(target)) {
                    stringBuffer.append(1).append("\n");
                    return;
                }
                stringBuffer.append(0).append("\n");
            }
        },
        TOGGLE("toggle") {
            @Override
            public void process(Integer target) {
                if (list.contains(target)) {
                    list.remove(target);
                    return;
                }
                list.add(target);
            }
        },
        ALL("all") {
            @Override
            public void process(Integer target) {
                list = IntStream.rangeClosed(1, 20)
                        .boxed()
                        .collect(Collectors.toList());
            }
        },
        EMPTY("empty") {
            @Override
            public void process(Integer target) {
                list.clear();
            }
        },
        ;

        private final String name;

        Command(String name) {
            this.name = name;
        }

        public static void doCommand(Integer target, String commandName) {
            Arrays.stream(values())
                    .filter(command -> command.name.equals(commandName))
                    .findAny()
                    .orElseThrow().process(target);
        }

        public abstract void process(Integer target);
    }
}
