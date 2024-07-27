package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal extends BinaryTree{

    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        List<List<Integer>> wraplist = new LinkedList<List<Integer>>();

        if(root == null) System.out.println(wraplist);
        que.offer(root);

        while(! que.isEmpty()){
            int levelNum = que.size();
            List<Integer> sublist = new LinkedList<Integer>();

            for(int i=0; i<levelNum; i++){
                if(que.peek().left != null) que.offer(que.peek().left);
                if(que.peek().right != null) que.offer(que.peek().right);
                sublist.add(que.poll().data);
            }
            wraplist.add(sublist);
        }
        System.out.println(wraplist);
    }

    public static void main(String[] args) {
        LevelOrderTraversal obj = new LevelOrderTraversal();
        obj.createTree();
        levelOrder(obj.root);
    }
}
