package jianzhiOFFER;

/**
 * 二维数组
 * Created by MarsWang on 2016/9/5.
 */
public class Array2D {
     public boolean Find(int[][] array, int target) {
         if (array.length == 0 || array[0].length == 0 || array[0][0] > target || array[array.length - 1][array[0].length - 1] < target)
             return false;
         int row = 0;
         int col = array[0].length - 1;
         while (row < array.length && col > -1) {
             if (array[row][col] == target)
                 return true;
             else if (array[row][col] > target)
                 col--;
             else
                 row++;
         }
         return false;
     }
}
