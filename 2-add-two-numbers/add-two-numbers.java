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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode res = new ListNode();
        ListNode trav = res;
        Integer carry = null;

        while(p!=null || q!=null){
            int num1 = 0;
            int num2 = 0;
            int sum = 0;

            if(p!=null){
                num1+=p.val;
                p = p.next;
            }
            if(q!=null){
                num2+=q.val;
                q=q.next;
            }

            sum = num1+num2 ;
            if(carry!=null){
                sum+=carry;
                carry = null;
            }

            if(sum>9){
                carry = sum/10;
                sum = sum % 10;
            }
            trav.next = new ListNode(sum);
            trav = trav.next;
        }

        if(carry!=null){
            trav.next = new ListNode(carry);
        }

        return res.next;
    }
}