package main.java.com.yll.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyComparator {
    public static void main(String[] args) {
        int[] a = {0,2,1,-3};
        final int target=1;
        System.out.println(new MyComparator().threeSumClosest(a, target));

        List<List<Integer>> result=new ArrayList<List<Integer>>();
    }

    public int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length<3){
            return 0;
        }

        Integer[] a=new Integer[nums.length];
        for(int i=0;i<a.length;i++){
            a[i]=nums[i];
        }

        final int k = target;

        Arrays.sort(a,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                if(o1.equals(o2)){
                    return 0;
                }else{
                    int diff1=Math.abs(o1-k);
                    int diff2=Math.abs(o2-k);
                    return diff1-diff2;
                }
            }
        });


        for (Integer val : a) {
            System.out.println(val);
        }

        System.out.println("------------");

        return a[0]+a[1]+a[2];
    }
}
