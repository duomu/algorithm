package main.java.com.yll.sort;

/**
 * 快速排序：每趟排序，也是将数据列表分成两部分，但不是按照是否有序进行划分的，而首先选定一个元素作为哨兵，将小于这个哨兵的元素都移到哨兵的左边，
 * 将大于这个哨兵的元素都移动到哨兵的右边，这样通过一趟排序将数据列表分成了小于哨兵和大于哨兵的两部分，确定了哨兵元素的最终位置，
 * 然后再递归地分别对小于哨兵的部分和大于哨兵的部分进行如上的排序过程，最终，当所有元素都处理完毕，整个列表就是有序的了。
 *
 * 基于比较和交换，是对冒泡排序的改进
 *
 * 和冒泡排序一样，每趟排序都能确定一个元素的最终位置，这样经过有限趟次就能将所有的元素都放到最终的位置上。
 */
public class QuickSort implements ISort {
    @Override
    public void sort(int[] a) {
        //首先对整个列表进行一次划分，记第一个元素为S0,将小于S0的元素都移到S0的前面，大于S0的元素都移到S0的后面，这样将整个数组划分成了两部分
        //然后分别对前面的部分和后面的部分继续进行这样的划分，最终将所有元素的位置都确定下来并移到了对应的位置。
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(int[] a, int low, int high) {
        if (low < high) {//递归入口/出口
            int privot = partion(a, low, high);
            quickSort(a, low, privot - 1);
            quickSort(a, privot + 1, high);
        }
    }

    private int partion(int[] a, int low, int high) {
        int key = a[low];//将待划分序列中的第一个元素作为哨兵（待排序的元素）
        while (low < high) {//low==high时一趟排序结束
            while (low < high && a[high] >= key) {//从后向前寻找一个小于key的元素
                high--;
            }

            a[low] = a[high];

            while (low < high && a[low] <= key) {//从前向后寻找一个大于key的元素
                low++;
            }

            a[high] = a[low];
        }

        a[low] = key;
        return low;
    }
}
