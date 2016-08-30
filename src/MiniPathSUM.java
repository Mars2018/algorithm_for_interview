/**
 * Created by mars_wang on 2016/8/30.
 */
public class MiniPathSUM {
    public static void main(String[] args){
        int[][] arr = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        System.out.println(minPath(arr));
    }
    public static int minPath(int[][] arr){
        if (arr == null || arr.length == 0 || arr[0] == null
                || arr[0].length == 0)
            return 0;
        int row = arr.length;
        int col = arr[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < row; ++i)
            dp[i][0] = dp[i-1][0] + arr[i][0];
        for (int j = 1; j < col; ++j)
            dp[0][j] = dp[0][j-1] + arr[0][j];
        for (int i = 1; i < row; ++i)
            for (int j = 1; j < col; ++j)
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + arr[i][j];

        return dp[row - 1][col - 1];
    }
}
