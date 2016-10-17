package jianzhiOFFER;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * Created by MarsWang on 2016/9/7.
 */
public class UglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0)
            return 0;
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();
        Queue<Integer> q5 = new LinkedList<>();
        int minVal = 0;
        q2.add(1);
        for(int i = 0; i < index; ++i){
            int val2 = q2.isEmpty()?Integer.MAX_VALUE:q2.peek();
            int val3 = q3.isEmpty()?Integer.MAX_VALUE:q3.peek();
            int val5 = q5.isEmpty()?Integer.MAX_VALUE:q5.peek();

            minVal = Math.min(val2, Math.min(val3,val5));

            if(minVal == val2){
                q2.poll();
                q2.add(minVal*2);
                q3.add(minVal*3);
                q5.add(minVal*5);

            }else if(minVal == val3){
                q3.poll();
                q3.add(minVal*3);
                q5.add(minVal*5);
            }else{
                q5.poll();
                q5.add(minVal*5);
            }
        }
        return minVal;

    }
}
