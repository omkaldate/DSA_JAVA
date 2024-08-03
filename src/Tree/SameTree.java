package Tree;

public class SameTree extends BinaryTree{
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null) return (p==q);

        return (p.data == q.data) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {
        SameTree obj = new SameTree();
        SameTree obj2 = new SameTree();
        obj.createTree();
        obj2.createTree();

        System.out.println(isSameTree(obj.root,obj2.root));
    }
}
