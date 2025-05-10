@file:Suppress("ktlint:standard:no-wildcard-imports")

package practice.백준.greedy.silver.수_이어_쓰기_1515

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 메인 함수
fun main() {
    val solution = Solution()
    solution.solve()
}

// 코딩 테스트 문제 해결을 위한 클래스
class Solution {
    private val reader = BufferedReader(InputStreamReader(System.`in`))
    private val writer = BufferedWriter(OutputStreamWriter(System.out))

    // 문제 해결 메인 로직
    fun solve() {
        val input = reader.readLine()

        var n = 0
        var i = 0

        while (i < input.length) { // 입력한 문자열의 모든 인덱스를 확인한다.
            n++
            val currentNumber = n.toString() // 수를 증가시키면서 문자열로 만든다.

            for (c in currentNumber) { // 각 자리수를 확인하고 일치하면 인덱스를 증가시킨다.
                if (i < input.length && c == input[i]) {
                    i++
                }
            }
        }

        println(n)
    }

    // 입력 처리 유틸리티 함수들

    // 한 줄 읽기
    private fun readLine(): String = reader.readLine()

    // 한 줄을 정수로 읽기
    private fun readInt(): Int = readLine().toInt()

    // 한 줄을 Long으로 읽기
    private fun readLong(): Long = readLine().toLong()

    // 한 줄을 Double로 읽기
    private fun readDouble(): Double = readLine().toDouble()

    // 한 줄을 공백으로 분리하여 정수 리스트로 읽기
    private fun readIntList(): List<Int> = readLine().split(" ").map { it.toInt() }

    // 한 줄을 공백으로 분리하여 Long 리스트로 읽기
    private fun readLongList(): List<Long> = readLine().split(" ").map { it.toLong() }

    // 한 줄을 공백으로 분리하여 Double 리스트로 읽기
    private fun readDoubleList(): List<Double> = readLine().split(" ").map { it.toDouble() }

    // 한 줄을 공백으로 분리하여 문자열 리스트로 읽기
    private fun readStringList(): List<String> = readLine().split(" ")

    // 여러 줄을 각각 정수로 읽기
    private fun readIntLines(n: Int): List<Int> = List(n) { readInt() }

    // 여러 줄을 각각 정수 리스트로 읽기
    private fun readIntListLines(n: Int): List<List<Int>> = List(n) { readIntList() }

    // 2차원 배열 읽기 예시 (n x m 크기)
    private fun read2DIntArray(
        n: Int,
        m: Int,
    ): Array<IntArray> = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    // 입력에서 n개의 라인을 문자 배열로 읽기 (그래프 문제 등에 유용)
    private fun readCharGrid(n: Int): Array<CharArray> = Array(n) { readLine().toCharArray() }

    // 알고리즘 유틸리티 함수들

    // 최대공약수 (GCD)
    private fun gcd(
        a: Int,
        b: Int,
    ): Int = if (b == 0) a else gcd(b, a % b)

    // 최소공배수 (LCM)
    private fun lcm(
        a: Int,
        b: Int,
    ): Int = a / gcd(a, b) * b

    // 소수 판별
    private fun isPrime(n: Int): Boolean {
        if (n <= 1) return false
        if (n <= 3) return true
        if (n % 2 == 0 || n % 3 == 0) return false
        var i = 5
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) return false
            i += 6
        }
        return true
    }

    // 에라토스테네스의 체 (소수 목록 구하기)
    private fun sieveOfEratosthenes(n: Int): BooleanArray {
        val isPrime = BooleanArray(n + 1) { true }
        isPrime[0] = false
        isPrime[1] = false

        for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
            if (isPrime[i]) {
                for (j in i * i..n step i) {
                    isPrime[j] = false
                }
            }
        }
        return isPrime
    }

    // 이진 검색
    private fun binarySearch(
        arr: List<Int>,
        target: Int,
    ): Int {
        var left = 0
        var right = arr.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                arr[mid] == target -> return mid
                arr[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }

        return -1 // 찾지 못한 경우
    }

    // 두 지점 간의 맨해튼 거리
    private fun manhattanDistance(
        x1: Int,
        y1: Int,
        x2: Int,
        y2: Int,
    ): Int = Math.abs(x1 - x2) + Math.abs(y1 - y2)

    // 두 지점 간의 유클리드 거리
    private fun euclideanDistance(
        x1: Int,
        y1: Int,
        x2: Int,
        y2: Int,
    ): Double = Math.sqrt(Math.pow((x1 - x2).toDouble(), 2.0) + Math.pow((y1 - y2).toDouble(), 2.0))

    // 2차원 배열 출력하기
    private fun print2DArray(arr: Array<IntArray>) {
        for (row in arr) {
            writer.write(row.joinToString(" ") + "\n")
        }
    }

    // 문자열 뒤집기
    private fun reverseString(s: String): String = s.reversed()

    // 배열 내 최대값과 인덱스
    private fun findMaxWithIndex(arr: List<Int>): Pair<Int, Int> {
        val maxValue = arr.maxOrNull() ?: 0
        val maxIndex = arr.indexOf(maxValue)
        return Pair(maxValue, maxIndex)
    }

    // 그래프 문제를 위한 인접 리스트 생성
    private fun createAdjacencyList(
        n: Int,
        edges: List<Pair<Int, Int>>,
    ): Array<MutableList<Int>> {
        val graph = Array(n + 1) { mutableListOf<Int>() }
        for ((u, v) in edges) {
            graph[u].add(v)
            graph[v].add(u) // 양방향 그래프의 경우
        }
        return graph
    }

    // 가중치 그래프를 위한 인접 리스트 생성
    private fun createWeightedAdjacencyList(
        n: Int,
        edges: List<Triple<Int, Int, Int>>,
    ): Array<MutableList<Pair<Int, Int>>> {
        val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
        for ((u, v, w) in edges) {
            graph[u].add(Pair(v, w))
            graph[v].add(Pair(u, w)) // 양방향 그래프의 경우
        }
        return graph
    }

    // 순열 생성 (재귀)
    private fun <T> permute(
        list: List<T>,
        start: Int = 0,
        result: MutableList<List<T>> = mutableListOf(),
    ): List<List<T>> {
        if (start == list.size) {
            result.add(list.toList())
        } else {
            for (i in start until list.size) {
                val newList = list.toMutableList()
                Collections.swap(newList, start, i)
                permute(newList, start + 1, result)
            }
        }
        return result
    }

    // 조합 생성 (예: n개 중 r개 선택)
    private fun <T> combine(
        list: List<T>,
        r: Int,
    ): List<List<T>> {
        val result = mutableListOf<List<T>>()
        combinationHelper(list, 0, r, mutableListOf(), result)
        return result
    }

    private fun <T> combinationHelper(
        list: List<T>,
        start: Int,
        r: Int,
        current: MutableList<T>,
        result: MutableList<List<T>>,
    ) {
        if (current.size == r) {
            result.add(current.toList())
            return
        }

        for (i in start until list.size) {
            current.add(list[i])
            combinationHelper(list, i + 1, r, current, result)
            current.removeAt(current.size - 1)
        }
    }
}
