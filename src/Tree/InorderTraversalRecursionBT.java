package Tree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversalRecursionBT extends BinaryTree{

    public static void inor(TreeNode node){
        if(node == null) return ;

        inor(node.left);
        System.out.println(node.data + " ");
        inor(node.right);
    }


    public static void inorderTraversal(TreeNode root) {
        inor(root);
    }


    public static void main(String[] args) {
        InorderTraversalRecursionBT obj = new InorderTraversalRecursionBT();
        obj.createTree();
        inorderTraversal(obj.root);
    }
}
