package com.yzh.sparseArray;

public class sparseArray {
    public static void main(String[] args) {
//        定义一个二维数组
        int chessArray[][]=new int[11][11];
        chessArray[1][2]=1;
        chessArray[3][4]=4;
        chessArray[5][6]=7;
        chessArray[7][8]=9;
        for (int row[]:chessArray) {
            for (int data:row) {
                System.out.printf("%d\t",data);
            }            System.out.println();
        }
//        获取数组中的值的个数
        int sum=0;
        for (int i=0;i<chessArray.length;i++){
            for(int j=0;j<chessArray[i].length;j++){
                if(chessArray[i][j]!=0){
                    sum++;
                }
            }
        }
//        根据值的个数创建稀疏数组
        int sparseArray[][]=new int[sum+1][3];
        sparseArray[0][0]=chessArray.length;
        sparseArray[0][1]=chessArray[0].length;
        sparseArray[0][2]=sum;
        int count=0;
        for (int i=0;i<chessArray.length;i++){
            for(int j=0;j<chessArray[i].length;j++){
                if(chessArray[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=chessArray[i][j];
                }
            }
        }
        //打印稀疏数组
        for (int i=0;i<sparseArray.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }
        System.out.println();
//        将稀疏数组转为二维数组
    }
}
