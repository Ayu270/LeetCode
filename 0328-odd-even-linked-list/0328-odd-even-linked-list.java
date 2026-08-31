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
    public ListNode oddEvenList(ListNode head) {
        ArrayList <Integer> o = new ArrayList<>();
        ArrayList <Integer> e = new ArrayList<>();
        ListNode head1= head;
        ListNode head2= head;
        boolean f = true;
        while(head!=null){
            if(f==true){
              o.add(head.val);
              f=false;
            } else {
              e.add(head.val);
              f=true;
            }
            head=head.next;
        }
        int so = o.size();
        int se = e.size();
        int co =0;
        int ce=0;
        for(int i=0; i<so+se; i++){
            if(co<so){
                head1.val=o.get(co);
                co++;
            } else {
                head1.val=e.get(ce);
                ce++;
            }
            if(i<so+se)
              head1=head1.next;
        }      
        return head2;
    }
}