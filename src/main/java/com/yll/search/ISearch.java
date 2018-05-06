package main.java.com.yll.search;

import main.java.com.yll.search.proxy.log.PrintLog;

public interface ISearch {
    /**
     * 在数组中查找是否存在给定值的关键字，若存在则返回>=0，否则返回-1
     *
     * @param a
     * @param key
     * @return
     */
    @PrintLog(id = 0, desc = "ISearch")
    int find(int[] a, int key);
}
