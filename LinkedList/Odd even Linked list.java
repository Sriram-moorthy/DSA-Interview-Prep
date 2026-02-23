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
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);

        ListNode oddHead = odd , evenHead = even;
        int index = 1;
        while(head != null){
            if(index % 2 != 0){
                oddHead.next = head;
                oddHead = oddHead.next;
            }
            else{
                evenHead.next = head;
                evenHead = evenHead.next;
            }
            head = head.next;
            index++;
        }
        evenHead.next = null;
        oddHead.next = even.next;
        return odd.next;
    }
}
