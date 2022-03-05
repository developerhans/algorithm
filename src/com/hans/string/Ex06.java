package com.hans.string;

/**
 * 문제 : 문자거리
 *  - 조건
 *    - 입력받은 문자열 s, 타겟 문자 t가 주어진다. 문자열의 각 문자는 타켓문자와 떨어진 거리를 순서대로 출력해라.
 *
 *  - 스스로 생각
 *    - 해당 코드는 왼쪽, 오른쪽 방향 한번씩 체크하여 결과를 도출함.
 *    - 반복문 한번으로 할 수 있는 방법이 있을것 같기도 한데..
 */
public class Ex06 {

    public int[] solution(String s, char t){
        int[] answer=new int[s.length()];
        int p=1000;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==t){
                p=0;
                answer[i]=p;
            }
            else{
                p++;
                answer[i]=p;
            }
        }
        p=1000;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)==t) p=0;
            else{
                p++;
                answer[i]=Math.min(answer[i], p);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        String ex = "teachermode";
        char target = 'e';
        Ex06 t = new Ex06();
        int [] result = t.solution(ex, target);
        for (int i: result) {
            System.out.print(i +" ");
        }

    }
}
