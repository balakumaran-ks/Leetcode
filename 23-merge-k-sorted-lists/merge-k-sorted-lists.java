/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class LL{
    ListNode head;
    ListNode tail;
    LL(){
        head=tail=null;
    }

    void add(ListNode node){
        if(head==null){
            head=node;
            tail=node;
            head.next = head;
            return;
        }

        //smallest & largest
        if(node.val<=head.val||node.val>=tail.val){
            tail.next = node;
            node.next = head;
            if(node.val<=head.val)
            head = node;
            else
            tail = node;
            return;
        }

        ListNode trav = head;
        while(trav.next.val<node.val){
            trav = trav.next;
        }

        node.next = trav.next;
        trav.next = node;
    }

    ListNode getHead(){
        if(tail!=null)
        tail.next = null;
        return head;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        LL list = new LL();
        for(int i=0;i<lists.length;i++){
            ListNode trav = lists[i];
            ListNode next = null;
            while(trav!=null){
                next = trav.next;
                trav.next = null;
                list.add(trav);
                trav = next;
            }
        }
        return list.getHead();
    }
}