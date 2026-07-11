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
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)return head;

        ListNode temp = head.next.next;
        ListNode proc = head;
        ListNode prev = null;
        head = head.next;
        head.next = proc;
        proc.next = temp;
        prev = proc;
        proc = temp;
        while(proc != null && proc.next!=null){
            temp = proc.next.next;
            prev.next = proc.next;
            prev = prev.next;
            prev.next = proc;
            proc.next = temp;
            prev = prev.next;
            proc = temp;
        }

        return head;
    }
}