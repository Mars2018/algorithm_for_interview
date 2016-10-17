package jianzhiOFFER;

import java.util.Stack;

/**
 * Created by MarsWang on 2016/9/6.
 */
public class MinForStack {
    private Stack<Integer> s = new Stack<>();
    private Stack<Integer> mins = new Stack<>();
    public void push(int node){
        if (s.isEmpty()){
            s.push(node);
            mins.push(node);
        }else{
            if (node < s.peek()){
                mins.push(node);
            }else
                mins.push(s.peek());

            s.push(node);
        }
    }

    public void pop(){
        if (s.isEmpty())
            return;
        else{
            s.pop();
            mins.pop();
        }
    }

    public int top(){
        return s.peek();
    }

    public int min(){
        return mins.peek();
    }

}
