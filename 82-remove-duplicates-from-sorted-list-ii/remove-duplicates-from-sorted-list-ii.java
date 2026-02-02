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
        Map<Integer,Integer> map = new LinkedHashMap<>();
        ListNode temp = head;
        while(temp!=null){
            if(map.containsKey(temp.val)){
                map.put(temp.val,map.get(temp.val)+1);
            }else map.put(temp.val,1);
            temp = temp.next;
        }
        // System.out.println(map);
        ListNode res = new ListNode(0);
        // res.next = null;
        temp = res;
        while(head!=null){
            if(map.get(head.val)==1){
                temp.next = head;
                temp = temp.next;
            }
            head = head.next;
            temp.next = null;
        }
        return res.next;

    }
}