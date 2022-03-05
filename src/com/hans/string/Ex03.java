package com.hans.string;

/**
 * 문제 : 중복 문자 제거
 *  - 조건
 *    - 중복 문자 제거
 *
 *  - 스스로 생각
 *    - hashmap을 활용 하는 방법
 *    - set을 활용 하는 방법
 *    - 위 두가지를 생각할 수 있는데, 어차피 모든 케릭터는 탐색이 필요한 상황에서, 현재 탐색 위치와 charAt 케릭터의 위치를 이용하여 풀이.
 */
public class Ex03 {

    public String solution(String str){
        String answer="";
        for(int i=0; i<str.length(); i++){
            //System.out.println(str.charAt(i)+" "+i+" "+str.indexOf(str.charAt(i)));
            if(str.indexOf(str.charAt(i))==i) answer+=str.charAt(i);
        }
        return answer;
    }

    public static void main(String[] args){
        String ex = "ksekkset";

        Ex03 t = new Ex03();
        String result = t.solution(ex);
        System.out.println("> " + result);
    }
}
