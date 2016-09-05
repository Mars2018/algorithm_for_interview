import tree.MyUtils;

import java.util.Arrays;

/**
 * 最长公共子序列
 * Created by MarsWang on 2016/9/1.
 */
public class LCS {

    public static  void  main(String[] args){
        String s1 = "1A2C3D4B56";
        String s2 = "B1D23CA45B6A";
        String res = getLCS(s1, s2);
        System.out.println(res);
    }

    public  static  String getLCS(String s1, String s2){
        int[][] dp = getLCSDP(s1, s2);
        MyUtils.print2DArrays(dp);
        int m = dp.length - 1;
        int n = dp[0].length - 1;
        char[] res = new char[dp[m][n]];
        int index = res.length -1 ;
        while(index >= 0){
            if (n > 0 && dp[m][n] == dp[m][n-1]) {
            //    System.out.println(dp[m][n] + " " + dp[m][n-1]);
                n--;
            }else if (m > 0 && dp[m][n] == dp[m-1][n])
                m--;
            else {
                res[index--] = s1.charAt(m);
                m--;
                n--;
            }
        }
        return String.valueOf(res);
    }

    private  static int[][] getLCSDP(String s1, String s2){
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        //初始化第一列
        for(int i = 1; i < str1.length; ++i){
           dp[i][0] = Math.max(dp[i-1][0], str1[i] == str2[0] ? 1 : 0);
        }
        //初始化第一行
        for (int j = 1; j < str2.length; ++j){
            dp[0][j] = Math.max(dp[0][j-1], str2[j] == str1[0] ? 1 : 0);
        }
        for (int i = 1; i < str1.length; ++i)
            for (int j = 1; j < str2.length; ++j){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if (str1[i] == str2[j])
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
            }

        return dp;

    }


}
