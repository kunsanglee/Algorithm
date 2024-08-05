package practice.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            List<Integer> numbers = Arrays.stream(input)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            // 필터링: 6명 이상의 선수가 있는 팀만 남김
            Set<Integer> ok = numbers.stream()
                    .filter(number -> Collections.frequency(numbers, number) >= 6)
                    .collect(Collectors.toSet());

            Map<Integer, List<Integer>> teamPositions = new HashMap<>();
            for (int j = 0, k = 1; j < n; j++) {
                int team = numbers.get(j);
                if (ok.contains(team)) {
                    teamPositions.putIfAbsent(team, new ArrayList<>());
                    teamPositions.get(team).add(k++);
                }
            }

            // 각 팀의 상위 4명의 점수 합산
            Map<Integer, Integer> teamScores = new HashMap<>();
            Map<Integer, Integer> teamFifthPositions = new HashMap<>();
            for (Map.Entry<Integer, List<Integer>> entry : teamPositions.entrySet()) {
                List<Integer> positions = entry.getValue();
                Collections.sort(positions);
                int team = entry.getKey();
                int sum = positions.stream().limit(4).reduce(0, Integer::sum);
                teamScores.put(team, sum);
                teamFifthPositions.put(team, positions.get(4)); // 다섯 번째 주자의 순위 저장
            }

            // 우승팀 결정
            int minScore = Integer.MAX_VALUE;
            int winningTeam = -1;
            for (int team : teamScores.keySet()) {
                int score = teamScores.get(team);
                if (score < minScore) {
                    minScore = score;
                    winningTeam = team;
                } else if (score == minScore) {
                    // 동점일 경우 다섯 번째 주자의 순위 비교
                    if (teamFifthPositions.get(team) < teamFifthPositions.get(winningTeam)) {
                        winningTeam = team;
                    }
                }
            }

            System.out.println(winningTeam);
        }
    }
}
