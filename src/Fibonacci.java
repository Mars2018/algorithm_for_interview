/**
 * Created by mars_wang on 2016/8/30.
 */
public class Fibonacci {
    public static void main(String[] args){
        System.out.println("递归："+f1(46));
        System.out.println("动态规划："+f2(46));
        System.out.println("矩阵："+f3(46));
    }

    public static int f1(int n){
        if (n < 1){
            return 0;
        }
        if (n == 1 || n == 2)
            return 1;
        return f1(n-1) + f1(n-2);
    }

    public static int f2(int n){
        if(n < 1)
            return 0 ;
        if (n == 1 || n == 2)
            return 1;
        int res = 1;
        int pre = 1;
        int tmp = 0;
        for (int i = 3; i <= n; i++){
            tmp = res;
            res = pre + res;
            pre = tmp;
        }
        return res;
    }

    public static int f3(int n){
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int[][] base = {{1,1},{1,0}};
        int[][] res = matrixPower(base, n-2);
        return res[0][0]+res[1][0];
    }

    private static int[][] matrixPower(int[][] base, int p) {
        int[][] res = new int[base.length][base[0].length];
        for (int i = 0; i < res.length; ++i)
            res[i][i] = 1;

        int[][] tmp = base;
        for (; p != 0; p >>= 1){
            if ((p & 1) != 0)
                res = multiMatrix(res, tmp);
            tmp = multiMatrix(tmp, tmp);
        }
        return res;
    }

    private static int[][] multiMatrix(int[][] tmp1, int[][] tmp2) {
        int[][] res = new int[tmp1.length][tmp2[0].length];
        for (int i = 0; i < tmp1.length; ++i)
            for (int j = 0; j < tmp2[0].length; ++j)
                for (int k = 0; k < tmp2.length; ++k)
                    res[i][j] += tmp1[i][k] * tmp2[k][j];

        return res;
    }
}
