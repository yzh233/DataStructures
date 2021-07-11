package com.yzh.stack;

/**
 * @ClassName Calculator
 * @Description TODO
 * @Author yzh
 * @Date 2021/4/13 22:50
 * @Version 1.0
 */
public class Calculator {
    public static void main(String[] args) {
        String expression ="7+2*6-4";
//         创建两个，数栈，一个符号栈
        ArrayStack2 numStack=new ArrayStack2(10);
        ArrayStack2 operStack=new ArrayStack2(10);
        // 定义需要的变量  github 修改代码
        int index=0;
        int num1=0;
        int num2=0;
        int oper=0;
        int res=0;
        char ch=' ';
        while (true){
            ch=expression.substring(index,index+1).charAt(0);
            if (operStack.isOper(ch)) {
                //是符号 判断 operStack 是否为空
                if (!operStack.isEmpty()){
                    //不为空，对比 字符栈的第一个，
                    if (operStack.priority(ch)<=operStack.priority(operStack.peek())){
                        num1=numStack.pop();
                        num2=numStack.pop();
                        oper=operStack.pop();
                        res=operStack.cal(num1,num2,oper);
                        numStack.push(res);
                        // 先将 栈顶的运算符进行计算，然后让如新的运算符到栈顶
                        operStack.push(ch);
                    }else {
                        // 大于直接放入
                        operStack.push(ch);
                    }
                }else {
                    // 为空，直接放入
                    operStack.push(ch);
                }
            }else {
                //不是符号，放入 数字栈
                numStack.push(ch-48);  //减去48 ascll 码的值
            }
            index++;
            if (index>=expression.length()){
                break;
            }
            }

        System.out.printf("numStack\n");
        numStack.list();
        System.out.println("operStack\n");
        operStack.list();
     while (true){
         if (operStack.isEmpty()){
             break;
         }
         num1=numStack.pop();
         num2=numStack.pop();
         oper=operStack.pop();
         res=operStack.cal(num1,num2,oper);
         numStack.push(res);
     }
        System.out.println("最后一位树");
     numStack.list();
    }

}


class ArrayStack2{
    private int maxSize;
    private int[] stack;
    private int top=-1;

    //构造器


    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack=new int [maxSize];
    }
    // ----------扩展功能 返回运算符的优先级，优先级使用数字表示

    public int priority(int oper){
        if(oper=='*'||oper=='/'){
            return 1;
        }else if (oper=='+'||oper=='-'){
            return 0;
        }else {
            return -1;
        }
    }

    //判断 符号是否正确
    public boolean isOper(int oper){
        return oper=='*'||oper=='/'||oper=='+'||oper=='-';
    }

    // 返回栈顶的值，单是不是真正的pop
    public int peek(){
        return stack[top];
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
        if(isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
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
    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0; // res 用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;// 注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
