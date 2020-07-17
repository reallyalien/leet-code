package com.jd.algorithm.d11;
//盛水最多的容器，双指针
public class _11maxArea {
    public static void main(String[] args) {
        int[] arr={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
    public static int maxArea(int[] arr){//9   0--8
        int head=0;
        int tail=arr.length-1;
        int maxArea=0;
        while (head < tail){
            int area=Math.min(arr[head],arr[tail])* (tail-head);//计算当前区域的面积
            maxArea=Math.max(area,maxArea);
            if (arr[head] <= arr[tail]){//移动数值小的一端，此时距离缩小，当值有可能变大，如果移动较大的指针，水箱的高度由数值小的一
                                        //方决定，若移动之后数值变大或变小，则水箱高度则不会超过之前的拿个水箱高度,
                                        //移动小的有可能变大，但移动大的，则肯定不会变大
                ++head;
            }else {
                --tail;
            }
        }
        return maxArea;
    }
}
