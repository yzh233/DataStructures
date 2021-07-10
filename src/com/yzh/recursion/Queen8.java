package com.yzh.recursion;

import java.lang.reflect.Array;

public class Queen8 {
    // 定义max表示多少个皇后
    int max=8;
    // 定义数组 存放皇后的摆放位置
    int[] arr=new int[max];

    public static void main(String[] args) {

    }
    // 查看当我们放置第n个皇后，就去检查皇后是否和前面的皇后是否冲突

    private boolean judge(int n){
        for (int i=0;i<n;i++){
            if (arr[i]== arr[n]||Math.abs(n-i)==Math.abs(arr[n]-arr[i]) ){
                return false;
            }
        }
        return true;
    }

    // 打印皇后的摆放
    private void print(){
        for (int a:arr) {
            System.out.print(a+"");
        }
        System.out.println();
    }
}
