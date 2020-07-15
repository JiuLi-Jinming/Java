package list;

public class list
{
     // Definition for singly-linked list.
     public class ListNode
     {
          int val;
          ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2)
        {
            ListNode temp = new ListNode(0);
            ListNode cur = temp;

            while (l1 != null || l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    cur = cur.next;
                    l1 = l1.next;
                } else if (l2.val < l1.val) {
                    cur.next = l2;
                    cur = cur.next;
                    l2 = l2.next;
                }
            }

            if (l1 == null) {
                temp.next = l2;
            } else if (l2 == null) {
                temp.next = l1;
            }
            return temp;
        }
}
