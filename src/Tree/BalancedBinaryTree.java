package Tree;

public class BalancedBinaryTree extends BinaryTree{
    public static boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    public static int helper(TreeNode node){
        if(node == null) return 0;

        int left = helper(node.left);
        int right = helper(node.right);

        if(left == -1  || right == -1) return -1;
        if(Math.abs(left-right) >1) return -1;

        return Math.max(left,right)+1;
    }



    public static void main(String[] args) {
        BalancedBinaryTree obj = new BalancedBinaryTree();
        obj.createTree();
        System.out.println(isBalanced(obj.root));
    }
}
