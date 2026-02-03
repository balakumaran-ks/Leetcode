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
        ListNode sorted = null;
        ListNode current= head;

        while(current!=null){
            ListNode next = current.next;
            sorted = sortedIndex(sorted,current);
            current = next;
        }

        return sorted;
    }

    public static ListNode sortedIndex(ListNode sorted,ListNode newNode){
        if (sorted == null || sorted.val >= newNode.val) {
            newNode.next = sorted;
            return newNode;
        } else {
            ListNode current = sorted;
            while (current.next != null && current.next.val < newNode.val) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            return sorted;
        }
    }
}