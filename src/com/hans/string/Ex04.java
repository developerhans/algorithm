package com.hans.string;

/**
 * 문제 : 회문 문자열
 *  - 조건
 *    - 입력받은 문자열을 뒤집어도 동일한 문자열인지를 판단.
 *
 *  - 스스로 생각
 *    - 앞, 뒤 두가지 포인터를 이용하여 풀이하는 방법을 생각하였음,
 *    - 다른 방법으로 입력받은 문자열을 뒤집고(new StringBuilder(str).reverse().toString()) 비교(equalsIgnoreCase) 해도 결과는 같음.
 *    - 단, 비용이득이 어느쪽이 큰지는 판단이 필요, 테스트는 없었으나 일단 뒤집는것 보다는 케릭터를 체크하는게 더 적은 비용이라고 생각함.
 */
public class Ex04 {

    public String solution(String str){
        String answer="YES";
        str=str.toUpperCase();
        int len=str.length();
        for(int i=0; i<len/2; i++){
            if(str.charAt(i)!=str.charAt(len-i-1)) answer="NO";
        }
        return answer;
    }

    public String solution1(String str){
        String answer="NO";
        String tmp=new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(tmp)) answer="YES";
        return answer;
    }

    public static void main(String[] args){
        String ex = "gooG";
        Ex04 t = new Ex04();
        String result = t.solution1(ex);
        System.out.println("> " + result);
    }
}
