import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 对数字字符串进行重新排列使获得的整数字符串最大
 * Created by Mars on 2016/10/17.
 */
public class ArrayRearrangeToGetMaxInteger {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < s.length; ++i)
            res.add(s[i]);
        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (Integer.parseInt(o1+o2) > Integer.parseInt(o2+o1))
                    return -1;
                else if (Integer.parseInt(o1+o2) == Integer.parseInt(o2+o1)){
                    return 0;
                }else
                    return 1;
            }
        });
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < res.size(); ++i)
            sb.append(res.get(i));
        System.out.println(sb.toString());
    }
}
