package com.hans.string;

import java.util.ArrayList;

/**
 * 문제 : 단어 뒤집기
 *
 * new StringBuilder(x).reverse().toString(); 과 같이 메서드를 이용하여 진행 할 수도 있으나
 * 두개의 포인터를 이용하여 직접 뒤집을 수도 있다.
 */
public class Ex01 {

    public ArrayList<String> solution(String[] str){
        ArrayList<String> answer=new ArrayList<>();
        for(String x : str){
            char[] s=x.toCharArray();
            int lt=0, rt=x.length()-1;
            while(lt<rt){
                char tmp=s[lt];
                s[lt]=s[rt];
                s[rt]=tmp;
                lt++;
                rt--;
            }
            String tmp=String.valueOf(s);
            answer.add(tmp);
        }
        return answer;
    }

    public static void main(String[] args){
        String[] ex = {"good", "Time", "Big"};

        Ex01 t = new Ex01();
        ArrayList<String> result = t.solution(ex);

        for (String i:result) {
            System.out.println("> " + i);
        }
    }
}
