package com.hans.string;

/**
 * 문제 : 회문 문자열
 *  - 조건
 *    - 입력받은 문자열에서 알파벳만 활용하여 뒤집어도 동일한 문자열인지를 판단.
 *    - ex04와 같은 문제이지만, 알파벳만 활용한다는 조건이 포함.
 */
public class Ex05 {

    public String solution(String s){
        String answer="NO";
        s=s.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp=new StringBuilder(s).reverse().toString();
        if(s.equals(tmp)) answer="YES";
        return answer;
    }

    public static void main(String[] args){
        String ex = "found7, time: study; Yduts; emit, 7Dnuof";
        Ex05 t = new Ex05();
        String result = t.solution(ex);
        System.out.println("> " + result);
    }
}
