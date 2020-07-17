package com.jd.algorithm.d8;

public class _08StringToNum1 {
    public static void main(String[] args) {
        System.out.println(myAtoi("-1234kk"));
    }
    public static int myAtoi(String str){
        int len = str.length();
        char[] chars = str.toCharArray();
        //去掉前导空格
        int index=0;
        while (index < len && chars[index] == ' '){
            index++;
        }
        //如果已经遍历完成,针对极端用例 "           ";
        if (index ==len) {
            return 0;
        }
        //如果出现符号字符，仅在第一位
        int sign=1;
        char firstChar = chars[index];
        if (firstChar == '+'){
            index++;
        }else if (firstChar == '-'){
            index++;
            sign = -1;
        }
        //将后续的数字字符进行转换
        int res=0;
        while (index < len){
            char curr = chars[index];
            //先判断不是数字的情况
            if (curr > '9' ||  curr < '0'){
                break;
            }
            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            //curr-'0'计算当前位数的数字
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (curr - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (curr - '0') < -(Integer.MIN_VALUE % 10))) { // -9 < -8
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (curr - '0');
            index++;
        }

        return res;
    }

}
