package main.java.com.yll.string;

import java.util.LinkedList;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1==null||nums1.length==0){
            return findMedian(nums2);
        }

        if(nums2==null||nums2.length==0){
            return findMedian(nums1);
        }

        int[] a=new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j]){
                a[k]=nums1[i];
                i++;
                k++;
            }else if(nums1[i]>nums2[j]){
                a[k]=nums2[j];
                j++;
                k++;
            }else{
                a[k]=nums1[i];
                a[k+1]=nums2[j];
                i++;
                j++;
                k+=2;
            }
        }

        if(i<nums1.length){
            a[k]=nums1[i];
            i++;
            k++;
        }

        if(j<nums2.length){
            a[k]=nums2[j];
            j++;
            k++;
        }

        return findMedian(a);
    }

    double findMedian(int[] nums){
        if(nums==null||nums.length==0){
            return 0.0;
        }

        if(nums.length==1){
            return nums[0];
        }

        int len=nums.length;
        double median=0.0;
        if(len%2==0){
            median=(nums[len/2-1]+nums[len/2])/2.0;
        }else{
            median=nums[len/2];
        }

        return median;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays t = new FindMedianSortedArrays();
//        int[] num1 = {1};
//        int[] num2 = {2, 3, 4};
//        System.out.println(t.findMedianSortedArrays(num1, num2));

//        System.out.println(t.longestPalindrome("abcda"));

        System.out.println(Math.pow(10,2));

        System.out.println(t.reverse(-1534236469));


    }

    public int reverse(int x) {
        int sign=0;
        if(x>0){
            sign=1;
        }else{
            sign=-1;
        }

        LinkedList<Integer> list=new LinkedList<Integer>();
        int val=sign*x;
        int count=0;
        while(val!=0){
            list.offer(val%10);
            val=val/10;
            count++;
        }

        for (int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + ",");
        }
        System.out.println();
        System.out.println("count：" + count);

        double sum=0;
        while(!list.isEmpty()){
            int v=list.poll();
            sum=sum+v*Math.pow(10,count-1);
            count--;
        }

        int result=(int)sum*sign;

        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        System.out.println("max:" + max);
        System.out.println("min:" + min);
        System.out.println("result:" + result);
        if(result>min&&result<max){
            return result;
        }else{
            return 0;
        }
    }

    public String longestPalindrome(String s) {
        if(s==null||s.length()==0){
            return null;
        }

        if(s.length()==1){
            return s;
        }

        int resBegin=0;
        int maxLen=0;
        String result=null;//最长回文子串为s.substring(resBegin,resBegin+mexlen+1);
        for(int i=0;i<s.length();i++){
            //奇数回文
            int left=i-1,right=i+1,curLen=0;
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                curLen=right-left+1;
                if(curLen>maxLen){
                    maxLen=curLen;
                    resBegin=left;
                }
                left--;
                right++;
            }
            //偶数回文
            left=i;
            right=i+1;
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                curLen=right-left+1;
                if(curLen>maxLen){
                    maxLen=curLen;
                    resBegin=left;
                }
                left--;
                right++;
            }

        }

        result = s.substring(resBegin, resBegin + maxLen);
        return result;
    }

    public String longestPalindrome0(String s) {
        if(s==null||s.length()==0){
            return null;
        }

        if(s.length()==1){
            return s;
        }

        StringBuffer curSub=new StringBuffer();
        String maxSub="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int curIdx=curSub.indexOf(c+"");
            if(curIdx==-1){//not produce palindromic substring
                curSub.append(c);
            }else{//produce palindromic substring
                curSub.append(c);
                String palorSub=curSub.substring(curIdx);
                if(palorSub.length()>maxSub.length()){
                    maxSub=palorSub;
                }


                // if(curIdx!=0){
                //     String leftSub=curSub.substring(curIdx+1);
                //     curSub.setLength(0);
                //     curSub.append(leftSub);
                // }

            }
        }

        return maxSub;
    }
}
