package main.java.com.yll.array;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix==null||matrix.length==0){
            return null;
        }

        int circles=0;
        int m=matrix.length;//row count
        int n=matrix[0].length;//col count

        int[][] visit=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                visit[i][j]=0;
            }
        }

        ArrayList<Integer> result=new ArrayList<Integer>();
        int i=0,j=0;
        while ((i >= 0 && i < m && j >= 0 && j < n) && visit[i][j] == 0) {
            //right
            while (j < n - circles) {
                visit[i][j] = 1;
                result.add(matrix[i][j]);
                j++;
            }
            j--;
            i++;
            //down
            while (i < m - circles) {
                visit[i][j] = 1;
                result.add(matrix[i][j]);
                i++;
            }
            i--;
            j--;

            //left
            while (j >= circles) {
                visit[i][j] = 1;
                result.add(matrix[i][j]);
                j--;
            }
            j++;
            i--;
            //up
            while (i > circles) {
                visit[i][j] = 1;
                result.add(matrix[i][j]);
                i--;
            }
            i++;
            j++;
            circles++;
        }
        return result;

    }

    public static void main(String[] args) {
        PrintMatrix test = new PrintMatrix();
        int[][] a = {{1}};
        ArrayList<Integer> result = test.printMatrix(a);
    }
}
