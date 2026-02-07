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
    public int pairSum(ListNode head) {
        int maxSum = 0;
        ListNode fast=head,slow=head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = null , curr = slow , next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode temp = head;

        while(prev!=null){
            int sum = temp.val+prev.val;
            if(sum>maxSum)maxSum=sum;
            temp = temp.next;
            prev = prev.next;
        }

        return maxSum;

    }
}