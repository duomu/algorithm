package main.java.com.yll.search;

public class Test {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 6, 7, 9, 19};
        int key = 5;
        int fkey = 30;
        int[] cases = {key, fkey};
        testSearch(new SimpleSearch(), a, cases);
        testSearch(new BinarySearch(), a, cases);
    }

    private static void testSearch(ISearch searchHelper, int[] a, int[] cases) {
        System.out.println(searchHelper.getClass().getSimpleName()+"-----------");
        for (int i = 0; i < cases.length; i++) {
            int index = searchHelper.find(a, cases[i]);
            if (index == -1) {
                System.out.println("test case" + (i + 1) + "：not find，index=" + index);
            } else {
                System.out.println("test case" + (i + 1) + "：find it，index=" + index);
            }

        }
    }
}
