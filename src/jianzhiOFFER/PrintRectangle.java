package jianzhiOFFER;

import java.util.ArrayList;

/**
 * Created by MarsWang on 2016/9/5.
 */
public class PrintRectangle {
    public ArrayList<Integer> printMatrix(int[][] matrix){
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0)
            return res;
        int left = 0, top = 0, right = matrix[0].length-1, bottom = matrix.length - 1;
        while (left <= right && top <= bottom){
            ////从左到右
            for (int i = left; i <= right; ++i) res.add(matrix[top][i]);
            //从上到下
            for (int i = top + 1; i <= bottom; ++i) res.add(matrix[i][right]);
            //从右到左
            if (top != bottom)
            for (int i = right - 1; i >= left; --i) res.add(matrix[bottom][i]);
            //从下到上
            if (left != right)
            for (int i = bottom - 1; i > top; --i) res.add(matrix[i][left]);
            left++; right--; top++; bottom--;
        }
        return res;


    }
}
