package jianzhiOFFER;

import java.util.Stack;

/**
 * Created by MarsWang on 2016/9/6.
 */
public class Catalan {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int a = 0, b = 0;
        int aMax = pushA.length-1, bMax = popA.length-1;
        Stack<Integer> stack = new Stack<>();
        if (aMax != bMax)
            return false;
        stack.push(pushA[a++]);
        while(!stack.isEmpty()){
            if (popA[b] == stack.peek()){
                b++;
                stack.pop();
            }else {
                if (a > aMax)
                    return false;
                stack.push(pushA[a++]);
            }
        }
        return true;
    }
}
