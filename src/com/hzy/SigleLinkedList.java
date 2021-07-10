package com.hzy;


class SigleLinkedListDemo {


    public static void main(String[] args) {
        HeroNode heroNode = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode heroNode5 = new HeroNode(4, "林1冲", "豹1子头");
        SigleLinkedList list = new SigleLinkedList();
        list.addByOder(heroNode);
        list.addByOder(heroNode2);
        list.addByOder(heroNode4);
        list.addByOder(heroNode3);
        list.addByOder(heroNode5);
        list.list();
        System.out.println(size(list.getHead()));
        System.out.println(getN(list.getHead(),2));
//        list.delete(1);
//        System.out.println("删除后");
//        list.list();

    }
//    获取倒数第 n个元素
    public static HeroNode getN( HeroNode head,int k){
        if (head.next==null){
            System.out.println("kong ");
            return null;
        }

        int index=size(head);
        if (index>0||k>index){
            return null;
        }

        HeroNode temp=head.next;
        for (int i=0;i<index-k;i++){
            temp=temp.next;
        }
        return temp;


    }

//    获取 链表的有效个数
    public static int size(HeroNode head){
        System.out.println("public static int size(HeroNode head){");
        if (head.next==null){
            System.out.println("链表是空的");
            return 0;
        }
        int count=0;
        HeroNode temp=head.next;
        while (temp.next!=null){
            temp=temp.next;
            count++;

        }
        return count;
    }


}


public class SigleLinkedList {

    HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //    添加
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
    }
//    根据排序添加
    public void addByOder(HeroNode heroNode){
//        if (head.next==null){
//            System.out.println("链表是空的");
//            return;
//        }

        HeroNode temp=head;
        boolean flag=false;
        while (true){
            if (temp.next==null||temp.next.id>heroNode.id){
                break;
            }
            if (temp.next.id==heroNode.id){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            System.out.println("编号重复了");
            return;
        }else {
            heroNode.next=temp.next;
            temp.next=heroNode;
        }


    }

    //    修改
    public void update(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("链表是空的");
            return;
        }
        HeroNode temp = head;
        while (temp.next != null && temp.next.id != heroNode.id) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("没有找到");
        } else {
            temp.next.name = heroNode.name;
            temp.next.nickName = heroNode.nickName;
        }

    }

    //    删除
    public void delete(int num) {
        if (head.next == null) {
            System.out.println("链表是空的");
            return;
        }
        HeroNode temp = head;
        while (temp.next != null && temp.next.id != num) {
            temp=temp.next;
        }
        if (temp.next==null){
            System.out.println("没有找到要删除的num"+num);
        }else {
            temp.next=temp.next.next;
        }
    }

//    显示

    public void list() {
        if (head.next == null) {
            System.out.println("链表是空的，不需要打印");
            return;
        }
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            System.out.println(temp.next);
            temp = temp.next;
        }
    }


}


class HeroNode {
    public int id;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}