package com.yzh.recursion;

import org.jetbrains.annotations.NotNull;

public class MiGong {
    public static void main(String[] args) {
        // 创建二维数组的迷宫
        int[][] map=new int[8][7];
        // 将上下 设置为1（代表墙）
        for (int i=0;i<7;i++){
            map[7][i]=1;
            map[0][i]=1;
        }
        // 将左右设置为1
        for (int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        // 设置挡板
        map[3][1]=1;
        map[3][2]=1;
        map[1][2]=1;
        map[2][1]=1;
        // 输出地图
        System.out.println("地图的情况");
        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[0].length;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("走完的迷宫 ");
        setWay(map,1,1);
        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[0].length;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static boolean setWay(int[] @NotNull [] map, int i, int j){
        if (map[6][5]==2){
            return true;
        }else {
            if (map[i][j]==0){
                // 如果当前这个点没走过  按照策略 下 右 上 左
                // =0 说明当前点 没有走过 ，
                map[i][j]=2;
                // 向下走
                if (setWay(map,i+1,j)){
                    return true;
                }else if (setWay(map,i,j+1)){
                    return true;
                }else if (setWay(map,i-1,j)){
                    return true;
                }else if (setWay(map,i,j-1)){
                    return true;
                }else {
                    // 上下左右都走不通，返回false
                    map[i][j]=3;
                    return false;
                }
            }else {
                // 如果 map【i】【j】!=0 ,说明当前的节点可能是 1 2 3
                return false;
            }
        }
    }
}
