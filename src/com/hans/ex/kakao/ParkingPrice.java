package com.hans.ex.kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/92341
 *
 * 주차장의 요금표와 차량이 들어오고(입차) 나간(출차) 기록이 주어졌을 때, 차량별로 주차 요금을 계산하려고 합니다. 아래는 하나의 예시를 나타냅니다.
 */
public class ParkingPrice {
    static class Solution {

        int convert(String time) {
            String[] str =time.split(":");
            return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
        }
        public int[] solution(int[] fees, String[] records) {

            HashMap<String, Integer> intime = new HashMap<>();
            TreeMap<String, Integer> result = new TreeMap<>();

            for(String r : records) {
                String[] str = r.split(" ");
                if(str[2].equals("IN")) {
                    intime.put(str[1], convert(str[0]));
                    if(result.containsKey(str[1]) == false)
                        result.put(str[1], 0);
                } else {
                    result.put(str[1], result.get(str[1]) +
                            convert(str[0]) - intime.get(str[1]));
                    intime.remove(str[1]);
                }
            }

            intime.forEach((key, value) -> {
                result.put(key, result.get(key) + 23 * 60 + 59 - value);
                //intime.remove(key);
            });

            int[] answer = new int[result.size()];
            int idx = 0;
            for(int val : result.values()) {
                answer[idx] = fees[1];
                if(val > fees[0]) {
                    answer[idx] += Math.ceil((val - fees[0]) / (double)fees[2]) * fees[3];
                }
                ++idx;
            }


            return answer;
        }
    }

    public static void main(String[] args) {

        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};


        Solution solution = new Solution();
        int[] result = solution.solution(fees, records);

        Arrays.stream(result).forEach(s -> System.out.println(s));
    }
}
