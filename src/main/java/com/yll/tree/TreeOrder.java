package main.java.com.yll.tree;

import sun.plugin.WJcovUtil;

import java.util.*;

/**
 * @author：linlin.yang
 * @date：2018/5/13 12:25
 */
public class TreeOrder {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        TreeNode root1 = buildTree(a);
        TreeNode root2 = buildTree2(a);
        System.out.println("buildTree==buildTree2：" + equals(root1, root2));

        System.out.println("preOrder-----------------------");
        //先序遍历：根左右
        List<Integer> preOrders = Arrays.asList(1, 2, 4, 5, 3, 6);
        System.out.println("recursive------------");
        preOrder(root1);
        System.out.println("not recursive-----------------");
        preOrderNotRecursive(root1);
        testPreOrderResult(preOrders, root1);

        System.out.println("inOrder-----------------------");
        //中序遍历：左根右
        List<Integer> inOrders = Arrays.asList(4, 2, 5, 1, 6, 3);
        System.out.println("recursive------------");
        inOrder(root1);
        System.out.println("not recursive-----------------");
        inOrderNotRecursive(root1);

        System.out.println("postOrder-----------------------");
        //后序遍历：左右根
        List<Integer> postOrders = Arrays.asList(4, 5, 2, 6, 3, 1);
        System.out.println("recursive------------");
        postOrder(root1);
        System.out.println("not recursive-----------------");
        postOrderNotRecursive(root1);


