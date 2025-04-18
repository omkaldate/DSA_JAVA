package Tree;

public class FlipEquivalentBinaryTrees extends BinaryTree{

    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        if (root1.data == root2.data){
            boolean noFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
            boolean flip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
            return noFlip || flip;
        }
        else return false;
    }


    public static void main(String[] args) {

    }
}
