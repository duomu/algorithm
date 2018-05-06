package main.java.com.yll.search.proxy.log;

import main.java.com.yll.search.*;

import java.lang.reflect.Method;

public class LogTest {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 6, 7, 9, 19};
        int key = 5;
        int fkey = 30;
        int[] cases = {key, fkey};
        System.out.println("jdk proxy-------------------------------");
        ProxyJdkHandler proxyJdkHandler = new ProxyJdkHandler();
        ISearch simpleSearch = (ISearch) proxyJdkHandler.getProxy(new SimpleSearch());
        simpleSearch.find(a, key);
        ISearch binarySearch = (ISearch) proxyJdkHandler.getProxy(new BinarySearch());
        binarySearch.find(a, key);
        ISearch bstSearch = (ISearch) proxyJdkHandler.getProxy(new BSTSearch());
        bstSearch.find(a, key);

        Test.testSearch(simpleSearch, a, cases);
        Test.testSearch(binarySearch, a, cases);
        Test.testSearch(bstSearch, a, cases);

        System.out.println("cglib proxy-----------------------------");
        ProxyCglibHandler proxyCglibHandler = new ProxyCglibHandler();
        simpleSearch = (ISearch) proxyCglibHandler.getProxy(new SimpleSearch());
        simpleSearch.find(a, key);
        binarySearch = (ISearch) proxyCglibHandler.getProxy(new BinarySearch());
        binarySearch.find(a, key);
        bstSearch = (ISearch) proxyCglibHandler.getProxy(new BSTSearch());
        bstSearch.find(a, key);

//        testAnnotation(new SimpleSearch());
//        testAnnotation(new BinarySearch());
//        testAnnotation(new BSTSearch());

        Test.testSearch(simpleSearch, a, cases);
        Test.testSearch(binarySearch, a, cases);
        Test.testSearch(bstSearch, a, cases);
    }

    private static void testAnnotation(ISearch searchHelper) {
        Method[] methods = searchHelper.getClass().getDeclaredMethods();
        for (Method method : methods) {
            PrintLog printLog = method.getAnnotation(PrintLog.class);
            if (printLog != null) {
                System.out.println("Found PrintLog：" + printLog.id() + "，" + printLog.desc());
            }
        }
    }
}
