package Tree;

import java.util.Scanner;

public class BinaryTree {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public TreeNode root;
    Scanner sc = new Scanner(System.in);

    public void createTree() {
        System.out.println("Enter the value of root node");
        int data = sc.nextInt();

        root = new TreeNode(data);
        fillTree(root);
    }

    private void fillTree(TreeNode root) {
        System.out.println("Do you want to enter left of " + root.data);
        boolean isLeft = sc.nextBoolean();

        if(isLeft) {
            System.out.println("Enter value of left node " + root.data);
            int data = sc.nextInt();
            TreeNode node = new TreeNode(data);
            root.left = node;
            fillTree(root.left);
        }

        System.out.println("Do you want to enter right of " + root.data);
        boolean isRight = sc.nextBoolean();

        if(isRight) {
            System.out.println("Enter value of right node " + root.data);
            int data = sc.nextInt();
            TreeNode node = new TreeNode(data);
            root.right = node;
            fillTree(root.right);
        }
    }
}