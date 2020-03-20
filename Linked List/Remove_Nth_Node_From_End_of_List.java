/** Problem Description
 Given a linked list, remove the n-th node from the end of list and return its head.

 Example:

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:

 Given n will always be valid.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            head = null;
            return head;
        }
        ListNode pointer1 = new ListNode();
        pointer1 = head;
        while(n>0){
            pointer1 = pointer1.next;
            if(pointer1 == null){
                return head.next;
            }
            n--;
        }
        ListNode pointer2 = new ListNode();
        pointer2 = head;
        while(pointer1.next != null){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        pointer2.next = pointer2.next.next;
        return head;
    }
}