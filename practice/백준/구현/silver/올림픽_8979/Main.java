package practice.백준.구현.silver.올림픽_8979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) throws IOException {
        List<Integer> inputs = parseSplitToList(split(readLine(), " "));
        int countryCount = inputs.get(0);
        int targetCountryNumber = inputs.get(1);

        List<Country> countries = new ArrayList<>();
        for (int i = 0; i < countryCount; i++) {
            List<Integer> countryInput = parseSplitToList(split(readLine(), " "));
            Country country = new Country(
                    countryInput.get(0),
                    countryInput.get(1),
                    countryInput.get(2),
                    countryInput.get(3)
            );
            countries.add(country);
        }
        Collections.sort(countries);

        Map<Integer, List<Country>> result = new HashMap<>();
        for (int i = 0; i < countries.size(); ) {
            Country current = countries.get(i);
            List<Country> sameRankCountries = countries.stream()
                    .filter(current::equals)
                    .collect(Collectors.toList());
            result.put(i + 1, sameRankCountries);
            i += sameRankCountries.size();
        }

        int rank = result.keySet().stream()
                .filter(key -> result.get(key).stream()
                        .anyMatch(country -> country.number == targetCountryNumber))
                .findAny()
                .orElseThrow();

        System.out.println(rank);
    }

    static class Country implements Comparable<Country> {

        final int number;
        final int gold;
        final int silver;
        final int bronze;

        public Country(int number, int gold, int silver, int bronze) {
            this.number = number;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country other) {
            if (this.gold != other.gold) {
                return other.gold - this.gold;
            }
            if (this.silver != other.silver) {
                return other.silver - this.silver;
            }
            return other.bronze - this.bronze;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Country country = (Country) o;
            return gold == country.gold && silver == country.silver && bronze == country.bronze;
        }

        @Override
        public int hashCode() {
            return Objects.hash(gold, silver, bronze);
        }
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
