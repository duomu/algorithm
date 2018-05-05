package main.java.com.yll.sort;

/**
 * 冒泡排序：每趟排序通过两两交换将未排序部分中的最大元素放到最后，若在一趟排序过程中没有发生过交换，则说明已经是有序的了。
 * 对于n个元素最多需要n-1趟排序，第i趟排序需要进行n-1-i次比较
 *
 * 基于比较和交换
 *
 * 每趟排序都确定一个元素的最终位置，这样经过有限趟次就能将所有的元素都放到最终的位置上。
 */
public class BubbleSort implements ISort{
    @Override
    public void sort(int[] a) {
        boolean changed = true;
        for (int i = 0; changed && i < a.length - 1; i++) {
            changed = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    changed = true;
                }
            }
        }
    }
}
