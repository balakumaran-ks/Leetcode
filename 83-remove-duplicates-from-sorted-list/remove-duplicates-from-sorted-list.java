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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int last = -1000;
        while(head!=null){
            if(head.val!=last){
                last = head.val;
                temp.next = head;
                head = head.next;
                temp = temp.next;
                temp.next=null;
            }else
            head = head.next;
        }
        return dummy.next;
    }
}