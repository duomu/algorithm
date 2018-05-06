package main.java.com.yll.search;

/**
 * 平衡二叉树：AVL树是一棵空树，或者是具有下列性质的二叉树：
 * 它的左子树和右子树都是平衡二叉树，且左子树和右子树的深度之差的绝对值不超过1。
 */
public class BalancedBinaryTree {

    private class Node{
        private int value;
        private int bf;
        private Node left;
        private Node right;
        private int index;

        public Node(int value) {
            this.value = value;
        }
    }
}
