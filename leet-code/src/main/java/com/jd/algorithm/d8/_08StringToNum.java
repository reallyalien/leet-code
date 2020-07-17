package com.jd.algorithm.d8;

public class _08StringToNum {
    public static void main(String[] args) {
        System.out.println(myAtoi("1234kk"));
    }
    public static int myAtoi(String str){
        char one = str.charAt(0);
        if (one >'A' && one < 'z') return 0;
        if (one == '+' || one == '-' || one >'0' && one < '9') {
            StringBuilder stringBuilder=new StringBuilder();
            stringBuilder.append(one);
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) > '0' && str.charAt(i) < '9'){
                    stringBuilder.append(str.charAt(i));
                }else {
                    break;
                }
            }
            return Integer.parseInt(stringBuilder.toString());
        }
        return 0;
    }

}
