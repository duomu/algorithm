package main.java.com.yll.sort;

/**
 * 归并排序：
 * 归并的含义是将两个或两个以上的有序表合并成一个新的有序表。
 * 2-路归并的核心操作是将一维数组中前后相邻的两个有序序列归并为一个有序序列。
 * 归并排序的基本思想是分治：
 * 首先将待排序的n个元素的序列分解成两个子序列，每个子序列包括n/2个元素；
 * 然后对每个子序列，分别递归进行归并排序；
 * 最后合并排好序的两个子序列，生成排序结果。
 */
public class MergeSort implements ISort {
    @Override
    public void sort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private void mergeSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }

    }

    /**
     * 合并两个有序的子序列 low~mid，mid+1~high
     * @param a
     * @param low
     * @param mid
     * @param high
     */
    private void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = a[i++];
        }

        while (j <= high) {
            temp[k++] = a[j++];
        }

        for (i = low, k = 0; i <= high; i++) {
            a[i] = temp[k];
            k++;
        }
    }
}
