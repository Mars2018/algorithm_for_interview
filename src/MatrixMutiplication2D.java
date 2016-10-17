import java.util.Scanner;

/**
 * 二维向量相乘
 * Created by Mars on 2016/10/17.
 */
public class MatrixMutiplication2D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int K = in.nextInt();
        int[][] A = new int[N][M];
        int[][] B = new int[M][K];
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < M; ++j)
                A[i][j] = in.nextInt();
        for (int i = 0; i < M; ++i)
            for (int j = 0; j < K; ++j)
                B[i][j] = in.nextInt();
        int[][] res = new int[N][K];
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < K; ++j)
                for (int k = 0; k < M; ++k)
                    res[i][j] = res[i][j] + A[i][k] * B[k][j];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < K - 1; ++j)
                System.out.print(res[i][j] + " ");
            System.out.println(res[i][K - 1]);
        }
    }
}
