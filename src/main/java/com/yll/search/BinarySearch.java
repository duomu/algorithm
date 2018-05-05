package main.java.com.yll.search;

public class BinarySearch implements ISearch {
    @Override
    public int find(int[] a, int key) {
        int index = -1;
        int low = 0;
        int high = a.length - 1;
        while (low<=high) {
            int mid = (low + high) / 2;
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                index = mid;
                break;
            }
        }

        return index;
    }
}
