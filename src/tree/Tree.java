package tree;

import java.util.*;

/**
 * Created by mars_wang on 2016/8/25.
 */
public class Tree {

    public Node root;
    public List<Node> preOrderNodes = new ArrayList<>();
    public List<Node> inOrderNodes = new ArrayList<>();
    public List<Node> postOrderNodes = new ArrayList<>();

    public Tree(Node root){
        this.root = root;
    }

    /**
     * 先序遍历（递归）
     * @param node
     */
    public void preOrderTraverseRecursive(Node node){
        if (node == null)
            return;
        preOrderNodes.add(node);
        preOrderTraverseRecursive(node.left);
        preOrderTraverseRecursive(node.right);
    }

    /**
     * 中序遍历（递归）
     * @param node
     */
    public void inOrderTraverseRecursive(Node node){
        if (node == null){
            return;
        }
        inOrderTraverseRecursive(node.left);
        inOrderNodes.add(node);
        inOrderTraverseRecursive(node.right);
    }

    /**
     * 后续遍历（递归）
     * @param node
     */
    public void postOrderTraverseRecursive(Node node){
        if (node == null){
            return;
        }
        postOrderTraverseRecursive(node.left);
        postOrderTraverseRecursive(node.right);
        postOrderNodes.add(node);
    }

    /**
     * 先序遍历（非递归）
     */
    public void preOrderTraverse(){
        if (root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            preOrderNodes.add(node);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
    }

    /**
     * 中序遍历（非递归）
     */
    public void inOderTraverse(){
        if (root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                inOrderNodes.add(node);
                node = node.right;

            }
        }
    }

    /**
     * 后续遍历（非递归）
     */
    public void postOrderTraverse(){
        if(root == null)
            return;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            Node node = stack1.pop();
            stack2.push(node);
            if (node.left != null)
                stack1.push(node.left);
            if (node.right != null)
                stack1.push(node.right);
        }
        while(!stack2.isEmpty()){
            postOrderNodes.add(stack2.pop());
        }
    }


    /**
     * 二叉树中最大搜索二叉子树
     * @param root 树根节点
     * @return
     */
    public Node biggestSubBST(Node root){
        int[] record = new int[3];
        return posOrder(root, record);
    }

    //后续遍历，找到左右子树的最大搜索二叉子树
    private Node posOrder(Node root, int[] record) {
        if (root == null){
            record[0] = 0;
            record[1] = Integer.MAX_VALUE;//0x7fffffff
            record[2] = Integer.MIN_VALUE;//0x80000000
            return null;
        }
        int value = root.value;
        Node left = root.left;
        Node right = root.right;
        Node lBST = posOrder(left, record);
        int lSize = record[0];
        int lMin = record[1];
        int lMax = record[2];
        Node rBST = posOrder(right, record);
        int rSize = record[0];
        int rMin = record[1];
        int rMax = record[2];
        record[1] = Math.min(lMin, value);
        record[2] = Math.max(rMax, value);
        if(left == lBST && right == rBST && lMax <value && value < rMin){
            record[0] = lSize + rSize + 1;
            return root;
        }
        record[0] = Math.max(lSize, rSize);
        return lSize > rSize ? lBST : rBST;

    }

    /**
     * 按层打印二叉树
     */
    public void printTreeByLevel(Node root){
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        int level = 1;
        Node last = root;
        Node nLast = null;
        queue.offer(root);
        System.out.print("Level " + (level++) + " : ");
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null){
                queue.offer(node.left);
                nLast = node.left;
            }
            if (node.right != null){
                queue.offer(node.right);
                nLast = node.right;
            }
            if (node == last && !queue.isEmpty()){
                System.out.print("\nLevel " + (level++) + " : ");
                last = nLast;
            }
        }
        System.out.println();
    }

    public void printTreeByZigZag(Node root){
        if (root == null)
            return;
        Deque<Node> deque = new LinkedList<>();
        int level = 1;
        Node last = root;
        Node nLast = null;
        deque.addFirst(root);
        boolean lr = true;
        Node node = root;
        while (!deque.isEmpty()){
            if(lr){
                node = deque.pollFirst();
                if (node.left != null){
                    nLast = nLast == null ? node.left : nLast;
                    deque.offerLast(node.left);
                }
                if (node.right != null){
                    nLast = nLast == null ? node.right : nLast;
                    deque.offerLast(node.right);
                }
            }else {
                node = deque.pollLast();
                if (node.right != null){
                    nLast = nLast == null ? node.right : nLast;
                    deque.offerFirst(node.right);
                }
                if (node.left != null){
                    nLast = nLast == null ? node.left : nLast;
                    deque.offerFirst(node.left);
                }
            }
            System.out.print(node.value + " ");
            if (node == last && !deque.isEmpty()){
                lr = !lr;
                last = nLast;
                nLast = null;
                System.out.println();
                System.out.print("Level " + level + " from ");
                System.out.print(lr ? "left to right: " : "right to left: ");
            }
        }
    }

    public Node[] getTwoErrNodes(Node head){
        if(head == null)
            return null;
        Node[] errNodes = new Node[2];
        Stack<Node> stack = new Stack<>();
        List<Node> sortedVal = new ArrayList<>();
        while (!stack.isEmpty() || head != null){
            if (head != null){
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();
                sortedVal.add(head);
                head = head.right;

            }
        }
        for (int i = 0, j = 0; i < sortedVal.size()-1; ++i){
            if(sortedVal.get(i).value > sortedVal.get(i+1).value)
                if(j == 0)
                    errNodes[j++] = sortedVal.get(i);
                else
                    errNodes[j++] = sortedVal.get(i+1);
        }
        return errNodes;
    }


    /**
     * 通过先序和中序构造二叉树
     * @param pre
     * @param in
     * @return
     */
    public Node preInToTree(int[] pre, int[] in){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < in.length; ++i)
            map.put(in[i], i);
        return preIn(pre, 0, pre.length-1, in, 0, in.length-1, map);
    }

    private Node preIn(int[] p, int pi, int pj, int[] n, int ni, int nj, HashMap<Integer, Integer> map) {
        if (pi > pj)
            return null;

        Node head = new Node(p[pi]);
        int index = map.get(p[pi]);
        head.left = preIn(p, pi+1, pi + index - ni, n, ni, index-1, map);
        head.right = preIn(p, pi + index - ni + 1, pj, n, index+1, nj, map);
        return head;
    }
}
