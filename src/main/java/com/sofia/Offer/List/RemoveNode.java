package com.sofia.Offer.List;
/**
*@Author: Sofia
*@Date: 2019/6/17 22:00
*@Description: 删除节点
*/
public class RemoveNode {

    public static void remove(ListNode head, int val){
        if (head == null){
            return;
        }
        ListNode Node = head;
        if (Node.next.value == val){
            Node.next = Node.next.next;
        }
    }
}
