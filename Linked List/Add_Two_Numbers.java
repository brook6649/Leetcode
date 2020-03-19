// Problem Description
/* You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/


/* public class ListNode {
*    int val;
*    ListNode next;
*    ListNode(int x) {
*        val = x;
*     }
* }
*/

class Add_Two_Numbers {
/** 从个位数(链表的头部节点)开始，每位做加法，把加和后这一位的结果(整数)保存在新建的节点内，carry [0 | 1] 为进位项.
    循环体后多了条判断，为了应对诸如 1 + 99 = 100 这种位数增加的情况.
*/
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
