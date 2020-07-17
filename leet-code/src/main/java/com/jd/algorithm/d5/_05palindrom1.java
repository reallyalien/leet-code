package com.jd.algorithm.d5;
//中心扩散法
public class _05palindrom1 {

    public static void main(String[] args) {
        String s="cbbabd";
        String s1 = longPalindromic(s);
        System.out.println(s1);
    }
    public static String longPalindromic(String str){
        if (str==null || str.length()==0) return "";
        int strLen=str.length();
        int left=0,right=0;//left和right指的是左边和右边回文数的头和尾，比如说aba，left指向-1位置，right指向3，字符串截取要从left+1开始。
        int len=1;//左右扩散的滑动窗口的大小。
        int maxStart=0;
        int maxlen=0;
        for (int i = 0; i < strLen; i++) {
            left=i-1;
            right=i+1;
            char c = str.charAt(i);
            //向左寻找不一样的
            while (left >= 0 && str.charAt(left)==c){
                len++;
                left--;
            }
            //向右寻找不一样的，
            while (right < strLen && str.charAt(right)==c){
                len++;
                right++;
            }
            //判断左右2头的数是否一样，比如说aba
            while (left >= 0 && right < strLen && str.charAt(right)==str.charAt(left)){
                len+=2;
                left--;
                right++;
            }
            if (len > maxlen){
                maxlen=len;
                maxStart=left+1;//一次循环结束最大回文子串的起始下标。
            }
            len=1;
        }
        return str.substring(maxStart,maxStart+maxlen);
    }
}
