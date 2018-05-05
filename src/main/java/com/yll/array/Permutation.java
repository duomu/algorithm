package main.java.com.yll.array;

import java.util.ArrayList;
import java.util.Collections;

public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result=new ArrayList<String>();
        if(str==null||str.length()==0){
            return result;
        }else if(str.length()==1){
            result.add(str);
            return result;
        }

        ArrayList<String> subResult=Permutation(str.substring(0,str.length()-1));
        char currChar=str.charAt(str.length()-1);

        StringBuffer sb=new StringBuffer();
        if(subResult==null||subResult.size()==0){
            sb.append(currChar);
            result.add(sb.toString());
            sb.setLength(0);
        }else{
            for(String s:subResult){
                for(int i=s.length()-1;i>=0;i--){
                    sb.append(s.substring(0,i+1));
                    sb.append(currChar);
                    if(i<s.length()-1){
                        sb.append(s.substring(i+1,s.length()));
                    }
                    result.add(sb.toString());
                    sb.setLength(0);
                }


                String currStr=sb.append(currChar).append(s).toString();
                if(!result.contains(currStr)){
                    result.add(currStr);
                    sb.setLength(0);
                }

            }
        }

        return result;

    }

    public static void main(String[] args) {
        ArrayList<String> result = new Permutation().Permutation("aabc");
        Collections.sort(result);
        if (result != null && result.size() >0) {
            for (String s : result) {
                System.out.println(s);
            }
        }
    }
}
