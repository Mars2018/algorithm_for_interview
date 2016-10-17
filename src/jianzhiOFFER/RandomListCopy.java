package jianzhiOFFER;

/**
 * 复制复杂链表
 * Created by MarsWang on 2016/9/7.
 */
public class RandomListCopy {

    /**
     * 使用递归
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null)
            return null;
        RandomListNode myHead = new RandomListNode(pHead.label);
        myHead.next = pHead.next;
        myHead.random = pHead.random;
        myHead.next = Clone(pHead.next);
        return myHead;

    }

    /**
     * 1.复制每个节点，如复制节点A，得到节点A1, 将A1插入到A后面
     * 2.遍历链表，将 A1.random = A.random.next
     * 3.将列表进行拆分成原链表和复制后的链表
     * @param pHead
     * @return
     */
    public RandomListNode Clone2(RandomListNode pHead){
        if (pHead == null)
            return null;
        RandomListNode cur = pHead;
        //复制节点
        while (cur != null){
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = cur.next;
        }
        //复制random指针
        cur= pHead;
        while (cur.next != null){
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        //拆分链表
        RandomListNode myHead = pHead.next;
        RandomListNode tmp = myHead;
        cur = pHead;
        while(cur.next != null){
            tmp = cur.next;
            cur.next = tmp.next;
            cur = tmp;
        }
        return myHead;

    }



}
class RandomListNode{
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label){
         this.label = label;
     }
}
