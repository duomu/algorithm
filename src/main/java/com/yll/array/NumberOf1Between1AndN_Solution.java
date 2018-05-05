package main.java.com.yll.array;

public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n==0){
            return 0;
        }

        return NumberOf1Between1AndN_Solution(n-1)+count(n);
    }

    int count(int n){
        String s=n+"";
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int count = new NumberOf1Between1AndN_Solution().NumberOf1Between1AndN_Solution(100);
        System.out.println(count);
    }
}
