package jianzhiOFFER;


import java.util.Stack;

/**
 * Created by MarsWang on 2016/9/7.
 */
public class CovertTreeToList {
    /**
     * 使用递归
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return pRootOfTree;
        pRootOfTree = ConvertNode(pRootOfTree);
        while (pRootOfTree.left != null)
            pRootOfTree = pRootOfTree.left;
        return pRootOfTree;
    }

    private TreeNode ConvertNode(TreeNode root) {
        if (root == null)
            return root;
        if (root.left != null){
            TreeNode left = ConvertNode(root.left);
            while (left.right != null)
                left = left.right;
            left.right = root;
            root.left = left;
        }
        if (root.right != null){
            TreeNode right = ConvertNode(root.right);
            while (right.left != null)
                right = right.left;
            right.left = root;
            root.right = right;
        }
        return root;
    }

    /**
     * 非递归，中序遍历
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert2(TreeNode pRootOfTree){
        if (pRootOfTree == null)
            return pRootOfTree;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = pRootOfTree;
        boolean first = true;
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()){
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(first){
                pRootOfTree = root;
                pre = root;
                first = false;
            }else {
                pre.right = root;
                root.left = pre;
                pre = root;
            }
            root = root.right;

        }
        return pRootOfTree;
    }
}

class TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val){
        this.val = val;
    }
}
