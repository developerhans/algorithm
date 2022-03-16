package com.hans.greedy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 문제 : 회의시간
 *
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들 려고 한다. 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고,
 * 각 회의가 겹치지 않게 하 면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라. 단, 회의는 한번 시작하면 중간에 중 단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 *
 * 입력설명
 * 첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정 보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
 * 회의 시간은 0시부터 시작된다.
 * 회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.
 *
 * 출력설명
 * 첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.
 *
 * 입력예제 1
 * 1 4
 * 2 3
 * 3 5
 * 4 6
 * 5 7
 *
 * 출력예제 1
 * 3
 *
 * 입력예제 2
 * 3 3
 * 1 3
 * 2 3
 *
 * 출력예제 2
 * 2
 *
 */
class Time implements Comparable<Time>{
    public int s, e;
    Time(int s, int e) {
        this.s = s;
        this.e = e;
    }
    @Override
    public int compareTo(Time o){
        if(this.e==o.e) return this.s-o.s;
        else return this.e-o.e;
    }
}

public class Ex02 {
    public int solution(ArrayList<Time> arr){
        int cnt=0;
        Collections.sort(arr);
        int et=0;
        for(Time ob : arr){
            if(ob.s>=et){
                cnt++;
                et=ob.e;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        ArrayList<Time> list = new ArrayList<>();
        list.add(new Time(1, 4));
        list.add(new Time(2, 3));
        list.add(new Time(3, 5));
        list.add(new Time(4, 6));
        list.add(new Time(5, 7));

        System.out.print(new Ex02().solution(list));
    }
}
