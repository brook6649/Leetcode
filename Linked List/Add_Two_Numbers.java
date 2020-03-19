/* public class ListNode {
*    int val;
*    ListNode next;
*    ListNode(int x) {
*        val = x;
*     }
* }
*/

class Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode initList = new ListNode(0);
        ListNode cursor = initList;
        int l1var,l2var,sum,carry = 0;
        while(l1 != null || l2 != null) {
            if(l1 != null){ l1var = l1.val; } else {l1var = 0;}
            if(l2 != null){ l2var = l2.val; } else {l2var = 0;}
            sum = l1var + l2var + carry;
            cursor.next = new ListNode(sum % 10);
            cursor = cursor.next;
            carry = sum / 10;
            if(l1 != null){l1 = l1.next;}
            if(l2 != null){l2 = l2.next;}
        }
        if (carry > 0){
            cursor.next = new ListNode(carry);
        }
        return initList.next;
    }
}