package main.java.com.yll.list;

/**
 * 递归实现
 * @author：linlin.yang
 * @date：2018/3/23 16:29
 */
public class DeleteDuplicateSolution implements DeleteDuplicate {
    @Override
    public ListNode deleteDuplicate(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {
            ListNode p = head.next.next;
            while (p != null && p.val == head.val) {
                p = p.next;
            }

            return deleteDuplicate(p);
        }else{
            head.next = deleteDuplicate(head.next);
            return head;
        }
    }
}
