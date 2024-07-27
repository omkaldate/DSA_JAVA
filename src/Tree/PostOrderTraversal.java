package Tree;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal extends BinaryTree {

    public static void post(TreeNode node , List<Integer> x){
        if(node == null) return;

        post(node.left , x);
        post(node.right , x);
        x.add(node.data);
    }
    public static void postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        post(root , list);
        System.out.println(list);
    }

    public static void main(String[] args) {
        PostOrderTraversal obj = new PostOrderTraversal();
        obj.createTree();
        postorderTraversal(obj.root);
    }
}
