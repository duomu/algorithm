package main.java.com.yll.string;

/**
 * 获取数组中重复的数字
 */
public class Solution {
    public static void main(String[] args) {
        int [] a={2,1,3,1,4};
        int length=5;
        int [] duplication=new int[length];
        for(int i=0;i<duplication.length;i++){
          duplication[i]=-1;
        }

        boolean result = duplicate(a, length, duplication);
        System.out.println(result + ", " + duplication[0]);
    }

    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null||numbers.length!=length||duplication==null||duplication.length!=length){
            return false;
        }

        for(int i=0;i<numbers.length;i++){
            int key=numbers[i];
            duplication[key]=duplication[key]+1;
        }

        for(int i=0;i<duplication.length;i++){
            if(duplication[i]>0){
                duplication[0]=i;
                return true;
            }
        }

        return false;
    }
}
