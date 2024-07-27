package Tree;

import java.util.List;
import java.util.ArrayList;

public class preOrderTraversal extends BinaryTree{
    public static void pre(TreeNode node , List<Integer> x){
        if(node == null) return;

        x.add(node.data);
        pre(node.left , x);
        pre(node.right , x);
    }

    public static void fun(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        pre(root , list);
        System.out.println(list);
    }

    public static void main(String[] args) {
        preOrderTraversal obj = new preOrderTraversal();
        obj.createTree();
        fun(obj.root);
    }
}
