package TreeRevision;

import java.util.Scanner;

public class BinaryTree {
    class treeNode{
        int data;
        treeNode left;
        treeNode right;

        treeNode(int data){
            this.data = data;
        }
    }


    public treeNode root;

    Scanner sc = new Scanner(System.in);

    public void creatrTree(){
        System.out.println("enter the value of root ");
        int data = sc.nextInt();
        root = new treeNode(data);
        fillTree(root);
    }

    private void fillTree(treeNode root){
        System.out.println("want to enter left of " + root.data);
        boolean isLeft = sc.nextBoolean();

        if(isLeft){
            System.out.println("enter value of left of " + root.data);
            int data = sc.nextInt();
            treeNode node = new treeNode(data);
            root.left = node;
            fillTree(root.left);
        }

        System.out.println("want to enter right of " + root.data);
        boolean isRight = sc.nextBoolean();

        if(isRight){
            System.out.println("enter value of right of " + root.data);
            int data = sc.nextInt();
            treeNode node = new treeNode(data);
            root.right = node;
            fillTree(root.right);
        }
    }

    public void pInorder(treeNode root){
        if(root == null) return;

        pInorder(root.left);
        System.out.print(root.data + " ");
        pInorder(root.right);
    }

}
