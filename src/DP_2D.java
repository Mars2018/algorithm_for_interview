import java.util.Scanner;

/**
 * Created by Mars on 2016/10/17.
 */
public class DP_2D {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        String[] s = cin.nextLine().split(" ");
        char[] chs1 = s[0].toCharArray();
        char[] chs2 = s[1].toCharArray();
        int row = chs1.length+1;
        int col = chs2.length+1;
        int[][] dp = new int[row][col];
        for (int i = 1; i < row; ++i){
            dp[i][0] = i;
        }
        for (int j = 1; j < col; ++j){
            dp[0][j] = j;
        }
        for (int i = 1; i < row; ++i){
            for (int j = 1; j < col; ++j){
                if (chs1[i-1] == chs2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+1);
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+1);
            }
        }
        System.out.println(dp[row-1][col-1]);
    }
}
