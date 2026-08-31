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
    public int numComponents(ListNode head, int[] nums) {
        HashSet <Integer> n = new HashSet<>();
        for (int num : nums) {
           n.add(num); 
        }
        int c = 0;
        while(head!=null){
            if (n.contains(head.val) &&
                (head.next == null || !n.contains(head.next.val))) {
                c++;
            }
            head = head.next;
        }
        return c;
    }
}