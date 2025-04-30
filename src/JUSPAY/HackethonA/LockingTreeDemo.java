package JUSPAY.HackethonA;

import java.util.*;

class TreeNode {
    String name;
    int lockedBy;
    int lockedCount;
    List<TreeNode> childs = new ArrayList<>();
    TreeNode parent;
    Set<TreeNode> lockedDescendents = new HashSet<>();
}

class LockingTreeSystem {
    Map<String, TreeNode> nameToTreeNodeMapping = new HashMap<>();

    boolean lock(String name, int id) {
        TreeNode r = nameToTreeNodeMapping.get(name);
        if (r.lockedCount > 0 || r.lockedDescendents.size() > 0) return false;

        r.lockedCount++;
        if (r.lockedCount > 1) {
            r.lockedCount--;
            return false;
        }

        TreeNode par = r.parent;
        while (par != null) {
            if (par.lockedCount > 0 || r.lockedDescendents.size() > 0) {
                r.lockedCount--;
                TreeNode par1 = r.parent;
                while (par1 != par) {
                    par1.lockedDescendents.remove(r);
                    par1 = par1.parent;
                }
                return false;
            }
            par.lockedDescendents.add(r);
            par = par.parent;
        }

        r.lockedBy = id;
        return true;
    }
}



public class LockingTreeDemo {
    public static void main(String[] args) {

    }
}
