package practice.백준.greedy.silver.카약_2891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<Integer> inputs = parseInput();
        List<Integer> brokenTeams = parseInput();
        List<Integer> spareTeams = parseInput();
        List<Integer> retainTeams = new ArrayList<>(brokenTeams);
        retainTeams.retainAll(spareTeams);
        brokenTeams.removeAll(retainTeams);
        spareTeams.removeAll(retainTeams);

        brokenTeams.sort(Comparator.naturalOrder());
        spareTeams.sort(Comparator.naturalOrder());

        List<Integer> savedTeams = new ArrayList<>();
        for (Integer brokenTeam : brokenTeams) {
            if (spareTeams.contains(brokenTeam - 1)) {
                savedTeams.add(brokenTeam);
                spareTeams.remove(Integer.valueOf(brokenTeam - 1));
            } else if (spareTeams.contains(brokenTeam + 1)) {
                savedTeams.add(brokenTeam);
                spareTeams.remove(Integer.valueOf(brokenTeam + 1));
            }
        }

        brokenTeams.removeAll(savedTeams);

        System.out.println(brokenTeams.size());
    }

    private static List<Integer> parseInput() throws IOException {
        return Arrays.stream(BR.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
