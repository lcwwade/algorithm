package com.zero.eazy;

/**
 * 67.二进制求和
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class No67AddBinary {
    /**
     * 转成字符串相加
     * @param a 数1
     * @param b 数2
     * @return
     */
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        StringBuilder a1 = new StringBuilder(a);
        StringBuilder b1 = new StringBuilder(b);
        StringBuilder temp = new StringBuilder();
        if (len1 == 0)
        {
            return b;
        }
        else if (len2 == 0)
        {
            return a;
        }
        else if (len1 > len2)
        {
            for (int i = 0; i < (len1 - len2); i++)
            {
                temp.append("0");
            }
            b1 = temp.append(b1);
        }
        else if (len2 > len1)
        {
            for (int i = 0; i < (len2 - len1); i++)
            {
                temp.append("0");
            }
            a1 = temp.append(a1);
        }
        StringBuilder total = new StringBuilder();
        int carry=0, temp1, temp2, sum;
        for (int i = a1.length() - 1; i >= 0; i--)
        {
            temp1 = a1.charAt(i) - '0';
            temp2 = b1.charAt(i) - '0';
            sum = temp1 + temp2 + carry;
            carry = sum / 2;
            total.append(sum % 2);
        }
        total.reverse();
        return carry > 0 ? "1" + total.toString() : total.toString();
    }
}
