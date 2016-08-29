package tree;

/**
 * Created by mars_wang on 2016/8/29.
 */
public class MyUtils {
    public static void print2DArrays(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        System.out.println("[");
        for(int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
        System.out.println("]");
    }
}
