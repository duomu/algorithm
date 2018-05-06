package main.java.com.yll.search;

import main.java.com.yll.search.proxy.log.ProxyJdkHandler;

public class Test {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 6, 7, 9, 19};
//        int[] a = {1, 2, 4, 5, 6, 7};
//        int[] a = new int[10000];
//        for (int i = 0; i < a.length; i++) {
//            a[i] = i;
//        }
        int key = 5;
        int fkey = 30;
        int[] cases = {key, fkey};
//        testSearch(new SimpleSearch(), a, cases);
//        testSearch(new BinarySearch(), a, cases);
//        testSearch(new BSTSearch(), a, cases);

        ISearch simpleSearch = (ISearch) new ProxyJdkHandler().getProxy(new SimpleSearch());
        ISearch binarySearch = (ISearch) new ProxyJdkHandler().getProxy(new BinarySearch());
        ISearch bstSearch = (ISearch) new ProxyJdkHandler().getProxy(new BSTSearch());
        testSearch(simpleSearch, a, cases);
        testSearch(binarySearch, a, cases);
        testSearch(bstSearch, a, cases);
    }

    public static void testSearch(ISearch searchHelper, int[] a, int[] cases) {
        System.out.println(searchHelper.getClass().getSimpleName()+"-----------");
        long start = System.currentTimeMillis();
        for (int i = 0; i < cases.length; i++) {
            int index = searchHelper.find(a, cases[i]);
            if (index == -1) {
                System.err.println("test case" + (i + 1) + "：not find，index=" + index);
            } else {
                System.out.println("test case" + (i + 1) + "：find it，index=" + index);
            }

        }

//        System.out.println("spend time：" + (System.currentTimeMillis() - start) + "ms");
    }
}
