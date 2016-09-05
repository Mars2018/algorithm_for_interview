import tree.MyUtils;

/**
 * 给定两个字符串str1，str2，在给定三个整数ic,dc,rc, 分别代表插入，
 * 删除和替换换一个字符的代价，返回将str1编辑成str2的最小代价
 * Created by MarsWang on 2016/9/1.
 */
public class StringEditorCost {
    public static void main(String[] args){
        String s1 = "abc";
        String s2 = "adc";
        int ic = 5, dc= 3, rc = 100;
        int res = stringEditorMinCost(s1, s2, ic, dc, rc);
        System.out.println(res);
    }

    /**
     *
     * @param s1 待修改字符串
     * @param s2 参考字符串
     * @param ic 插入代价
     * @param dc 删除代价
     * @param rc 替换代价
     * @return 反回所有操作的最低代价
     */
    public static int stringEditorMinCost(String s1, String s2, int ic, int dc, int rc){
        if (s1 == null || s2 == null || s1.equals("") || s2.equals(""))
            return 0;
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int[][] dp = new int[chs1.length+1][chs2.length+1];
        for (int i = 1; i < chs1.length+1; ++i)
            dp[i][0] = dc * i;
        for (int j = 1; j < chs2.length+1; ++j)
            dp[0][j] = dc * j;
        for (int i = 1; i < chs1.length+1; ++i)
            for (int j = 1; j < chs2.length+1; ++j){
                if (chs1[i-1] == chs2[j-1])
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = dp[i-1][j-1] + rc;
                dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+ic);
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+dc);
            }
        MyUtils.print2DArrays(dp);
        return dp[chs1.length-1][chs2.length-1];

    }
}
