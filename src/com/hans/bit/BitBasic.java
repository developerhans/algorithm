package com.hans.bit;

public class BitBasic {

    // 특정 비트의 값을 조회
    private static boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    // 특정 비트의 값을 변경
    private static int setBit(int num, int i) {
        return num | (1 << i);
    }

    /** 모든 비트가 그대로인 상태에서 특정 비트만 0으로 만듬
     - 특정 비트까지 시프트
     - '~' not 연산
     - 원본값고 and 연산
     */
    private static int clearBit(int num, int i) {
        return num & ~(1 << i);
    }

    /**
     * 뒤에서 특정 비트까지만 0으로 만들고 싶을때
     * - 특정 비트까지 시프트
     * - 스프트한 결과에서 1을 뺀다.
     * - 두수를 and 연산.
     *
     * not을하면 앞에 있는 0도 1로 바뀜
     *
     *  10101001
     * & 0000111
     * ---------
     *   0000001
     *
     */
    private static int clearLeftBits(int num, int i) {
        return num & ((1 << i) -1);
    }

    /**
     * 인덱스를 포함하여 특정 비트 오른쪽을 0으로 만들고 싶을떄
     * - 모든 비트가 1인 비트는 -1임
     * - -1을 특정 비트까지 시프트, 시프트한만큼 뒤에 0인 마스크 생성
     * - 두수를 and연산
     *
     */
    private static int clearRightBits(int num, int i) {
        return num & (-1 << (i + 1));
    }

    /**
     * 해당 비트를 클리어한 후 and연산
     */

    private static int updateBit(int num, int i, boolean val) {
        return num & ~(1 << i) | ((val? 1:0) << i);
    }

    public static void main(String[] args) {

        // 1001
        System.out.println(getBit(9, 3));

        // 0101
        System.out.println(getBit(5, 3));

        // 1101
        System.out.println(setBit(5, 3));

        // 1001
        System.out.println(clearBit(9, 3));

        // 10101001
        System.out.println(clearLeftBits(169, 3));

        // 10101001 -> 10100000
        System.out.println(clearRightBits(169, 3));

        // 10101001 -> 10100001
        System.out.println(updateBit(169, 3, false));
    }
}
