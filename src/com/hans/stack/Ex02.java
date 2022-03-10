package com.hans.stack;

import java.util.Stack;

/**
 * 문제 : 후위식 연산(postfix)
 * 
 * 설명
 * 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
 * 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
 * 
 * 입력
 * 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
 * 식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
 * 
 * 출력
 * 연산한 결과를 출력합니다.
 */
public class Ex02 {

    public int solution(String str){
        int answer=0;
        Stack<Integer> stack = new Stack<>();
        for(char x : str.toCharArray()){
            if(Character.isDigit(x)){
                stack.push(x-48);
            }
            else{
                int rt=stack.pop();
                int lt=stack.pop();
                if(x=='+') stack.push(lt+rt);
                else if(x=='-') stack.push(lt-rt);
                else if(x=='*') stack.push(lt*rt);
                else if(x=='/') stack.push(lt/rt);
            }
        }
        answer=stack.get(0);
        return answer;
    }

    public static void main(String[] args) {

        String ex1 = "352+*9-";
        Ex02 t = new Ex02();
        int result = t.solution(ex1);
        System.out.print(result);
    }
}
