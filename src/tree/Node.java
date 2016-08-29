package tree;

/**
 * Created by mars_wang on 2016/8/25.
 */
public class Node implements Comparable{
    public int value;
    public Node left;
    public Node right;

    public Node(int data){
        value = data;
    }

    @Override
    public int compareTo(Object o) {
        Node  node = (Node)o;
        return value - node.value;
    }
}
