package main.java.com.yll.search;

/**
 * 二叉排序树：是一棵空树，或者是有具有下列性质的树：若左子树不空，则左子树上的所有结点都小于根结点的值；
 * 若右子树不空，则右子树上的所有结点都大于根节点的值；它的左右子树也分别是二叉排序树。
 * <p>
 * 二叉排序树是一种动态树表，树的结构是在查找的过程动态生成的，当树中不存在给定值的结点时再进行插入，新插入的结点一定是
 * 一个新添加的叶子结点，并且一定是查找不成功时查找路径上访问的最后一个结点的左孩子或右孩子。
 */
public class BinarySortTree{
    private Node root;

    private int size;

    /**
     * 查找二叉排序树中是否有key值
     * @param key
     * @return
     */
    public int searchBST(int key) {
        Node currNode = root;
        while (currNode != null) {
            if (key < currNode.value) {
                currNode = currNode.left;
            } else if (key > currNode.value) {
                currNode = currNode.right;
            } else if (currNode.value == key) {
                return currNode.index;
            }
        }

        return -1;
    }

    /**
     * 向二叉排序树中插入结点key，若不存在则插入，否则不插入。
     *
     * @param key
     */
    public void insertBST(int key) {
        //寻找插入位置
        Node p = root;
        Node pre = null;
        while (p != null) {
            pre = p;
            if (key < p.value) {//小于根节点，则继续查找左子树
                p = p.left;
            } else if (key > p.value) {//大于根结点，则继续查找右子树
                p = p.right;
            } else {//等于根结点，已存在，中止查找
                break;
            }
        }

        Node newNode = new Node(key, size);
        if (pre == null) {//二叉树为空
            root = newNode;
        } else if (key < pre.value) {//小于根节点，则插入到左子树上
            pre.left = newNode;
        } else if (key > pre.value) {//大于根结点，则插入到右子树上
            pre.right = newNode;
        }

        size++;

    }

    /**
     * 向二叉排序树中插入结点key，若不存在则插入，否则不插入。
     *
     * @param key
     */
    public void insertBST(int key, int index) {
        //寻找插入位置
        Node p = root;
        Node pre = null;
        while (p != null) {
            pre = p;
            if (key < p.value) {//小于根节点，则继续查找左子树
                p = p.left;
            } else if (key > p.value) {//大于根结点，则继续查找右子树
                p = p.right;
            } else {//等于根结点，已存在，中止查找
                return;
            }
        }

        Node newNode = new Node(key, size);
        if (pre == null) {//二叉树为空
            p = newNode;
        } else if (key < pre.value) {//小于根节点，则插入到左子树上
            pre.left = newNode;
        } else if (key > pre.value) {//大于根结点，则插入到右子树上
            pre.right = newNode;
        }

        size++;
    }

    private class Node {
        private int value;
        private Node left;
        private Node right;
        private int index;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public Node(int val, Node left, Node right) {
            this.value = val;
            this.left = left;
            this.right = right;
        }
    }
}
