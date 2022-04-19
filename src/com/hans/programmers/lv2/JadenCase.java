package com.hans.programmers.lv2;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

/**
 * JadenCase 문자열 만들기
 *
 * 문제 설명
 * JadenCase란 모든 단어의 첫 문자가 대문자이고,
 * 그 외의 알파벳은 소문자인 문자열입니다.
 * 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
 *
 * 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
 *
 * 제한 조건
 * - s는 길이 1 이상 200 이하인 문자열입니다.
 * - s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
 *   - 숫자는 단어의 첫 문자로만 나옵니다.
 *   - 숫자로만 이루어진 단어는 없습니다.
 *   - 공백문자가 연속해서 나올 수 있습니다.
 *
 * 아이디어
 * 1. 위 조건중 공백문자가 연속해서 나올 수 있습니다.를 선 조치
 * 2. 공백 단위로 분할
 * 3. 솔루션
 *
 * 입출력 예
 * ------------------------------------------------------
 * s	                     |  return
 * ------------------------------------------------------
 * "3people unFollowed me"	 | "3people Unfollowed Me"
 * "for the last week"	     | "For The Last Week"
 * ------------------------------------------------------
 *
 * result = 테스트 17번 통과못함, 테스트 케이스를 알 수 없어.. 이유를 모르겠음.
 *
 * TODO : 큐를 제거하고 문자열 인덱스를 가지고 솔류션을 만드는게 공간을 아낄 수 있음.
 */
public class JadenCase {
    static class Solution {
        public String solution(String s) {
            s = s.toLowerCase(Locale.ROOT);

            StringBuilder sb = new StringBuilder();
            String answer = "";

            Queue<Character> queue = new LinkedList<>();
            for (char c : s.toCharArray()) {
                queue.add(c);
            }

            // 문장에 시작점
            if(queue.peek() >= 97 && queue.peek() <= 122)
                sb.append((char)(queue.poll() - 32));
            else
                sb.append(queue.poll());

            // 공백 다음 문자 처리
            while (!queue.isEmpty()) {
                char target = queue.poll();
                if(target == 32) {
                    sb.append(target);
                    continue;
                }

                if(sb.charAt(sb.length() - 1) == 32) {
                    target = (char)(target - 32);
                }

                sb.append(target);
            }

            answer = sb.toString();
            return answer;
        }
    }

    public static void main(String[] args) {
        String s = "  for   The   Last   Week";

        Solution solution = new Solution();
        System.out.println(solution.solution(s));
    }
}
