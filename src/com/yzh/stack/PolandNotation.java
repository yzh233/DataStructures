package com.yzh.stack;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * @ClassName PolandNotation
 * @Description TODO
 * @Author yzh
 * @Date 2021/4/19 21:55
 * @Version 1.0
 */
public class PolandNotation {
    public static void main(String[] args) {
        //1. 将中缀表达式转为 list，因为list处理比字符串要好
        String expression = "11+((2+3)*4)-5";//注意表达式
        List<String>list1=toInfixExpressionList(expression);
        System.out.println(list1);

//        List<String> list2 = parseSuffixExpreesionList(list1);
//        System.out.println("String{}"+String.join(" ",list2));
//        // 定义 逆波兰 表达式
//        String suffixExpression=String.join(" ",list2); //"3 4 + 5 * 6 -";
//        List<String> list = getListString(suffixExpression);
//        System.out.println(list);
//        int res=calculate(list);
//        System.out.println(res);

    }


    // 2.将中缀表达式的list 转为 后缀表达式
    //即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]  =》 ArrayList [1,2,3,+,4,*,+,5,–]
    //方法：将得到的中缀表达式对应的List => 后缀表达式对应的List
    public static List<String> parseSuffixExpreesionList(List<String> ls){
        //定义 运算符栈
        Stack<String> s1=new Stack<String>();
        // 定义 list 存放最后结果
        List<String > s2=new ArrayList<String>();
        for (String item:ls){
            // 如果是数字 直接放入 list
            if (item.matches("\\d+")){
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                // 弹出所有 非 （ 的运算符
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                // 删除 ( ,不存储 ) 从而将一对括号消除
                s1.pop();
            }else {
                // 其他运算符，加减乘除 判断优先级
                 while (s1.size()!=0 && Operation.getOpreation(s1.peek())>=Operation.getOpreation(item)){
                     s2.add(s1.pop());
                 }
                 s1.push(item);
            }


        }
        //将栈内剩余的运算符 放入s2
        while (s1.size()!=0){
            s2.add(s1.pop());
        }

        return s2;



    }

    public static List<String>toInfixExpressionList(String str){
        List<String>list=new ArrayList<String>();
        char[] chars=str.toCharArray();
        String s="";
        for (int i=0;i<chars.length;i++){
            if (chars[i]>=47 &&chars[i]<=57){
                s+=chars[i];
            }else {
                if (s==""){
                    list.add(chars[i]+"");
                }else {
                    list.add(s);
                    s="";
                    list.add(chars[i]+"");
                }
            }
        }
        list.add(s);
        return list;
    }

    public static List<String> getListString(String str){
        String []strs=str.split(" ");
        List<String> list=new ArrayList<String>();
        for (String els:strs) {
            list.add(els);

        }
        return list;
    }
    public static int calculate(List<String> list){
        Stack<String> stack=new Stack<String>();

        for (String str:list){
            if (str.matches("\\d+")){
                stack.push(str);
            }else {
                int num2=Integer.parseInt(stack.pop());
                int num1=Integer.parseInt(stack.pop());
                int res=0;
                if (str.equals("*")){
                    res=num1*num2;
                }else if (str.equals("/")){
                    res=num1/num2;
                }else if (str.equals("+")){
                    res=num1+num2;
                }else if (str.equals("-")){
                    res=num1-num2;
                }else {
                    throw new RuntimeException("符号不对");
                }
                stack.push(res+"");
            }

        }
        return Integer.parseInt(stack.pop());
    }

}


class Operation{
    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=1;
    private static int DIV=1;
    public static int getOpreation(String operation){
        int result=0;
        switch (operation){
            case "+":
                result=ADD;
                break;
            case "-":
                result=SUB;
                break;
            case "*":
                result=MUL;
                break;
            case "/":
                result=DIV;
                break;
            default:
                System.out.printf("不存在该字符%s\n", operation);
               break;

        }
        return result;
    }
}