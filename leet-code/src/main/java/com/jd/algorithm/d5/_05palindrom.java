package com.jd.algorithm.d5;

/**
 * 时间复杂度O(n^3) ，双重for循环还在内部判断
 */
public class _05palindrom {
    public static void main(String[] args) {
        String s="cbbd";
        String s1 = longPalindrom(s);
        System.out.println(s1);
    }

    public static String longPalindrom(String s){
        int max=0;
        String result="";
        int len=s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len; j++) {
                String test=s.substring(i,j);
                if (isPalindromic(test) && test.length() >= max){
                    result=test;
//                    max=Math.max(max,result.length());
                    max=result.length();
                }
            }
        }
        return result;
    }
    public static boolean isPalindromic(String s) {
        //len=5   len=6
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
