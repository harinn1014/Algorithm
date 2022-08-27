package com.programmers;
// https://school.programmers.co.kr/learn/courses/30/lessons/43162#

import java.util.*;

class Solution {
    static boolean[] visit;
    static Queue<Integer> queue = new LinkedList<Integer>();

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visit[i]) {
                continue;
            }
            answer++;
            bfs(computers, i, n);
        }

        return answer;
    }

    public void bfs(int[][] arr, int start, int len) {
        int x;
        queue.offer(start);

        while (!queue.isEmpty()) {
            x = queue.poll();

            for (int y = 0; y < len; y++) {
                if ((arr[y][x] == 1 || arr[x][y] == 1) && !visit[y]) {
                    visit[y] = true;
                    queue.offer(y);
                }
            }
        }
    }
}
