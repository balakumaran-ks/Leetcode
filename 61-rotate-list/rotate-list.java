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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0||head==null)return head;
        int len = 1;
        ListNode trav ;
        for(trav=head;trav!=null&&trav.next!=null;trav=trav.next,len++);
        if(k==len || len==1)return head;
        trav.next = head;
        if(k>len)k%=len;
        k=len-k;
        for(int i=0;i<k;i++)trav=trav.next;
        head = trav.next;
        trav.next=null;
        return head;
    }
}