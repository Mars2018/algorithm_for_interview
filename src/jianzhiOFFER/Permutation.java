package jianzhiOFFER;

import java.util.*;

/**
 * 字符全排列
 * Created by MarsWang on 2016/9/7.
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {

        ArrayList<String> arrayList = new ArrayList<>();
        if (str == null || str.length() == 0)
          return arrayList;
        StringBuffer sb = new StringBuffer(str);
        doPermutation(sb, 0, arrayList);
        Collections.sort(arrayList);
        return arrayList;
    }

    private void doPermutation(StringBuffer sb, int index, ArrayList<String> arrayList) {
        if (index == sb.length()-1)
            arrayList.add(sb.toString());
        for (int i = index; i < sb.length(); ++i){
            if (i != index && sb.charAt(i) == sb.charAt(index))
                continue;
            //交换位置
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(index));
            sb.setCharAt(index, tmp);

            doPermutation(sb, index+1, arrayList);

            //重新换回原来的位置
            tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(index));
            sb.setCharAt(index, tmp);
        }
    }

    //利用深度优先搜索
    private ArrayList<String> res = new ArrayList<>();
    private boolean[] used;
    private char[] seqs;
    private HashSet<String> result = new HashSet<>();
    public ArrayList<String> permuteDFS(String str){
        if (str == null || str.length() == 0)
            return res;
        used = new boolean[str.length()];
        char[] sc= str.toCharArray();
        seqs = new  char[str.length()];
        dfs(sc, 0);
        res.addAll(result);
        Collections.sort(res);
        return res;
    }

    private void dfs(char[] sc,int step) {
        if (step == sc.length){
            String s = "";
            for (int i = 0; i < sc.length;++i)
                s += seqs[i];
            result.add(s);
            return;
        }

        for (int i = 0; i < sc.length; ++i){
            if (used[i] == true)
                continue;
            used[i] = true;
            seqs[step] = sc[i];
            dfs(sc, step+1);
            used[i] = false;
        }


    }
}
