package com.hans.string;

/**
 * 문제 : 문자열 암호화
 *  - 조건
 *    1. “#*****#”를 일곱자리의 이진수로 바꿉니다. #은 이진수의 1로, *이진수의 0으로 변환합니다. 결과는 “1000001”로 변환됩니다.
 *    2. 바뀐 2진수를 10진수화 합니다. “1000001”을 10진수화 하면 65가 됩니다.
 *    3. 아스키 번호가 65문자로 변환합니다. 즉 아스크번호 65는 대문자 'A'입니다.
 *    참고로 대문자들의 아스키 번호는 'A'는 65번, ‘B'는 66번, ’C'는 67번 등 차례대로 1씩 증가하여 ‘Z'는 90번입니다.
 *    현수가 4개의 문자를 다음과 같이 신호로 보냈다면
 *    #****###**#####**#####**##**
 *    이 신호를 4개의 문자신호로 구분하면
 *    #****## --> 'C'
 *    #**#### --> 'O'
 *    #**#### --> 'O'
 *    #**##** --> 'L'
 *
 * 최종적으로 “COOL"로 해석됩니다.
 *  - 스스로 생각
 *    - 기존은 문자열을 대상을 다른 변수에 담는 방법이였음.
 *    - i * 7, i * 7 + 7, 와 같은 알고리즘을 통하여 추가 변수이용을 제한함.
 *    - TODO: replace 말고 다른 방법을 찾아보기.
 */
public class Ex08 {

    /*public String solution(int n, String s){
        String answer="";
        for(int i=0; i<n; i++){
            String tmp=s.substring(0, 7).replace('#', '1').replace('*', '0');
            int num=Integer.parseInt(tmp, 2);
            answer+=(char)num;
            s=s.substring(7);
        }
        return answer;
    }*/

    public String solution(int n, String s){
        String answer="";
        for(int i=0; i<n; i++){
            if(i == 0) {
                answer+=(char)Integer.parseInt(s.substring(0, 7).replace('#', '1').replace('*', '0'), 2);
            } else {
                answer+=(char)Integer.parseInt(s.substring(i * 7, i * 7 + 7).replace('#', '1').replace('*', '0'), 2);
            }
        }
        return answer;
    }


    public static void main(String[] args){
        long st = System.currentTimeMillis();
        String ex = "#****###**#####**#####**##**";
        int exCharSize = 4;
        Ex08 t = new Ex08();
        String result = t.solution(exCharSize, ex);
        System.out.println("result = " + result);
        System.out.println("run time = " + (System.currentTimeMillis() - st) + "ms");
    }
}
