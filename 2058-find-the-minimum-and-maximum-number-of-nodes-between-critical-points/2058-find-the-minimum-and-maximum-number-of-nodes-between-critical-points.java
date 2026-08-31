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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next.next == null)
           return new int []{-1,-1};
        ArrayList <Integer> n = new ArrayList<>();
        int c=1;
        int pre = head.val;
        head=head.next;
        while(head.next != null){
            c++;
            int next = head.next.val;
            if(head.val < next && head.val < pre){
                n.add(c);
            }
            if(head.val> next && head.val> pre){
                n.add(c);
            }
            pre=head.val;
            head=head.next;
        }
        int s = n.size();
        if (s < 2)
            return new int[]{-1, -1};
        int max = n.get(s-1)-n.get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n.size(); i++) {
            min = Math.min(min, n.get(i) - n.get(i - 1));
        }
        return new int[]{min,max};
    }
}