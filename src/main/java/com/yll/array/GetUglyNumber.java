package main.java.com.yll.array;

import java.util.Arrays;

public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if(index==0){
            return 0;
        }

        int count=0;
        int currUglyNumber=0;
        int i=1;
        while(count<index){
            if(isUglyNumber(i)){
                count++;
                currUglyNumber=i;
                System.out.println(currUglyNumber);
            }

            i++;
        }

        return currUglyNumber;
    }

    boolean isUglyNumber(int val){
        if (val == 1 || val == 2 || val == 3 || val == 5) {
            return true;
        }

        if (val % 2 != 0 && val % 3 != 0 && val % 5 != 0) {
            return false;
        }

        boolean isUgly=true;
        for(int i=2;i<=val/2;i++){
            if (i!=2&&i!=3&&i!=5){
                if (!isUglyNumber(i)) {
                    isUgly = false;
                    break;
                }
            }
        }

        return isUgly;
    }

    /**
     * 判断val的因子是否只有2/3/5
     * @param val
     * @return
     */
    boolean isFactor(int val){
        if (val == 1 || val == 2 || val == 3 || val == 5) {
            return true;
        }

        if (val % 2 != 0 && val % 3 != 0 && val % 5 != 0) {
            return false;
        }

        boolean isUgly=true;
        for(int i=2;i<=val/2;i++){
            if(val%i==0){
                if (i!=2&&i!=3&&i!=5){
                    if (!isFactor(i)) {
                        isUgly = false;
                        break;
                    }
                }
            }
        }

        return isUgly;
    }

    public static void main(String[] args) {
        GetUglyNumber test = new GetUglyNumber();
        int v = test.GetUglyNumber_Solution(12);
        System.out.println("---------------");
        System.out.println(v);

        System.out.println(test.isFactor(28));

    }

    public int maximumProduct(int[] nums) {
        if(nums==null||nums.length<3){
            return 0;
        }else if(nums.length==3){
            return nums[0]*nums[1]*nums[2];
        }

        for(int i=1;i<nums.length;i++){
            for(int j=0;j<nums.length-i;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }

            if(i==3){
                break;
            }
        }
        int len=nums.length;
        return nums[len-1]*nums[len-2]*nums[len-3];

    }
}
