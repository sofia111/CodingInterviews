package com.sofia.Offer.List;

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
