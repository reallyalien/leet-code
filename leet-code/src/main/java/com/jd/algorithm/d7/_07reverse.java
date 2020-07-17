package com.jd.algorithm.d7;

/**
 * 整数反转
 */
public class _07reverse {
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            //判断溢出条件
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))//21 4748 3647   21亿  8>7
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))//-21 4748 3648   -9<-8
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
}
