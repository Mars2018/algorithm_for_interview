package tree;

import java.util.List;

/**
 * 测试二叉树
 *
 *                                 6
 *                     /                        \
 *                   1                          12
 *               /       \               /               \
 *            0            3           10                13
 *                                  /      \          /      \
 *                                4         14     20         16
 *                              /   \     /    \
 *                             2     5   11    15
 *
 * Created by mars_wang on 2016/8/25.
 */
public class TreeTest {
    public static void main(String[] args){
        Node root = new Node(6);
        root.left = new Node(1);
        root.right = new Node(12);
        root.left.left = new Node(0);
        root.left.right = new Node(3);
        root.right.left = new Node(10);
        root.right.left.left = new Node(4);
        root.right.left.left.left = new Node(2);
        root.right.left.left.right = new Node(5);
        root.right.left.right = new Node(14);
        root.right.left.right.left = new Node(11);
        root.right.left.right.right = new Node(15);
        root.right.right = new Node(13);
        root.right.right.left = new Node(20);
        root.right.right.right = new Node(16);

        Tree tree = new Tree(root);

        tree.preOrderTraverse();
        System.out.print("先序遍历（非递归）：");
        printNodeList(tree.preOrderNodes);

        tree.inOderTraverse();
        System.out.print("中序遍历（非递归）：");
        printNodeList(tree.inOrderNodes);

        tree.postOrderTraverse();
        System.out.print("后序遍历（非递归）：");
        printNodeList(tree.postOrderNodes);

        tree.preOrderTraverseRecursive(root);
        System.out.print("先序遍历（递归）：");
        printNodeList(tree.preOrderNodes);

        tree.inOrderTraverseRecursive(root);
        System.out.print("中序遍历（递归）：");
        printNodeList(tree.inOrderNodes);

        tree.postOrderTraverseRecursive(root);
        System.out.print("后序遍历（递归）：");
        printNodeList(tree.postOrderNodes);

        Node subTree = tree.biggestSubBST(root);
        System.out.print("\n最大搜索二叉子树：");
        System.out.println(subTree.value);

        System.out.println("\n按层打印：");
        tree.printTreeByLevel(root);

        System.out.println("\nZigZag打印：");
        tree.printTreeByZigZag(root);
    }

    private static void printNodeList(List<Node> nodes) {
        for(int i = 0; i < nodes.size(); ++i){
            System.out.print(" "+nodes.get(i).value);
        }
        System.out.print("\n");
        nodes.clear();
    }

}
