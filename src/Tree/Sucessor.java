package Tree;

public class Sucessor extends BinaryTree{
    public TreeNode inorderSuccessor(TreeNode root,TreeNode x){
        TreeNode sucessor = null;

        while(root != null){
            if(x.data >= root.data){
                root = root.right;
            }
            else{
                sucessor = root;
                root = root.left;
            }
        }
        return sucessor;
    }

    public static void main(String[] args) {
        Sucessor obj = new Sucessor();
        obj.createTree();
        TreeNode x = new TreeNode(3);
        TreeNode val = obj.inorderSuccessor(obj.root,x);
        System.out.println(val.data);
    }
}
