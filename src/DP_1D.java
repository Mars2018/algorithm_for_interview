import java.util.Scanner;

/**
 * Created by Mars on 2016/10/17.
 */
public class DP_1D {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String s = cin.nextLine();
        String[] ss = s.split(",");
        int[] money = new int[ss.length];
        for (int i = 0; i < ss.length; ++i)
            money[i] = Integer.valueOf(ss[i]);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < money.length; ++i) {
            int key = money[i];
            for (int j = i + 1; j < money.length; ++j)
                max = Math.max(max, money[j] - key);
        }
        System.out.println(max);

    }
}
