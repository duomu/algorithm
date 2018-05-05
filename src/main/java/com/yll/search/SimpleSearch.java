package main.java.com.yll.search;

public class SimpleSearch implements ISearch {
    @Override
    public int find(int[] a, int key) {
        int index = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                index = i;
                break;
            }
        }
        return index;
    }
}
