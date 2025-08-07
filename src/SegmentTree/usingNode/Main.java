package SegmentTree.usingNode;

public class Main {
    public static void main(String[] args) {
        int[]arr = {3, 8, 7, 6, -2, -8, 4, 9};

        sTree tree = new sTree(arr);

        int val = tree.query(0,3);
        System.out.println(val);

        tree.update(3, 7);

        int val1 = tree.query(0,3);
        System.out.println(val1);
    }
}
