package com.zero.eazy;
/**
 * 7. 整数反转
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 */

/**
 * @author: zero
 * @description: []
 * @time: 2020-01-29
 * @version: []
 */
public class No7IntegerReverse {


    public static void main(String[] args) {
        System.out.println(reverse(2147483647));
    }

    public static int reverse(int i) {
        String number = String.valueOf(i);
        if (0 == i) {
            return i;
        } else if (0 > i) {
            number = number.substring(1);
        }
        int len = number.length();
        StringBuilder sb = new StringBuilder();
        for (int j = len - 1; j >= 0; j--) {
            sb.append(number.charAt(j));
        }
        while ("0".equals(sb.charAt(0))) {
            sb.substring(1);
        }
        int output = 0;
        try {
            output = Integer.parseInt(sb.toString());

        } catch (NumberFormatException e) {
            return 0;
        }
        return 0 > i ? 0 - output : output;
    }

    /**
     * 官方解法
     *
     * //pop operation:
     * pop = x % 10;
     * x /= 10;
     *
     * //push operation:
     * temp = rev * 10 + pop;
     * rev = temp;
     *
     * @param x 输入int
     * @return 输出反转的int
     */
    public static int reverse2(int x){
        //反转后的数
        int rev = 0;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            //正数情况，小于
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
