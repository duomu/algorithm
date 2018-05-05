package main.java.com.yll.sort;

/**
 * 选择排序：
 * 和插入排序一样也是将数据列表分成有序和无序的两部分，前面是有序的，后面是无序的。
 * 和插入排序的不同之处在于，插入排序每次都是顺序从无序部分取一个元素，为其在有序部分寻找待插入的位置，
 * 即每次要插入的元素立即就可以确定（第一个无序元素），待插入位置需要查找才可以确定。
 * 而选择额排序恰恰相反，每次待插入的位置可以立即确定（第一个无序元素的位置），待插入的元素需要查找才可以确定。
 * 而且每次都从无序部分中找到一个最小的，放在有序部分的末尾，这样当所有的元素都处理完毕，整个列表就是有序的了。
 *
 * 基于比较和交换
 *
 * 选择排序，其实也是每趟排序都能确定一个元素的最终位置，，这样经过有限趟次就能将所有的元素都放到最终的位置上。
 */
public class SelectSort implements ISort {
    @Override
    public void sort(int[] a) {
        for (int i = 0; i <= a.length - 1; i++) {//i总是指向第一个未排序的元素
            int minIndex = i;
            int min = a[i];
            for (int j = i+1; j < a.length - 1; j++) {
                if (a[j] <= min) {
                    min = a[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }
}
