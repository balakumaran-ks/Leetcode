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
    public ListNode insertionSortList(ListNode head) {
        ListNode sorted =null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            sorted = sortedIndex(sorted,curr);
            curr = temp;
        }
        return sorted;
    }

    public static ListNode sortedIndex(ListNode sorted,ListNode newNode){
        if(sorted==null || newNode.val<sorted.val){
            newNode.next = sorted;
            return newNode;
        }else{
            ListNode curr = sorted;
            while(curr.next!=null && curr.next.val<newNode.val)curr=curr.next;
            newNode.next = curr.next;
            curr.next = newNode;
            return sorted;
        }
    }
}