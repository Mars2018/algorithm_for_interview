package jianzhiOFFER;

import java.util.ArrayList;

/**
 * Created by MarsWang on 2016/9/5.
 */
public class PrintRectangle {
    public ArrayList<Integer> printMatrix(int[][] matrix){
        int upx = 0, upy = matrix[0].length-1;
        int downx = matrix.length-1, downy = 0;
        boolean upfinish = false;
        ArrayList<Integer> res = new ArrayList<>();
        while (upx != downx && upy != downy){
            if (!upfinish){
                for (int i = downy; i <= upy; ++i)
                    res.add(matrix[upx][i]);
                for (int j = upx+1; j <= downx; ++j)
                    res.add(matrix[upy][j]);
                upfinish = true;
                upx++; upy--;
            }else {
                for (int j = upy; j >= downy; --j)
                    res.add(matrix[downx][j]);
                for (int i = downx + 1; i >= upx; i--)
                    res.add(matrix[i][downy]);
                upfinish = false;
                downx--; downy++;
            }
        }
        if (upx == downx){
            if (upfinish)
                for (int i = upy; i >= downy; --i)
                    res.add(matrix[upx][i]);
            else
                for (int i = downy; i <= upy; ++i)
                    res.add(matrix[upx][i]);
        }else if (upy ==  downy){
            if (upfinish){
                for (int i = upx; i <= downx; ++i)
                    res.add(matrix[i][upy]);
            }else
                for (int i = downx; i >= upx; --i)
                    res.add(matrix[i][upy]);

        }

        return res;


    }
}
