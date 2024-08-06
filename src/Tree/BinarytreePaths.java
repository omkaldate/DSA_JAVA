package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinarytreePaths extends BinaryTree{
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null) return list;
        helper(root, list , "");
        return list;
    }

     static void helper(TreeNode node ,List<String>list ,String str){
        if (node.left == null && node.right == null) list.add(str + node.data);

        if (node.left != null) helper(node.left, list, str + node.data + "->");
        if (node.right != null) helper(node.right, list, str + node.data + "->");
    }

   public static void main(String[] args) {
    BinarytreePaths obj = new BinarytreePaths();
    obj.createTree();

       System.out.println(binaryTreePaths(obj.root));

   }
}
