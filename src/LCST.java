/**
 * 最长公共子串
 * Created by MarsWang on 2016/9/1.
 */
public class LCST {

    public static  void  main(String[] args){
        String s1 = "1A2345CD6";
        String s2 = "B12345B6A";
        String res = getLCST(s1, s2);
        System.out.println(res);
    }

    public static String getLCST(String str1, String str2){
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0)
            return "";
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getLSCTDP(chs1, chs2);
        int end = 0;
        int max = 0;
        for (int i = 0; i < dp.length; ++i)
            for (int j = 1; j < dp[0].length; ++j){
                if (dp[i][j] > max){
                    end = i;
                    max = dp[i][j];
                }
            }

        return str1.substring(end-max+1, end+1);
    }

    private static int[][] getLSCTDP(char[] chs1, char[] chs2) {
        int[][] dp = new int[chs1.length][chs2.length];
        for (int i = 0; i < chs1.length; ++i)
                dp[i][0] = chs1[i] == chs2[0] ? 1 : 0;
        for (int j = 0; j < chs2.length; ++j)
            dp[0][j] = chs1[0] == chs2[j] ? 1 : 0;

        for (int i = 1; i < chs1.length; ++i)
            for (int j = 1; j < chs2.length; ++j){
                dp[i][j] = chs1[i] == chs2[j] ? dp[i-1][j-1]+1 : 0;
            }

        return dp;
    }
}
