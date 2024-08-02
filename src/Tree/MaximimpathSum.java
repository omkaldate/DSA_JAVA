package Tree;

public class MaximimpathSum extends BinaryTree{
    public static int maxPathSum(TreeNode root) {
        int[]ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        helper(root , ans);
        return ans[0];
    }

    public static int helper(TreeNode node , int[]ans){
        if(node == null) return 0;

        int left = Math.max(0, helper(node.left , ans));
        int right = Math.max(0, helper(node.right,ans));

        ans[0] = Math.max(ans[0], (left+ right+node.data));

        return  Math.max(left , right) + node.data;
    }

    public static void main(String[] args) {
        MaximimpathSum obj = new MaximimpathSum();
        obj.createTree();
        System.out.println(maxPathSum(obj.root));
    }

}
