import tree.MyUtils;

/**
 * 给定三个字符串str1, str2,aim，判断aim是否为str1和str2的交叉组成
 * Created by MarsWang on 2016/9/1.
 */
public class StringCross {

    public static void main(String[] args){
        String s1 = "AB";
        String s2 ="12";
        String aim = "A12B";
        boolean res = isCross(s1, s2, aim);
        System.out.println(res);
    }
    public static boolean isCross(String s1, String s2, String aim){
        if (s1 == null || s2 == null || aim == null)
            return false;

        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        char[] chaim = aim.toCharArray();
        int row = chs1.length + 1;
        int col = chs2.length + 1;
        if (chaim.length != chs2.length + chs1.length)
            return false;
        int[][] dp = new int[row][col];
        dp[0][0] = 0;
        for (int i = 1; i < row; ++i) {
            if (chs1[i - 1] != chaim[i - 1])
                break;
            dp[i][0] = 1;
        }
        for (int j = 1; j < col; ++j){
            if (chs2[j - 1] != chaim[j - 1])
                break;
            dp[0][j] = 1;
        }
        for (int i = 1; i < row; ++i)
            for (int j = 1; j < col; ++j){
                if ((chs1[i-1] == chaim[i+j-1] && dp[i-1][j] == 1)
                        || (chs2[j-1] == chaim[i+j-1] && dp[i][j-1] == 1))
                    dp[i][j] = 1;
            }

        MyUtils.print2DArrays(dp);
        return  dp[row-1][col-1] == 1;

    }
}
