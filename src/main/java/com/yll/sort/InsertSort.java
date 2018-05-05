package main.java.com.yll.sort;

/**
 * 插入排序：将数据列表分成两部分，前面是有序的，后面是无序的，将无序部分中的元素逐个插入到有序表中合适的位置，
 * 通过比较和移动，最终得到一个递增有序列表。
 *
 * 基于比较和移动
 *
 * 每趟排序并不能确定一个元素的最终位置，每次有新的元素插入有序部分时，都可能改变有序元素的位序。
 */
public class InsertSort implements ISort{

    @Override
    public void sort(int[] a){
        moveWithFindLoc(a);
    }

    /**
     * 通过比较寻找到插入位置后，一次性移动所有需要移动的元素
     */
    private void moveAfterFindLoc(int[] a) {
        //从第二个元素开始，逐个将元素插入到前面有序序列中的合适位置，即寻找第一个小于自己的元素
        //然后将第一个小于自己的元素之后的有序元素，都后移一个位置，给当前元素腾出一个位置i。
        //将当前元素复制到位置i上，然后再依次循环处理剩余的未排序的元素，直到所有元素处理完毕（总共需要进行n-1次这种处理）。
        for (int i = 1; i <= a.length - 1; i++) {
            int key=a[i];
            //寻找a[i]要插入的位置
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] <= key) {
                    break;
                }
            }

            //若j==i-1,说明a[i]前面的元素都小于a[i]，a[i]不需要移动;只有j<i-1时，说明a[i]前面有大于a[i]的元素，a[i]需要移动。
            //从j+1到i-1的元素都后移一个位置，并将a[i]复制到a[j+1]
            if (j < i-1) {
                for (int k = i; k >= j + 2; k--) {
                    a[k] = a[k - 1];
                }

                a[j + 1] = key;
            }
        }
    }

    /**
     * 一边比较寻找插入位置，一边移动元素
     */
    private void moveWithFindLoc(int[] a) {
        for (int i = 1; i <= a.length - 1; i++) {
            int key=a[i];

            int j = i - 1;
            while (j >= 0 && a[j] > key) {//寻找a[i]要插入的位置，一边比较一边将大于a[i]的元素后移
                a[j + 1] = a[j];
                j--;
            }

            if (j != i - 1) {//若j==i-1,说明a[i]前面的元素都小于a[i]，a[i]不需要移动;当j!=i-1时，必有j<i-1，说明a[i]前面有大于a[i]的元素，a[i]需要移动。
                a[j + 1] = key;
            }
        }
    }
}
