package tree;

import java.util.Arrays;

/**
 * 0-1背包问题
 * Created by mars_wang on 2016/8/29.
 */
public class KnapsackProblem01 {
    public static void main(String[] args){
        /*Scanner in = new Scanner(System.in);

        int bagSize = in.nextInt();
        int weightNum = in.nextInt();
        int valueNum = in.nextInt();
        int[] weights = new int[weightNum+1];
        int[] values = new int[valueNum+1];
        for(int i = 0; i < weightNum; ++i)
            weights[i+1] = in.nextInt();
        for (int i = 0; i < valueNum; ++i)
            values[i+1] = in.nextInt();*/

        int weightNum = 5;
        int bagSize = 10;
        int[] weights = {0,2,2,6,5,4};
        int[] values = {0,6,3,5,4,6};


        int[][] result = new int[weightNum+1][bagSize+1];
        for (int j = 1; j < bagSize + 1; ++j){
            if(j < weights[weightNum])
                result[weightNum][j] = 0;
            else
                result[weightNum][j] = values[weightNum];
        }
        for(int i = weightNum-1; i > 0; --i)
            for(int j = 1; j < bagSize+1; ++j){
                if(j < weights[i])
                    result[i][j] = result[i][j-1];
                else
                    result[i][j] = result[i+1][j] > result[i+1][j-weights[i]] + values[i]?
                            result[i+1][j] : result[i+1][j-weights[i]] + values[i];
            }

        MyUtils.print2DArrays(result);

        int i, j = bagSize;
        int[] x = new int[weightNum];
        for (i = 1; i < weightNum; ++i)
            if (result[i][j] == result[i+1][j])
                x[i-1] = 0;
            else{
                x[i-1] = 1;
                j = j -weights[i];
            }
        x[i-1] = result[i][j] == 0 ? 0 : 1;
        System.out.println(Arrays.toString(x));
    }
}
