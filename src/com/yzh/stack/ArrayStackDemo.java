package com.yzh.stack;

/**
 * @ClassName ArrayStackDemo
 * @Description TODO
 * @Author yzh
 * @Date 2021/4/12 23:51
 * @Version 1.0
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack=new ArrayStack(5);


    }
}

class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top=-1;

    //构造器


    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
    }

    // 栈满
    public boolean isFull(){
        return top==maxSize-1;
    }

    // 栈空
    public boolean isEmpty(){
        return top==-1;
    }

    // 入栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈已满");
            return;
        }
        stack[++top]=value;
    }
    //出栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空，没有数据");
        }
        int value=stack[top];
        top--;
        return value;
    }
    // 遍历
    public void  list(){
        if(isEmpty()){
            System.out.println("栈为空");
            return;
        }
        // 从栈顶显示数据
        for (int i=top;i>=0;i--){
            System.out.printf("数组【%d】=%d\n",i,stack[i]);
        }
    }
}
