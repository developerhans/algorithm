package com.hans.ex.kakao;

import java.util.Locale;
import java.util.regex.Pattern;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/72410
 *
 * 카카오에 입사한 신입 개발자 네오는 "카카오계정개발팀"에 배치되어, 카카오 서비스에 가입하는 유저들의 아이디를 생성하는 업무를 담당하게 되었습니다. "네오"에게 주어진 첫 업무는 새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때, 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발하는 것입니다.
 * 다음은 카카오 아이디의 규칙입니다.
 *
 * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
 * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
 * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
 * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
 * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
 * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
 *      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
 * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
 *
 * 아이디어
 * 1. 7단계를 순차적으로 제거해나가는 방법
 * 2. 정규식으로 처리하는 방법
 */
public class IdRecommend {
    static class Solution {
        public String solution(String new_id) {
            String answer = "";

            // case 1
            answer = new_id.toLowerCase(Locale.ROOT);
            System.out.println("case 1 : " + answer);

            // case 2
            answer = answer.replaceAll("[^\\d\\w._-]", "");
            System.out.println("case 2 : " + answer);

            // case 3
            answer = answer.replaceAll("\\.+", ".");
            System.out.println("case 3 : " + answer);

            // case 4
            answer = answer.replaceAll("^[.]|[.]$", "");
            System.out.println("case 4 : " + answer);

            // case 5
            answer = answer.replaceAll("^$", "a");
            System.out.println("case 5 : " + answer);

            // case 6
            Pattern p = Pattern.compile("^((.){1,15}){1,15}");
            answer = p.matcher(answer).group();
            System.out.println("case 6 : " + answer);



            return answer;
        }
    }

    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklmabcdefghijklmabcdefghijklm";
        //String new_id = "";
        Solution solution = new Solution();
        String result = solution.solution(new_id);

        System.out.println(result);
    }
}
