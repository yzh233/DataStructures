package com.hzy;

/**
 * @ClassName AddTowNumbers
 * @Description TODO
 * @Author yzh
 * @Date 2021/4/20 22:28
 * @Version 1.0
 */
public class AddTowNumbers {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        ListNode l1 = new ListNode(2);
//        l1.next
//
//        ListNode listNode = solution.addTwoNumbers(list1, list2);
//        System.out.println(listNode.val);

        // aaaaaaaaaaaaaaaaaaaaaaaaaaaa

    }


}




class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root=new ListNode(0),pre=root;
        int carry=0;
        while (l1 != null||l2!=null||carry!=0){
            if (l1 !=null){
                carry+=l1.val;
                l1=l1.next;
            }
            if (l2!=null){
                carry+=l2.val;
                l2=l2.next;
            }
            pre.next=new ListNode(carry%10);
            pre=pre.next;
            carry/=10;
        }
        return root.next;
    }


}