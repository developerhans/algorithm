package com.hans.string;

/**
 * 문제 : 문자열 압축
 *  - 조건
 *    - 입력받은 문자열 s를 짧은 문자열로 압축 하여라
 *      - ex
 *          - 입력 : KKHSSSSSSSE, 출력 : K2HS7E
 *          - 입력 : KSTTTSEEKFKKKDJJGG, 출력 : KST3SE2KFK3DJ2G2
 *  - 스스로 생각
 *    - 기존 알고리즘은 공백을 입력 문자열에 공백을 추가하여 문자 마지막 처리를 완성하였으나, 수정을 통하여 문자를 추가하는것을 뺴고 마지막 문자 처리를 하여 완료함.
 *    - 약 1~3ms 이득이 생김.
 */
public class Ex07 {

    /*public String solution(String s){
        String answer="";
        s=s+" ";
        int cnt=1;
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)==s.charAt(i+1)) cnt++;
            else{
                answer+=s.charAt(i);
                if(cnt>1) answer+=String.valueOf(cnt);
                cnt=1;
            }
        }
        return answer;
    }*/

    public String solution(String s){
        String answer="";
        int cnt=1;

        for(int i=0; i<s.length(); i++){

            if(i == s.length() - 1) {
                answer+=s.charAt(i);
                if(cnt > 1) {
                    answer+=String.valueOf(cnt);
                }

                return answer;
            }

            if(s.charAt(i) == s.charAt(i+1)) cnt++;
            else{
                answer+=s.charAt(i);
                if(cnt>1) answer+=String.valueOf(cnt);
                cnt=1;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        long st = System.currentTimeMillis();
        String ex = "KSTTTSEEKFKKKDJJGGKSTTTSEEKFKKKDJJGGKSTTTSEEKFKKKDJJGGKSTTTSEEKFKKKDJJGGKSTTTSEEKFKKKDJJGGKSTTTSEEKFKKKDJJGGKSTTTSEEKFKKKDJJGG";
        Ex07 t = new Ex07();
        String result = t.solution(ex);
        System.out.println("result = " + result);
        System.out.println("run time = " + (System.currentTimeMillis() - st) + "ms");
    }
}
