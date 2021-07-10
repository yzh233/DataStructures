package com.hzy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DemoTest
 * @Description TODO
 * @Author yzh
 * @Date 2021/4/21 22:23
 * @Version 1.0
 */
public class DemoTest {

    public static void main(String[] args) {
        String str="1+((2+3)*4)–5123";
        List<String>list=stringToList(str);
        System.out.println(list);

    }

    public static List<String> stringToList(String str){
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
}
