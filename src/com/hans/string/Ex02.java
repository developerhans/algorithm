package com.hans.string;

/**
 * 문제 : 단어 뒤집기
 *  - 조건
 *    - 알파벳만 선택하여 텍스트 스왑
 *
 */
public class Ex02 {

    public String solution(String str){
        String answer;

        char[] s=str.toCharArray();
        int lt=0, rt=str.length()-1;

        if(!Character.isAlphabetic(s[lt])) lt++;
        else if(!Character.isAlphabetic(s[rt])) rt--;
        else{
            char tmp=s[lt];
            s[lt]=s[rt];
            s[rt]=tmp;
            lt++;
            rt--;
        }

        answer = String.valueOf(s);
        return answer;
    }

    public static void main(String[] args){
        String ex = "a#b!GE*T@S";

        Ex02 t = new Ex02();
        String result = t.solution(ex);
        System.out.println("> " + result);
    }
}
