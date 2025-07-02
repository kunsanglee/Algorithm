package practice.백준.bfs_dfs.gold.불_5427

import java.util.LinkedList
import java.util.Queue

fun main() {
    Solution2().solve()
}

class Solution2 {
    // data class로 좌표와 상태를 명확하게 표현하여 가독성 향상
    private data class Point(val y: Int, val x: Int)

    private data class PersonState(val y: Int, val x: Int, val time: Int)

    private val reader = System.`in`.bufferedReader()
    private val writer = System.out.bufferedWriter()

    // dx, dy의 의미를 일반적인 관례에 맞게 수정 (dx: x좌표 이동, dy: y좌표 이동)
    private val dx = intArrayOf(1, -1, 0, 0)
    private val dy = intArrayOf(0, 0, 1, -1)

    fun solve() {
        val caseCount = reader.readLine().toInt()
        repeat(caseCount) {
            val (w, h) = reader.readLine().split(" ").map { it.toInt() }
            val map = Array(h) { reader.readLine().toCharArray() }
            // 함수 이름 변경: initializeQueue -> initializeQueues
            val (personQueue, fireQueue) = initializeQueues(h, w, map)

            var result: String? = null

            // 상근이가 더 이상 움직일 곳이 없을 때까지 반복
            while (personQueue.isNotEmpty()) {
                // 1. 불이 먼저 퍼짐
                fireSpread(fireQueue, h, w, map)

                // 2. 상근이 이동
                val moveResult = movePerson(personQueue, h, w, map)

                // 탈출에 성공했다면 결과를 저장하고 루프 종료
                if (moveResult != null) {
                    result = moveResult
                    break
                }
            }

            writer.write("${result ?: "IMPOSSIBLE"}")
        }
        writer.flush()
        writer.close()
    }

    private fun movePerson(
        personQueue: Queue<PersonState>,
        height: Int,
        width: Int,
        map: Array<CharArray>
    ): String? {
        // 현재 턴에서 상근이가 이동할 수 있는 모든 경우를 확인
        val personMoveCount = personQueue.size

        repeat(personMoveCount) {
            val current = personQueue.poll()

            // 가장자리에 도달했다면 탈출 성공
            if (current.y == 0 || current.y == height - 1 || current.x == 0 || current.x == width - 1) {
                return (current.time + 1).toString() // 함수에서 즉시 결과 반환
            }

            for (i in 0 until 4) {
                val ny = current.y + dy[i]
                val nx = current.x + dx[i]

                // 이동할 위치가 맵 범위 안이고, 빈 공간(.)인 경우에만 이동
                if (ny in 0 until height && nx in 0 until width && map[ny][nx] == '.') {
                    map[ny][nx] = '@' // 상근이가 이동했음을 표시
                    personQueue.offer(PersonState(ny, nx, current.time + 1))
                }
            }
        }
        // 이번 턴에 탈출하지 못했으면 null 반환
        return null
    }

    private fun fireSpread(
        fireQueue: Queue<Point>,
        h: Int,
        w: Int,
        map: Array<CharArray>
    ) {
        // 현재 턴에서 불이 번질 수 있는 모든 경우를 확인
        val fireSpreadCount = fireQueue.size

        repeat(fireSpreadCount) {
            val current = fireQueue.poll()

            for (i in 0 until 4) {
                val ny = current.y + dy[i]
                val nx = current.x + dx[i]

                // 불이 번질 위치가 맵 범위 안이고, 벽('#')이 아닌 경우
                if (ny in 0 until h && nx in 0 until w && map[ny][nx] != '#') {
                    // 이미 불이 붙은 곳은 무시
                    if (map[ny][nx] != '*') {
                        map[ny][nx] = '*'
                        fireQueue.offer(Point(ny, nx))
                    }
                }
            }
        }
    }

    private fun initializeQueues(
        height: Int,
        width: Int,
        map: Array<CharArray>
    ): Pair<Queue<PersonState>, Queue<Point>> {
        val personQueue: Queue<PersonState> = LinkedList()
        val fireQueue: Queue<Point> = LinkedList()

        for (i in 0 until height) {
            for (j in 0 until width) {
                when (map[i][j]) {
                    '@' -> {
                        // 상근이의 시작 위치는 빈 공간으로 만들어야 함
                        map[i][j] = '.'
                        personQueue.offer(PersonState(i, j, 0))
                    }
                    '*' -> fireQueue.offer(Point(i, j))
                }
            }
        }
        return Pair(personQueue, fireQueue)
    }
}
