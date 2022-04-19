package com.hans.backup.programmers.lv1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발하려 합니다. 무지가 개발하려는 시스템은 다음과 같습니다.
 *
 * 각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
 * 신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
 * 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
 * k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
 * 유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
 *
 * 1. 하는것
 *  - 불량 이용자 신고
 *  - 처리 결과 메일 발송
 *    - 유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
 *
 * 2. 조건
 *  - 각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
 *  - k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
 *
 *
 *  - 신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
 *  - 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
 *
 * 3. 알아야 할것
 *  - 신고자 아이디
 *  - 정지된 아이디
 */

public class Level1_Ex01 {
    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];

            List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());

            // 메모이제이션
            HashMap<String, Set<String>> reportMap = new HashMap<>();
            HashMap<String, Integer> resultMap = new HashMap<>();

            // 초기화
            for(String r : id_list) {
                reportMap.put(r, new HashSet<>());
                resultMap.put(r, 0);
            }

            for(String r : report) {
                String [] item = r.split(" ");
                String reportId = item[0];
                String targetId = item[1];

                if(!reportMap.get(targetId).contains(reportId))
                    reportMap.get(targetId).add(reportId);
            }

            for(String key : reportMap.keySet()) {
                if(reportMap.get(key).size() >= k) {
                    for (String id:reportMap.get(key)) {
                        resultMap.put(id, resultMap.get(id) + 1);
                    }
                }
            }

            // 결과도출
            for(int i = 0; i < id_list.length; i++) {
                answer[i] = resultMap.get(id_list[i]);
            }

            return answer;
        }

        /*public int[] solution(String[] id_list, String[] report, int k) {
            List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
            HashMap<String, Integer> count = new HashMap<>();
            for (String s : list) {
                String target = s.split(" ")[1];
                count.put(target, count.getOrDefault(target, 0) + 1);
            }

            int[] result = Arrays.stream(id_list).map(_user -> {
                final String user = _user;
                List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
                System.out.print(user + " : ");
                for (String r:reportList) {
                    System.out.print(r + ", ");
                }
                System.out.println();

                return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
            }).mapToInt(Long::intValue).toArray();

            return result;
        }*/
    }

    public static void main(String[] args) {
        String[] ids = {"muzi", "frodo", "apeach", "neo"};
        //String[] result = {2,1,1,0};

        String[] reports = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        int[] result = new Solution().solution(ids, reports, k);
    }
}
