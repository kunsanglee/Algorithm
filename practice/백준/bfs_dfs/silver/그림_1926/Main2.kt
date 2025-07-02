package practice.백준.bfs_dfs.silver.그림_1926

import java.io.BufferedReader
import java.io.BufferedWriter

fun main() {
    Solution().solve()
}

class Solution(
    private val reader: BufferedReader = System.`in`.bufferedReader(),
    private val writer: BufferedWriter = System.out.bufferedWriter(),
) {
    fun solve() {
        val (n, m) = reader.readLine().split(" ").map { it.toInt() }

        val dx = intArrayOf(0, 0, -1, 1)
        val dy = intArrayOf(1, -1, 0, 0)

        val grid = Array(n) { IntArray(m) }
        val visited = Array(n) { BooleanArray(m) }

        for (i in 0 until n) {
            val line = reader.readLine().split(" ").map { it.toInt() }
            for (j in 0 until m) {
                grid[i][j] = line[j]
            }
        }

        var count = 0
        var maxSize = 0

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (grid[i][j] == 1 && !visited[i][j]) { // 그림이 있고, 방문하지 않았다면
                    // 그림이 발견된 현재 위치에서 상 하 좌 우 모두 큐에 추가
                    count++
                    val queue = ArrayDeque<Pair<Int, Int>>()
                    enqueueAndCheckVisit(queue, i, j, visited)
                    var size = 0

                    while (queue.isNotEmpty()) {
                        size++
                        val (x, y) = queue.removeFirst()
                        visited[x][y] = true
                        for (d in 0 until 4) {
                            val nx = x + dx[d]
                            val ny = y + dy[d]
                            if (nx in 0 until n && ny in 0 until m && grid[nx][ny] == 1 && !visited[nx][ny]) {
                                enqueueAndCheckVisit(queue, nx, ny, visited)
                            }
                        }
                    }

                    maxSize = maxOf(maxSize, size)
                }
            }
        }

        writer.write("$count\n$maxSize")
        writer.flush()
        writer.close()
    }

    private fun enqueueAndCheckVisit(
        queue: ArrayDeque<Pair<Int, Int>>,
        i: Int,
        j: Int,
        visited: Array<BooleanArray>,
    ) {
        queue.add(Pair(i, j))
        visited[i][j] = true
    }
}
