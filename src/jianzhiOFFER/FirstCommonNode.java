package jianzhiOFFER;

import java.util.*;

/**
 * Created by MarsWang on 2016/9/11.
 */
public class FirstCommonNode {
    public static void main(String[] args){
       System.out.println(ReverseSentence(" "));


    }
    public ListNode findFirstCommonListNode(ListNode pHead1, ListNode pHead2){

        HashSet<ListNode> p1 = new HashSet<>();
        ListNode tmp = pHead1;
        while (tmp != null){
            p1.add(tmp);
            tmp = tmp.next;
        }
        tmp = pHead2;
        while (tmp != null){
            if (p1.contains(tmp))
                return tmp;
            tmp = tmp.next;
        }

        return null;
    }

    /**
     * 找出数组中只出现了一次的两个数
     * @param array 原数组
     * @param num1 存放第一个数
     * @param num2 存放第二个数
     */
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < array.length; ++i){
            if(!set.contains(array[i]))
                set.add(array[i]);
            else
                set.remove(array[i]);
        }


        Iterator<Integer> iterator = set.iterator();
        num1[0]= (Integer)iterator.next();
        num2[0] = (Integer)iterator.next();
    }

    /**
     * s所有和为sum的连续正数
     * @param sum 和
     * @return 各连续序列
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum <= 2)
            return res;
        for (int i= 0; i <= sum/2; ++i){
            int tmpSum = 0;
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = i + 1; j <= sum/2 + 1; ++j){
                tmpSum += j;
                tmp.add(j);
                if (tmpSum == sum){
                    res.add(tmp);
                    tmpSum = 0;
                    tmp = null;
                    break;
                }

            }
        }
        return res;
    }

    /**
     * 递增数组中找到两个和为sum的数，如果存在多组，则找出成绩最小的
     * @param array
     * @param sum
     * @return
     */
    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int end = array.length-1;
        int multi = Integer.MAX_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>(2);
        for (int i = 0; i <= end; ++i)
            map.put(array[i],i);
        for (int i = 0; i <= end; ++i){
            if (map.containsKey(sum-array[i])){
                if (array[i]*(sum-array[i]) < multi){
                    multi = array[i]*(sum-array[i]);
                    if (res.size() == 0) {
                        res.add(array[i]);
                        res.add(sum-array[i]);
                    }else{
                        res.set(0,array[i]);
                        res.set(1, sum-array[i]);
                    }

                    end = map.get(sum-array[i])-1;
                }
            }
        }
        return res;
    }

    /**
     *将一个字符串循环左移K位
     * @param str
     * @param n
     * @return
     */
    public static String LeftRotateString(String str,int n) {
        if (str.equals(""))
            return "";
        int k = n % str.length();
        String tmp = str + str;
        String res = tmp.substring(k, k+str.length());
        return res;
    }

    /**
     * 翻转单词顺序
     * @param str
     * @return
     */
    public static String ReverseSentence(String str) {
        if (str.length() < 2)
            return str;
        String[] ss = str.split(" ");
        String res = "";
        for(int i = ss.length-1; i > 0; --i){
            res += ss[i] + " ";
        }
        res += ss[0];
        return res;
    }


    /**
     * n个人按照从0到m-1报数，报m-1的人去掉，最后剩下的人的编号
     * @param n
     * @param m
     * @return
     */
    public static int LastRemaining_Solution(int n, int m) {
        ArrayList<Integer> people = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            people.add(i);
        int cnt = 0;
        while(people.size() > 1){
            for(int i = 0; i < m; ++i){
                cnt++;
                if(cnt % people.size() == 0)
                    cnt = 0;
            }
            people.remove(cnt);
        }
        return people.get(0);
    }

}
