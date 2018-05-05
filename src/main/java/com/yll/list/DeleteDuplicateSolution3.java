package main.java.com.yll.list;

/**
 * 循环实现，将不重复的结点逐个插入到新链表中
 * @author：linlin.yang
 * @date：2018/3/23 16:33
 */
public class DeleteDuplicateSolution3 implements DeleteDuplicate{

    @Override
    public ListNode deleteDuplicate(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        ListNode newTail = null;
        ListNode curr = head;
        while (curr != null) {
            if (curr.next == null) {
                if (newHead == null) {
                    newHead = curr;
                    newTail = curr;
                } else {
                    newTail.next = curr;
                }
                break;
            }

            if (curr.next.val == curr.val) {
                ListNode post = curr.next.next;
                while (post != null && post.val == curr.val) {
                    post = post.next;
                }
                curr = post;
            }else{
                if (newHead == null) {
                    newHead = curr;
                }else{
                    newTail.next = curr;
                }
                newTail = curr;
                curr = curr.next;
                newTail.next = null;
            }
        }

        return newHead;
    }
}
