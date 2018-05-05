package main.java.com.yll.tree;

import main.java.com.yll.list.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindPath {
    public ArrayList<ArrayList<Integer>> findPath2(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        stack.push(root);
        int sum = root.val;
        path.add(root.val);
        TreeNode preNode = null;
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (top.left == null && top.right == null) {//top是叶子节点，判断是否可生成一条给定值的路径
                if(sum==target){
                    paths.add(new ArrayList<Integer>(path));
                }

                sum -= stack.peek().val;
                path.remove(path.size() - 1);
                preNode = stack.peek();
                stack.pop();
            }else{

                if ((top.right != null && preNode == top.right) || (top.right == null && preNode == top.left)) {//top已处理完毕
                    sum -= stack.peek().val;
                    path.remove(path.size() - 1);
                    preNode = stack.peek();
                    stack.pop();
                } else {
                    TreeNode toVisitNode = null;
                    if (preNode != top.left) {//若左孩子没访问过，则访问左孩子
                        toVisitNode = top.left;
                    } else if (preNode != top.right) {//若左孩子访问过，且右孩子没访问过，则访问右孩子
                        toVisitNode = top.right;
                    }

                    if (toVisitNode != null) {
                        stack.push(toVisitNode);
                        sum += toVisitNode.val;
                        path.add(toVisitNode.val);
                    }
                }
            }
        }

        return paths;
    }
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int sum = root.val;
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        TreeNode preNode = null;
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (top.left == null && top.right == null) {//top是叶子节点，判断是否可生成一条给定值的路径
                if(sum==target){
                    paths.add(new ArrayList<Integer>(path));
                }

                sum -= stack.peek().val;
                path.remove(path.size() - 1);
                preNode = stack.peek();
                stack.pop();
            }else{
                //top有左孩子，则访问左孩子
                if(top.left!=null)
                //判断top是否处理完毕（右孩子已访问）
                if (preNode == top.right) {//处理过
                    sum -= stack.peek().val;
                    path.remove(path.size() - 1);
                    preNode = stack.peek();
                    stack.pop();
                }else{//没处理完毕

                    TreeNode p = top;

                    //若top的左孩子未访问过，则访问top的左孩子
                    if (preNode != top.left) {
                        while (p.left != null) {
                            stack.push(p.left);
                            sum += p.left.val;
                            path.add(p.left.val);
                            p = p.left;
                        }
                    }

                    if(sum==target){
                        paths.add(new ArrayList<Integer>(path));
                    }

                    if (p.right != null) {//p有右孩子，访问右孩子
                        stack.push(p.right);
                        sum += p.right.val;
                        path.add(p.right.val);
                    } else {//p没有右孩子，则处理完毕
                        sum -= stack.peek().val;
                        path.remove(path.size() - 1);
                        preNode = stack.peek();
                        stack.pop();
                    }
                }

            }
        }

        return paths;
    }

    public static void main(String[] args) {
        new FindPath().findPath(null, 0);
    }
}
