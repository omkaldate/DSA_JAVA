package Tree;

public class MinDepth extends BinaryTree{

    public static int minDepth(TreeNode root) {
        if(root==null) return 0;

        int l=minDepth(root.left);
        int r=minDepth(root.right);

        if(l==0) return 1+r;
        else if(r==0) return 1+l;

        return 1+Math.min(l,r);
    }

    public static void main(String[] args) {
        MinDepth obj = new MinDepth();
        obj.createTree();
        System.out.println(minDepth(obj.root));
    }


}
