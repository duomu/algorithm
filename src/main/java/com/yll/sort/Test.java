package main.java.com.yll.sort;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 5, 6, 7};
        int[] input2 = {7, 6, 5, 4, 3, 2, 1};
        int[] input3 = {3, 1, 5, 4, 7, 2, 6};
        int[][] cases = {input1, input2, input3};
        int[] output = {1, 2, 3, 4, 5, 6, 7};

        testSort(new InsertSort(), cases, output);
        testSort(new BubbleSort(), cases, output);
        testSort(new SelectSort(), cases, output);
        testSort(new QuickSort(), cases, output);
        testSort(new HeapSort(), cases, output);
        testSort(new MergeSort(), cases, output);
    }

    public static void testSort(ISort sortHelper, int[][] cases, int[] output) {
        System.out.println(sortHelper.getClass().getSimpleName()+"----------");
        int[][] newCases = Arrays.copyOf(cases, cases.length);
        for (int i = 0; i < newCases.length; i++) {
            sortHelper.sort(newCases[i]);
            if (!Arrays.equals(newCases[i], output)) {
                System.out.println("test input" + (i + 1) + "：not pass，output：" + parse(newCases[i]));
            } else {
                System.out.println("test input" + (i + 1) + "：test pass");
            }
        }
    }

    private static String parse(int[] a) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < a.length; i++) {
            if (i < a.length - 1) {
                sb.append(a[i] + ", ");
            } else {
                sb.append(a[i]);
            }
        }

        return sb.toString();
    }
}
