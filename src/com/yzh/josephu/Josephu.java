package com.yzh.josephu;

public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedlist list = new CircleSingleLinkedlist();
        list.add(5);
        list.shoBoy();
        list.conuntBoy(1,2,5);
    }
}


//创建 环线链表
class CircleSingleLinkedlist {
    // 创建 first节点
    private Boy first = new Boy(-1);

    // 添加节点
    public void add(int nums) {
        if (nums < 2) {
            System.out.printf("nums 的值 %d不对", nums);
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (first.getNo() == -1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
                System.out.println();
            }
        }
    }
//    删除节点


    public void conuntBoy(int starNo, int conuntNum, int nums) {
        //判断 数据正确性
        if(starNo<0||conuntNum<0||conuntNum>nums){
            System.out.println("数据错误 请重新填写");
            return;
        }
        Boy helpBoy=first;
        while (true){
            if (helpBoy.getNext()==first){
                break;
            }
            helpBoy=helpBoy.getNext();
        }


        while (true){
            if (helpBoy==first){
                break;
            }
            for (int i=0;i<conuntNum-1;i++){
                first=first.getNext();
                helpBoy=helpBoy.getNext();
            }
            System.out.printf("删除的是%d\n",first.getNo());
            first=first.getNext();
            helpBoy.setNext(first);
        }
        System.out.printf("列表最后是%d\n",first.getNo());
    }

    //    遍历环向链表
    public void shoBoy() {
        //判断 链表长度
        if (first.getNo() == -1) {
            System.out.println("链表是空的，无法遍历");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("链表的节点编号是: %d\n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
}

// 创建boylei
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                ", next=" + next.getNo() +
                '}';
    }
}