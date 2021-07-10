package com.yzh.linkedlist;

import java.util.Stack;

class SingleLinkedListDemo {
    public static void main(String[] args) {
//        // 进行测试
//        // 先创建节点
//        HeroNode heroNode = new HeroNode(1, "宋江", "及时雨");
//        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
//        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
//        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
//
////        创建链表
//        SingleLinkedList singleLinkedList = new SingleLinkedList();
////        添加
////        singleLinkedList.add(heroNode1);
////        singleLinkedList.add(heroNode2);
////        singleLinkedList.add(heroNode3);
////        singleLinkedList.add(heroNode4);
////        singleLinkedList.list();
//        // 使用 排序添加方法添加
//        singleLinkedList.addByOrder(heroNode);
//        singleLinkedList.addByOrder(heroNode4);
//        singleLinkedList.addByOrder(heroNode3);
//        singleLinkedList.addByOrder(heroNode2);
//        singleLinkedList.addByOrder(heroNode3);
//        HeroNode heroNode6 = new HeroNode(9, "卢俊义111", "玉麒麟111");
//        singleLinkedList.update(heroNode6);
//        System.out.println("删除前");
//        singleLinkedList.list();
//        singleLinkedList.delete(1);
//        singleLinkedList.delete(4);
//        singleLinkedList.delete(4);
//        System.out.println("删除后\n");
//        singleLinkedList.list();
//        System.out.printf("节点的有效个数是%d\n",getLength(singleLinkedList.getHead()));
//
////        测试倒数第 k个元素
//        HeroNode res=findLastIndexNode(singleLinkedList.getHead(),3);
//        System.out.println("res="+res);
        HeroNode heroNode = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        // 创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 添加
        singleLinkedList.add(heroNode);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);
        System.out.println("发转前的 链表");
        singleLinkedList.list();
        System.out.println("反转后的 链表");
        reversePrinet(singleLinkedList.getHead());
        singleLinkedList.list();
    }

    /*
        将单链表进行逆序打印
        1. 先将单链表进行 发转，反转后 打印，（不建议，因为回改变 链表的结构）
        2. 使用栈数据结构，将节点取出，然后利用 栈的新进后出特点 进行打印
     */
    public static void reversePrinet(HeroNode head){
        if (head.next==null) return;

        // 创建栈 ，将链表节点 放入栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur =head.next;
        while (cur !=null){
            stack.push(cur);
            cur=cur.next;
        }
        // 遍历栈 打印节点
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
    /*
        将单链表进行反转，
        1.
     */
    public static void reversetList(HeroNode head) {
       // 当前链表如果只有 头节点 或者只有一个有效节点不需要 发转
        if (head.next==null||head.next.next==null) return;

        HeroNode cur=head.next;
        HeroNode next=null;
        HeroNode reverseHead= new HeroNode(0,"","");
        while (cur != null){
            next = cur.next;
            cur.next=reverseHead.next;
            reverseHead.next=cur;
            cur=next;


        }
        head.next=reverseHead.next;

        }



    // 查找单链表的 倒数第k个节点 ( 新浪面试题）
/*
    1. 获取链表的有效节点个数
    2. 得到 size 后用size - k 就可以得到
    找到 的话 返回，否则返回null
 */
    public static HeroNode findLastIndexNode(HeroNode heroNode, int index) {
        // 拍段列表是否为空
        if (heroNode.next == null) {
            return null;
        }
        int size = getLength(heroNode);
        if (index < 0 || index > size) {
            return null;
        }
        // 定义辅组遍历
        HeroNode cur = heroNode.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //    获取单链表的节点个数  不统计头节点
    public static int getLength(HeroNode heroNode) {
        if (heroNode == null) {
            return 0;
        }
        int count = 1;
        HeroNode temp = heroNode.next;
        while (true) {
            if (temp.next == null) {
                break;
            }
            count++;
            temp = temp.next;
        }
        return count;
    }

}


// 定义SingleLinkedList
class SingleLinkedList {
    //    先初始化头节点，头节点不能动
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //    添加节点到 单向列表
    public void add(HeroNode heroNode) {
//        思路：当不考虑编号的顺序时，
//        1.找到当前链表的最后节点
//        2.将最后的next 指向 新的节点
//        head节点不能动，因此我们需要一个辅助遍历
        HeroNode temp = head;
        while (true) {
//            当temp == null 表示找到列表的最后了
            if (temp.next == null) {
                break;
            }
//            如果没有找到最后，将temp后移
            temp = temp.next;
        }
//        当退出循环时，temp 就指向了链表的最后
        temp.next = heroNode;

    }

    /*
    第二种方式添加节点，根据no将英雄插入指定的节点

     */
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍通过遍历 通过一个辅组遍历 帮助我们找到添加的位置
        // 因为单链表，因为我们找的temp 是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;//表示 添加的编号是否存在，默认为不存在
        while (true) {
            if (temp.next == null) {
                // 说明temp 已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {
                // 位置找到了 tmep 的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {
                // 说明添加的 编号已经存在了
                flag = true;
                break;
            }
            temp = temp.next;// 后移，遍历当前链表

        }
        //判断flag的值
        if (flag) {
            //说明编号已经存在，
            System.out.printf("准备插入的数据编号%d已经存在了\n", heroNode.no);
        } else {
            //插入到链表中。tmep后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //    修改节点
    public void update(HeroNode heroNode) {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表是空的");
            return;
        }

        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;

        }

        if (flag) {
            temp.next.name = heroNode.name;
            temp.next.nickName = heroNode.nickName;
        } else {
            System.out.printf("没有找到编号为%d的数据\n", heroNode.no);
        }


    }

    // 删除链表数据
    public void delete(int no) {
        if (head == null) {
            System.out.println("链表是空的");
            return;
        }
        // 定义temp临时遍历
        HeroNode temp = head;
        // 定义 flag
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;

        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("没有找到%d的节点", no);
        }


    }

    //显示链表
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此需要一个辅助变量 遍历
        HeroNode temp = head.next;
        while (true) {
            // 判断是否到链表的最后
            if (temp == null) {
                break;
            }
            // 输出节点的信息
            System.out.println(temp);
            // 将temp 后移，
            temp = temp.next;

        }
    }


}

// 定义 Hernode ，每个node是一个节点
class HeroNode {

    public int no;
    public String name;
    public String nickName;
    public HeroNode next;


    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}