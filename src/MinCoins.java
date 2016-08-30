/**
 * Created by mars_wang on 2016/8/30.
 */
public class MinCoins {
    public static int minCoins1(int[] arr, int aim){
        if (arr == null || arr.length == 0 || aim < 0)
            return -1;
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
        for (int j = 1; j <= aim; ++j){
            dp[0][j] = max;
            if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max)
                dp[0][j] = dp[0][j - arr[0]] + 1;
        }
        int left = 0;
        for (int i = 1; i < n; ++i){
            for (int j = 1; j <= aim; ++j){
                left = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max){
                    left = dp[i][j - arr[i]]+1;
                }
                dp[i][j] = Math.min(left, dp[i-1][j]);
            }
        }
        return dp[n-1][aim] != max ? dp[n-1][aim] : -1;
    }

    public int minCoins2(int[] arr, int aim){
        if(arr == null || arr.length == 0 || aim < 0)
            return -1;
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[] dp = new int[aim+1];
        for (int j = 1; j <= aim; ++j){
            dp[j] = max;
            if (j - arr[0] >= 0 && dp[j - arr[0]] != max)
                dp[j] = dp[j-arr[0]] + 1;
        }
        int left = 0;
        for (int i = 1; i < n; ++i)
            for (int j = 1; j <= aim; ++j){
                left = max;
                if (j - arr[i] >= 0 && dp[j-arr[i]] != max)
                    left = dp[j-arr[i]] + 1;
                dp[j] = Math.min(left, dp[j]);
            }
        return dp[aim] != max ? dp[aim] : -1;
    }

    public int minCoins3(int[] arr, int aim){
        if (arr == null || arr.length == 0 || aim < 0)
            return -1;
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim+1];
        for (int i = 1; i <= aim; ++i){
            dp[0][i] = max;
        }
        if (arr[0] <= aim)
            dp[0][arr[0]] = 1;
        int leftup = 0;
        for (int i = 1; i < n; ++i)
            for (int j = 1; j <= aim; ++j){
                leftup = max;
                if (j - arr[i] >= 0 && dp[i-1][j-arr[i]] != max)
                    leftup = dp[i-1][j-arr[i]] + 1;
                dp[i][j] = Math.min(leftup, dp[i-1][j]);
            }
        return dp[n-1][aim] != max ? dp[n-1][aim] : -1;
    }

    /**
     * 换钱的方式有多少种, O(N*aim^2)
     * @param arr 可以换的钱的种类
     * @param aim 需要换的总额
     * @return 种类
     */
    public int conins(int[] arr, int aim){
        if (arr == null || arr.length == 0 || aim < 0)
            return 0;
        int[][] dp = new int[arr.length][aim+1];
        for (int i = 0; i < arr.length; ++i)
            dp[i][0] = 1;
        for (int j = 1; arr[0] * j <= aim; ++j)
            dp[0][arr[0]*j] = 1;
        int num = 0;
        for (int i = 0; i < arr.length; ++i)
            for (int j = 1; j <= aim; ++j){
                num = 0;
                for (int k = 0; j - arr[i] *k >= 0; ++k)
                    num += dp[i-1][j-arr[i]*k];
                dp[i][j] = num;
            }
        return dp[arr.length-1][aim];
    }

    /**
     * 优化算法 O(N*aim)
     * @param arr
     * @param aim
     * @return
     */
    public int coins2(int[] arr, int aim){
        if (arr == null | arr.length == 0 || aim < 0)
            return -1;
        int n = arr.length;
        int[][] dp = new int[n][aim+1];
        for(int i = 0; i < n; ++i)
            dp[i][0] = 1;
        for (int j = 0; j * arr[0] <= aim; ++j)
            dp[0][j*arr[0]] = 1;
        for (int i = 1; i < arr.length; ++i)
            for (int j = 1; j <= aim; ++j){
                dp[i][j] = dp[i-1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j-arr[i]] : 0;
            }
        return dp[arr.length - 1][aim];
    }

}
