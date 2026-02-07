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
    public ListNode sortList(ListNode head) {
        ListNode temp = head;
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while(temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }
        temp=head;
        Collections.sort(list);
        while(temp!=null){
            temp.val = list.get(i++);
            temp = temp.next;
        }
        return head;
    }
}