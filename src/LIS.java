import java.util.Arrays;

/**
 * 最长递增子序列问题
 * Created by mars_wang on 2016/8/30.
 */
public class LIS {
    public static void main(String[] args){
        int[] arr = {2,1,5,3,6,4,8,9,7};
        int[] dp = getLISdp1(arr);
        System.out.println(Arrays.toString(dp));
    }

    /**
     * 求以arr[i]结尾的最长递增子序列长度，复杂度为O(N^2)
     * @param arr
     * @return
     */
    public static int[] getLISdp1(int[] arr){
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; ++i){
            dp[i] = 1;
            for (int j = 0; j < i; ++j){
                if (arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        return dp;
    }
}
