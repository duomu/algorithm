package main.java.com.yll.list;

/**
 * 递归实现，无法处理1,1,1,1,1的情况
 * @author：linlin.yang
 * @date：2018/3/23 16:30
 */
public class DeleteDuplicateSolution2 implements DeleteDuplicate {
    @Override
    public ListNode deleteDuplicate(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode subHead = deleteDuplicate(head.next);
        System.out.println("head：" + head.val);
        System.out.print("subHead：");
        ListNode.print(subHead);
        if (subHead == null || subHead.val != head.val) {
            head.next = subHead;//subHead=null时，并不能保证head不是重复结点
        } else {
            head = subHead.next;
        }

//        ListNode.print(head);

        return head;
    }
}
