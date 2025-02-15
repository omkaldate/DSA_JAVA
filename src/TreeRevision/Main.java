package TreeRevision;

public class Main {
    public static void main(String[] args) {
        BinaryTree obj = new BinaryTree();
        obj.creatrTree();

        obj.pInorder(obj.root);
    }
}
