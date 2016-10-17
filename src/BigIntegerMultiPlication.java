import java.util.Scanner;

/**
 * Created by Mars on 2016/10/17.
 */
public class BigIntegerMultiPlication {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int[] res = new int[s[0].trim().length() + s[1].trim().length()+1];
        StringBuffer m1, m2;
        if(s[0].length() >= s[1].length()){
            m1 = new StringBuffer(s[0].trim());
            m2 = new StringBuffer(s[1].trim());
        }else {
            m1 = new StringBuffer(s[1].trim());
            m2 = new StringBuffer(s[0].trim());
        }
        char[] c1 = m1.reverse().toString().toCharArray();
        char[] c2 = m2.reverse().toString().toCharArray();
        for(int i = 0; i < c2.length; ++i){
            int key = c2[i] - '0';
            for (int j = 0; j < c1.length; ++j){
                int tmp = c1[j] - '0';
                int multi = key * tmp;
                res[i+j] += multi % 10;
                res[i+j+1] += multi / 10;
            }
        }
        for (int i = 0; i < res.length-1; ++i){
            if (res[i] > 9){
                res[i+1] += res[i] / 10;
                res[i] = res[i] % 10;
            }
        }
        int from = res.length-1;
        while (res[from] == 0)
            from --;
        if (from < 0)
            System.out.print("0");
        else {
            while (from >= 0)
                System.out.print(res[from--]);
        }
        System.out.println();
    }
}
