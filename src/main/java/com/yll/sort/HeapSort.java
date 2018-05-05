package main.java.com.yll.sort;

/**
 * 堆排序：堆排序的过程就是一个不断输出堆顶元素，然后重建堆的过程，由于堆顶总是最大或最小的元素，所以当所有元素都输出完毕之后，
 * 就能得到一个递增或者递减的元素序列，具体步骤如下：
 * （1）首先将无序序列构成成初始堆，
 * （2）然后输出堆顶元素，并以堆中最后一个元素代替它，由于元素交换破坏了堆性质，需要自堆顶至叶子节点进行调整，以重建堆。
 *  不断重复步骤（2）直到所有元素都输出完毕。
 *
 *  构建初始堆的步骤：
 *  （1）首先构建无序序列对应的完全二叉树
 *  （2）然后自上而下进行调整，将这个完全二叉树转换成堆。
 *
 * 完全二叉树中，假设i从0开始编号，则结点i的左孩子为2i+1，右孩子为2i+2，若包含n个结点，则最后一个非终端结点是n/2-1(向下取整)
 * 堆有大根堆和小根堆之分，大根堆中所有孩子结点都小于等于父结点，小根堆中所有孩子结点都大于等于父结点。
 *
 * 基于比较和交换，是对选择排序的改进
 * 每趟排序都能确定一个元素的最终位置，这样经过有限趟次就能将所有的元素都放到最终的位置上。
 */
public class HeapSort implements ISort {
    @Override
    public void sort(int[] a) {
        //构建初始堆
        for (int i = a.length / 2; i >= 0; i--) {
            heapAjust(a, i, a.length - 1);
        }

        //每趟排序将最大的元素-堆顶和最后一个元素交换，并调整堆，经过有限趟次排序后，就能得到一个有序序列
        for (int i = a.length - 1; i > 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapAjust(a, 0, i - 1);
        }
    }

    /**
     * 将二叉树调整成堆
     * @param a 以数组存储的完全二叉树
     * @param k 要进行堆调整的起始非终端结点（子二叉树的根结点）
     * @param end 最后一个元素
     */
    public void heapAjust(int[] a, int k, int end) {
        int left = 2 * k + 1;
        int right = 2 * k + 2;
        if (left > end && right > end) {//递归出口
            return;
        }

        int maxIndex = left;//存储父节点、左孩子、右孩子中最大者的数组索引
        if (left < end && a[left] < a[right]) {//right最大，必须left<end，若left==end，即left是最后一个元素，则没有right了
            maxIndex = right;
        }

        if (a[maxIndex] < a[k]) {//k最大
            maxIndex = k;
        }


        if (maxIndex != k) {//孩子大，需要和父节点交换，被交换的子树的堆性质有可能被破坏，需要重新调整
            int temp = a[maxIndex];
            a[maxIndex] = a[k];
            a[k] = temp;
            heapAjust(a, maxIndex, end);
        }
    }

    /**
     * 堆调整-循环实现
     * @param a
     * @param k 表示需要进行堆调整的二叉树的根节点的数组索引
     * @param end
     */
    private void heapAjustLoop(int[] a, int k, int end) {
        int key = a[k];
        for (int j = 2 * k + 1; j <= end; j = 2 * j) {//为结点a[k]寻找合适的位置
            if (j < end && a[j] < a[j + 1]) {//right大
                j++;
            }

            if (a[j] < key) {//k大
                break;
            }

            a[k] = a[j];
            k = j;//下一个要调整的结点
        }

        a[k] = key;
    }
}
