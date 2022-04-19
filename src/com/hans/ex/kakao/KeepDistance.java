package com.hans.ex.kakao;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/81302
 *
 * 개발자를 희망하는 죠르디가 카카오에 면접을 보러 왔습니다.
 *
 * 코로나 바이러스 감염 예방을 위해 응시자들은 거리를 둬서 대기를 해야하는데 개발 직군 면접인 만큼
 * 아래와 같은 규칙으로 대기실에 거리를 두고 앉도록 안내하고 있습니다.
 *
 * 대기실은 5개이며, 각 대기실은 5x5 크기입니다.
 * 거리두기를 위하여 응시자들 끼리는 맨해튼 거리1가 2 이하로 앉지 말아 주세요.
 * 단 응시자가 앉아있는 자리 사이가 파티션으로 막혀 있을 경우에는 허용합니다.
 */
public class KeepDistance {
    static class Solution {

        class Point {
            Point(int r, int c, int d) {
                row = r;
                col = c;
                dist = d;
            }
            int row, col, dist;
        }

        int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean bfs(String[] place, int row, int col) {
            boolean[][] visited = new boolean[5][5];

            Queue<Point> q = new LinkedList<>();
            visited[row][col] = true;
            q.add(new Point(row, col, 0));

            while (!q.isEmpty()) {
                Point curr = q.remove();

                if(curr.dist > 2) continue;
                if(curr.dist != 0 && place[curr.row].charAt(curr.col) == 'P')
                    return false;

                for(int i = 0; i < 4; ++i) {
                    int nr = curr.row + D[i][0];
                    int nc = curr.col + D[i][1];

                    if(nr < 0 || nr > 4 || nc < 0 || nc > 4) continue;
                    if(visited[nr][nc]) continue;
                    if(place[nr].charAt(nc) == 'X') continue;
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, curr.dist + 1));
                }
            }

            return true;
        }

        boolean check(String[] place) {
            for(int r = 0; r < 5; ++r) {
                for(int c = 0; c < 5; ++c) {
                    if(place[r].charAt(c) == 'P') {
                        if(bfs(place, r, c) == false)
                            return false;
                    }
                }
            }

            return true;
        }

        public int[] solution(String[][] places) {
            int[] answer = new int[5];

            for(int i = 0; i < 5; ++i) {
                if(check(places[i]))
                    answer[i] = 1;
                else
                    answer[i] = 0;
            }


            return answer;
        }
    }

    public static void main(String[] args) {

        String[][] plases = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        Solution solution = new Solution();
        int[] result = solution.solution(plases);

        Arrays.stream(result).forEach(s -> System.out.println(s));
    }
}
