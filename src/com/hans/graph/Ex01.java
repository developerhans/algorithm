package com.hans.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Keys and Rooms - https://leetcode.com/problems/keys-and-rooms/
 *
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
 * When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.
 *
 * Example 1:
 * Input: rooms = [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We visit room 0 and pick up key 1.
 * We then visit room 1 and pick up key 2.
 * We then visit room 2 and pick up key 3.
 * We then visit room 3.
 * Since we were able to visit every room, we return true.
 *
 * Example 2:
 * Input: rooms = [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
 */
public class Ex01 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];
        dfs(rooms.get(0), 0, rooms, visited);

        for(int i=0;i<visited.length;i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<Integer> keysInRoom, int room, List<List<Integer>> rooms, boolean[] visited) {
        visited[room] = true;

        for(Integer i: keysInRoom) {
            if(!visited[i]) {
                dfs(rooms.get(i), i, rooms, visited);
            }
        }
    }

    public static void main(String[] args) {
        //int[][] ex = [[1,3],[3,0,1],[2],[0]];
        Integer[][] temp = {{1,3}, {3,0,1}, {2}, {0}};
        //Integer[][] temp = {{1}, {2}, {3}, {}};

        List<List<Integer>> ex = new ArrayList<>();
        ex.add(new ArrayList<>(Arrays.asList(temp[0])));
        ex.add(new ArrayList<>(Arrays.asList(temp[1])));
        ex.add(new ArrayList<>(Arrays.asList(temp[2])));
        ex.add(new ArrayList<>(Arrays.asList(temp[3])));

        for (List i:ex) {
            i.stream().forEach(a -> {
                System.out.print(a + ", ");
            });
            System.out.println();
        }

        System.out.println(new Ex01().canVisitAllRooms(ex));

    }
}
