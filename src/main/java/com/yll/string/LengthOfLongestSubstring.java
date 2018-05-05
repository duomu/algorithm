package main.java.com.yll.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }

        int maxlen=0;
        StringBuffer subStr=new StringBuffer();
        for(int i=0;i<s.length();i++){
            char curChar=s.charAt(i);
            int curIndexOfSub=subStr.indexOf(curChar+"");
            if(curIndexOfSub==-1){//not contains curChar
                subStr.append(curChar);
            }else{//contains curChar
                if(subStr.length()>maxlen){
                    maxlen=subStr.length();
                }
                String leftSub=subStr.substring(curIndexOfSub);
                subStr.setLength(0);
                subStr.append(leftSub);
                subStr.append(curChar);
            }
        }

        if(subStr.length()>maxlen){
            maxlen=subStr.length();
        }

        return maxlen;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring test = new LengthOfLongestSubstring();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
        List<List<Integer>> result = new ArrayList<List<Integer>>();

    }
}
