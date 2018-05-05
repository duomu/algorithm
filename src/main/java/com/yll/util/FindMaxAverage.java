package main.java.com.yll.util;

public class FindMaxAverage {
    public static void main(String[] args) {
        FindMaxAverage test = new FindMaxAverage();
        int[] a = {1, 12, -5, -6, 50, 3};
        int k=4;
        System.out.println(test.findMaxAverage(a, k));
    }

    public double findMaxAverage(int[] nums, int k) {
        double maxAverage=0.0;
        if(nums==null||nums.length<k){
            return maxAverage;
        }

        double max=-300000001;
        double sum=0;
        for(int i=0;i<=nums.length-k;i++){
            sum+=nums[i];
            int j=i+1;
            int count=k-1;
            while(j<nums.length&&count>0){
                sum+=nums[j];
                count--;
                j++;
            }

            if(sum>max){
                max=sum;
            }

            sum=0;
        }

        maxAverage=max/k;
        return maxAverage;

    }
}
