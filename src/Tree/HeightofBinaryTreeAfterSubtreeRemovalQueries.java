package Tree;

public class HeightofBinaryTreeAfterSubtreeRemovalQueries extends BinaryTree{
    private int[] level = new int[1000001];
    private int[] height = new int[100001];
    private int[] levelMaxHt = new int[100001];
    private int[] levelSecondMaxHt = new int[100001];

    private  int findHeight(TreeNode root, int l) {
        if (root == null) {
            return 0;
        }

        level[root.data] = l;
        height[root.data] = Math.max(findHeight(root.left, l + 1), findHeight(root.right, l + 1)) + 1;

        if (levelMaxHt[l] < height[root.data]) {
            levelSecondMaxHt[l] = levelMaxHt[l];
            levelMaxHt[l] = height[root.data];
        } else if (levelSecondMaxHt[l] < height[root.data]) {
            levelSecondMaxHt[l] = height[root.data];
        }

        return height[root.data];
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        findHeight(root, 0);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int node = queries[i];
            int L = level[node];

            int tempResult = L+ (levelMaxHt[L] == height[node] ? levelSecondMaxHt[L] : levelMaxHt[L])-1 ;
            result[i] = tempResult;
        }
        return result;
    }



    public static void main(String[] args) {

    }
}
