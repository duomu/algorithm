package main.java.com.yll.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<numbers.length;i++){
            list.add(numbers[i]);
        }

        Collections.sort(list,new Comparator<Integer>(){
            @Override
            public int compare(Integer val1,Integer val2){
                String s1=val1+""+val2;
                String s2=val2+""+val1;
                return s1.compareTo(s2);
            }
        });

        StringBuffer s=new StringBuffer();
        for(int i:list){
            s.append(i);
        }

        return s.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append(1);
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        sb.append(list);
        System.out.println(sb.toString());
    }
}
