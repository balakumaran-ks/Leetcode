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
        while(head!=null){
            if(map.containsKey(head.val)){
                map.put(head.val,map.get(head.val)+1);
            }else map.put(head.val,1);
            head = head.next;
        }
        ListNode res = new ListNode(0);
        ListNode temp = res;
        for(Map.Entry El:map.entrySet()){
            int key = (int)El.getKey();
            int value = (int)El.getValue();
            if(value==1){
                ListNode newNode = new ListNode(key);
                temp.next = newNode;
                temp = newNode;
            }
        }
        return res.next;

    }
}