import java.util.ArrayList;
import java.util.Scanner;

/**
 * 数组全排列
 * Created by Mars on 2016/10/17.
 */
public class FullPermutation {
    private static ArrayList<ArrayList<Integer>> fullPermutation = new ArrayList<>();
    private static ArrayList<ArrayList<Boolean>> operatorOrders = new ArrayList<>();
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; ++i)
            A[i] = in.nextInt();
        getFullPermutation(A, 0, N-1);
        /* for (int i = 0; i < fullPermutation.size(); ++i)
        System.out.println(fullPermutation.get(i).toString());*/
        boolean[] operators = new boolean[N-1];
        getOperatorOrders(operators, 0, N-1);
        int res = Integer.MAX_VALUE;
        /* for (int i = 0; i < operatorOrders.size(); ++i)
        System.out.println(operatorOrders.get(i).toString());*/
        for (int i = 0; i < fullPermutation.size(); ++i){
            ArrayList<Integer> arr = fullPermutation.get(i);
            for (int j = 0; j < operatorOrders.size();++j){
                ArrayList<Boolean> opt = operatorOrders.get(j);
                int tmpRes = arr.get(0);
                for (int k = 0; k < opt.size();++k){
                    if (opt.get(k)){
                        tmpRes += arr.get(k+1);
                    }else {
                        tmpRes *= arr.get(k+1);
                    }
                }
                res = res < Math.abs(tmpRes-K) ? res : Math.abs(tmpRes-K);
            }
        }
        System.out.println(res);
    }

    private static void getOperatorOrders(boolean[] operators, int now, int end) {
        if (now == end){
            ArrayList<Boolean> tmp = new ArrayList<>(operators.length);
            for (int i = 0; i < end; ++i){
                tmp.add(operators[i]);
            }
            operatorOrders.add(tmp);
        }else {
            operators[now] = true;
            getOperatorOrders(operators, now+1, end);
            operators[now] = false;
            getOperatorOrders(operators, now+1, end);
        }
    }


    private static void getFullPermutation(int[] a, int start, int end) {
        if (start == end){
            ArrayList<Integer> tmp = new ArrayList<>(a.length);
            for (int i = 0; i < a.length; ++i)
                tmp.add(a[i]);
            fullPermutation.add(tmp);
        }else {
            for (int i = start; i <= end; ++i){
                swap(a, start, i);
                getFullPermutation(a, start+1, end);
                swap(a, i, start);
            }
        }
    }

    private static void swap(int[] a, int start, int i) {
        if (start == i)
            return;
        int tmp = a[start];
        a[start] = a[i];
        a[i] = tmp;
    }
}
