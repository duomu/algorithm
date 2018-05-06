package main.java.com.yll.search;

import main.java.com.yll.search.proxy.log.PrintLog;

/**
 * 使用不平衡的二叉排序树进行查找，其实通常效率很低。
 */
public class BSTSearch implements ISearch {
    @PrintLog(id = 3, desc = "BSTSearch")
    @Override
    public int find(int[] a, int key) {
        BinarySortTree bst = new BinarySortTree();
        for (int i = 0; i < a.length; i++) {
            bst.insertBST(a[i]);
        }

        return bst.searchBST(key);
    }
}
