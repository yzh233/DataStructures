package com.yzh.queque;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //测试队列
        //创建队列
        CircleArray arrayQueque = new CircleArray(4);
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
                    arrayQueque.showQueue();
                    break;
                case 'h':
                    int h =arrayQueque.headQueue();
                    System.out.println("队列的头数据是："+h);
                    break;
                case 'a':
                    System.out.println("输入一个数据");
                    int value=scanner.nextInt();
                    arrayQueque.addQueue(value);
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

class CircleArray{

    private  int maxXize;
    private  int front;
    private  int rear;
    private  int [] arr;

    public CircleArray(int arrMaxsize){
        maxXize=arrMaxsize;
        arr=new int[maxXize];

    }
// 判断队列是否满
    public boolean isFull(){
        return (rear+1)% maxXize==front;
    }
// 判断队列是否为空
    public  boolean isEmpty(){
        return rear == front;
    }
//    添加数据到队列
    public void addQueue(int n){
//        判断队列是否满
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        // rear 当前的位置是空的，直接赋值即可
        arr[rear]=n;
        // 赋值完成后rear 应该向后移动一位，防止数组越界，需要取模
        rear=(rear+1)% maxXize;
    }
    //    出队列
    public int getQueque(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int value =arr[front];
        front=(front+1)% maxXize;
        return value;
    }
//    显示所有数据
    public  void  showQueue(){
        if(isEmpty()){
            System.out.println("数组是空的");
            return;
        }
        for (int i=front;i<front+getSize();i++){
            System.out.printf("arr[%d]=%d\n",i%maxXize,arr[i%maxXize]);
        }
    }
//    获取当前队列的有效个数，用于显示的循环次数
    public int getSize(){
        return (rear+maxXize-front)%maxXize;
    }
// 显示队列的头数据，
    public int headQueue(){
        if(isEmpty()){
            System.out.println("队列是空的，取不出头数据");
        }
        return arr[front];
    }
}