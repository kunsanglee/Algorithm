package practice.백준.bfs_dfs.gold.불_5427

import java.util.LinkedList
import java.util.Queue

fun main() {
    Solution2().solve()
}

class Solution {
    private val reader = System.`in`.bufferedReader()
    private val writer = System.out.bufferedWriter()
    private val dx = intArrayOf(0, 0, -1, 1)
    private val dy = intArrayOf(1, -1, 0, 0)

    fun solve() {
        val caseCount = reader.readLine().toInt()
        repeat(caseCount) {
            val (w, h) = reader.readLine().split(" ").map { it.toInt() }
            val map = Array(h) { reader.readLine().toCharArray() }

            val fireQueue: Queue<Pair<Int, Int>> = LinkedList()
            val personQueue: Queue<Triple<Int, Int, Int>> = LinkedList() // y, x, time

            // 1. 초기 위치 큐에 추가
            for (i in 0 until h) {
                for (j in 0 until w) {
                    when (map[i][j]) {
                        '@' -> {
                            personQueue.add(Triple(i, j, 0))
                            map[i][j] = '.' // 상근이가 있던 곳도 빈 공간으로 취급해야 불이 번질 수 있음
                        }
                        '*' -> fireQueue.add(Pair(i, j))
                    }
                }
            }

            var result: String? = null

            // 2. BFS 루프 시작
            while (personQueue.isNotEmpty()) {
                // ① 불 확산
                val fireSpreadCount = fireQueue.size
                repeat(fireSpreadCount) {
                    val (y, x) = fireQueue.poll()

                    for (i in 0 until 4) {
                        val ny = y + dy[i]
                        val nx = x + dx[i]

                        if (ny in 0 until h && nx in 0 until w && map[ny][nx] == '.') {
                            map[ny][nx] = '*'
                            fireQueue.add(Pair(ny, nx))
                        }
                    }
                }

                // ② 사람 이동
                val personMoveCount = personQueue.size
                if (personMoveCount == 0) break // 사람이 더 이상 움직일 곳이 없으면 종료

                repeat(personMoveCount) {
                    val (y, x, time) = personQueue.poll()

                    // 탈출 조건: 현재 위치가 가장자리인 경우
                    if (y == 0 || y == h - 1 || x == 0 || x == w - 1) {
                        result = (time + 1).toString()
                        // 큐를 비워서 while 루프를 탈출하도록 함
                        personQueue.clear()
                        return@repeat
                    }

                    for (i in 0 until 4) {
                        val ny = y + dy[i]
                        val nx = x + dx[i]

                        // 이동 조건: 범위 내, 빈 공간
                        if (ny in 0 until h && nx in 0 until w && map[ny][nx] == '.') {
                            map[ny][nx] = '@' // 방문 표시 (다시 큐에 넣지 않기 위함)
                            personQueue.add(Triple(ny, nx, time + 1))
                        }
                    }
                }
                if (result != null) break
            }

            writer.write("${result ?: "IMPOSSIBLE"}\n")
        }
        writer.flush()
        writer.close()
        reader.close()
    }
}
