package Tree;

public class PathSum extends BinaryTree{
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root,0,targetSum);
    }

    public static boolean helper(TreeNode node , int ans , int target){
        if(node == null) return false;

        if(node.left == null && node .right == null){
            ans += node.data;
            if(ans == target) return true;
        }
        return helper(node.left,ans+node.data,target) ||  helper(node.right,ans+node.data,target);
    }


    public static void main(String[] args) {
        PathSum obj = new PathSum();
        obj.createTree();
        System.out.println(hasPathSum(obj.root , 5));
    }
}
