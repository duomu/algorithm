package main.java.com.yll.search;

import main.java.com.yll.search.proxy.log.PrintLog;

/**
 * 顺序查找
 */
public class SimpleSearch implements ISearch {

    @PrintLog(id = 1, desc = "SimpleSearch")
    @Override
    public int find(int[] a, int key) {
        int index = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                index = i;
                break;
            }
        }
        return index;
    }


}
