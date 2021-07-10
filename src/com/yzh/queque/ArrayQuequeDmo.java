package com.yzh.queque;

import java.util.Scanner;

public class ArrayQuequeDmo {
    public static void main(String[] args) {
        //测试队列
        //创建队列
        ArrayQueque arrayQueque = new ArrayQueque(3);
        char key=' ';
        boolean loop=true;
        Scanner scanner=new Scanner(System.in);
        //输出菜单
        while (loop){
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出队列");
            System.out.println("a(add)：添加数据");
            System.out.println("g(get)：获取队列数据");
            System.out.println("h(head)：获取队列的头数据");
            key=scanner.next().charAt(0);//接受一个字符
            switch (key){
                case 's':
                    arrayQueque.showQueque();
                    break;
                    case 'h':
                    int h =arrayQueque.headQueque();
                        System.out.println("队列的头数据是："+h);
                    break;
                case 'a':
                    System.out.println("输入一个数据");
                    int value=scanner.nextInt();
                    arrayQueque.addQueque(value);
                    break;
                case 'g':
                    try {
                        int res =arrayQueque.getQueque();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
            }
        }

    }

}




class ArrayQueque{
    private int maxSize;// 表示数组的最大容量
    private int front; //队列头
    private int rear;//队列的尾部
    private int []arr;//用于存放数据

    public ArrayQueque(int maxSize) {
        this.maxSize = maxSize;
        arr=new int[maxSize];
        front=-1; //指向队列的头部， 分析出front是指向队列的前一个位置
        rear=-1;// 执行队列尾部，指向队列尾部的数据（包含队列的最后一个数据）

    }

//    判断队列是否满
    public boolean isFull(){
        return rear==maxSize-1;
    }
//    判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
//     添加数据
    public void addQueque(int n){
        if(isFull()){
            System.out.println("队列已满");
        }
        rear++;// rear 后移
        arr[rear]=n;
    }
//    出队列
    public int getQueque(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }
//    显示所有数据
    public void  showQueque(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    public int headQueque(){
        if (isEmpty()){
            throw  new RuntimeException("队列是空的");
        }
        return arr[front+1];
    }
}