        System.out.println("levelOrder-----------------------");
        //层次遍历：自上而下，自左至右
        List<Integer> levelOrders = Arrays.asList(1, 2, 3, 4, 5, 6);//和构建完全二叉树的次序一样
        levelOrder(root1);
    }

    /**
     * 先序遍历——递归实现
     * @param root
     */
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        visit(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 先序遍历——非递归实现
     * @param root
     */
    public static void preOrderNotRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);//根结点先入栈，出栈时访问，若有右孩子则右孩子先进栈，左孩子后进栈。
        while (!stack.empty()) {
            TreeNode p = stack.pop();
            visit(p);

            if (p.right != null) {//先进后出
                stack.push(p.right);
            }

            if (p.left != null) {
                stack.push(p.left);
            }
        }
    }

    static void preOrderNotRecursive2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null || !stack.empty()) {
            while (p != null) {
                visit(p);
                stack.push(p);
                p = p.left;
            }

            if (!stack.empty()) {
                p = stack.pop();
                p = p.right;
            }
        }
    }

    public static void testPreOrderResult(List<Integer> preOrders, TreeNode root1) {
        List<Integer> preOrders0 = preOrderResult0(root1);
        System.out.println("preOrderResult0 success：" + equals(preOrders, preOrders0));
        print(preOrders0);
    }

    public static List<Integer> preOrderResult0(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.add(root.value);
        result.addAll(preOrderResult0(root.left));
        result.addAll(preOrderResult0(root.right));

        return result;
    }

    public static List<Integer> preOrderResult(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrderResult(result, root);
        return result;
    }

    public static void preOrderResult(List<Integer> result, TreeNode root) {
        if (root != null) {
            result.add(root.value);
            preOrderResult(result, root.left);
            preOrderResult(result, root.right);
        }
    }

    /**
     * 中序遍历——递归实现
     * @param root
     */
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        visit(root);
        inOrder(root.right);
    }

    /**
     * 中序遍历——非递归实现
     * @param root
     */
    public static void inOrderNotRecursive(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();

        while (p != null || !stack.empty()) {
            while (p != null) {//左孩子先入栈，没有左孩子的时候出栈并访问，然后右孩子再入栈
                stack.push(p);
                p = p.left;
            }

            if (!stack.empty()) {
                p = stack.pop();
                visit(p);
                p = p.right;
            }
        }
    }

    /**
     * 后序遍历——递归实现
     * @param root
     */
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        visit(root);
    }

    /**
     * 后序遍历——非递归实现
     * 基本思想：如果当前结点左右子树均为空，则可以访问当前结点，或者左右子树不均为空，但是前一个访问的结点是当前结点的左孩子或者右孩子，
     * 则也可以访问当前结点，如果前面两种情况均不满足（即，当前结点的左右孩子不均为空，并且前一个访问的结点不是当前结点左右孩子中的任意一个），
     * 则若当前结点的右孩子不为空，将右孩子入栈，若当前结点的左孩子不为空，将左孩子入栈。
     * @param root
     */
    public static void postOrderNotRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.empty()) {
            TreeNode curr = stack.peek();
            //当前结点没有左右孩子，或者左右孩子都已经访问过了，则访问当前结点
            if ((curr.left == null && curr.right == null) || (pre != null && (pre == curr.left || pre == curr.right))) {
                visit(curr);
                stack.pop();
                pre = curr;
            } else {//有左右孩子且左右孩子还没有访问过
                if (curr.right != null) {
                    stack.push(curr.right);
                }

                if (curr.left != null) {
                    stack.push(curr.left);
                }
            }

        }
    }

    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            visit(p);

            if (p.left != null) {
                queue.offer(p.left);
            }

            if (p.right != null) {
                queue.offer(p.right);
            }
        }
    }

    public static void visit(TreeNode treeNode) {
        System.out.println(treeNode.value);
    }

    /**
     * 构建完全二叉树——非递归：数组，自底向上构建
     * @param a
     * @return
     */
    public static TreeNode buildTree(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }

        //首先根据给定的数组构建二叉树结点
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            nodes.add(new TreeNode(a[i]));//第i个结点的索引是i-1
        }

        //然后设置每个二叉树结点的左右孩子指针，从最后一个非终端结点开始，自底向上进行处理
        int i = (a.length - 2) / 2;
        while (i >= 0) {
            TreeNode parent = nodes.get(i);
            int leftIndex = 2 * i + 1;
            if (leftIndex <= a.length - 1) {
                parent.left = nodes.get(leftIndex);
            }

            int rightIndex = 2 * i + 2;
            if (rightIndex <= a.length - 1) {
                parent.right = nodes.get(rightIndex);
            }

            i--;
        }

        return nodes.get(0);
    }

    /**
     * 构建完全二叉树——非递归：队列，自顶向下构建
     * @param a
     * @return
     */
    public static TreeNode buildTree2(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(a[0]);
        queue.add(root);

        int i = 1;//i表示待插入结点的索引
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();

            //有左孩子，则构建当前结点的左孩子
            if (i <= a.length - 1) {
                TreeNode left = new TreeNode(a[i++]);
                p.left = left;
                queue.add(left);
            }

            //有右孩子，则构建当前结点的右孩子
            if (i <= a.length - 1) {
                TreeNode right = new TreeNode(a[i++]);
                p.right = right;
                queue.add(right);
            }
        }

        return root;
    }


    /**
     * 比较两棵二叉树是否相同
     * @param root1
     * @param root2
     * @return
     */
    public static boolean equals(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 != null && root2 == null) {
            return false;
        } else if (root1 == null && root2 != null) {
            return false;
        }

        //root1、root2都不为空
        if (root1.value != root2.value) {
            return false;
        }

        return equals(root1.left, root2.left) && equals(root1.right, root2.right);
    }

    public static boolean equals(List list1, List list2) {
        if (list1 == null && list2 == null) {
            return true;
        } else if (list1 == null && list2 != null) {
            return false;
        } else if (list1 != null && list2 == null) {
            return false;
        }

        if (list1.size() != list2.size()) {
            return false;
        }

        for (Object o1 : list1) {
            for (Object o2 : list2) {
                if (!o1.equals(o2)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void print(List list) {
        if (list == null || list.size() == 0) {
            return;
        }

        StringBuffer sb = new StringBuffer();
        for (Object o : list) {
            sb.append(o + ", ");
        }

        sb.deleteCharAt(sb.lastIndexOf(", "));

        System.out.println(sb.toString());
    }
}
