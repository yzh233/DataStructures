package com.yzh.linkedlist;


public class DoubleLinkedListDemo {
    public static void main(String[] args) {
    //
        System.out.println("双向链表的测试");

        HeroNode2 heroNode = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4, "林冲", "豹子头");
        DoubleLinkedList list=new DoubleLinkedList();
        list.addByOrder(heroNode4);
        list.addByOrder(heroNode3);
        list.addByOrder(heroNode2);
        list.addByOrder(heroNode);
        list.list();
//        //   修改
//        HeroNode2 heroNode5 = new HeroNode2(4, "林冲123", "豹子头123");
//        list.update(heroNode5);
//        System.out.println("修改");
//        list.list();
//        //删除
//        list.del(3);
//        System.out.println("删除后");
//        list.list();
    }
}

// 创建双向链表
class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    //    添加节点到 双向链表
    public void add(HeroNode2 heroNode) {

        HeroNode2 temp = head;
        while (true) {

            if (temp.next == null) {
                break;
            }

            temp = temp.next;
        }

        temp.next = heroNode;
        heroNode.pre = temp;

    }

    public void addByOrder(HeroNode2 heroNode) {
        //因为头节点不能动，因此我们仍通过遍历 通过一个辅组遍历 帮助我们找到添加的位置
        // 因为单链表，因为我们找的temp 是位于添加位置的前一个节点，否则插入不了
        HeroNode2 temp = head;
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
            return;
        }

        if(temp.next!=null){
            //插入到链表中。tmep后面
            temp.next.pre=heroNode;
            heroNode.pre=temp;
            heroNode.next=temp.next;
            temp.next=heroNode;
        }else {
            temp.next=heroNode;
            heroNode.pre=temp;
        }
    }

    //    删除
    public void del(int no) {
        if (head.next == null) {
            System.out.println(" 链表是空的，不可以删除");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }

    }

    //    修改节点
    public void update(HeroNode2 heroNode) {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表是空的");
            return;
        }

        HeroNode2 temp = head;
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

    //  遍历双向链表
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此需要一个辅助变量 遍历
        HeroNode2 temp = head.next;
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

// 创建 链表类
class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int id, String name, String nickName) {
        this.no = id;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }


}
