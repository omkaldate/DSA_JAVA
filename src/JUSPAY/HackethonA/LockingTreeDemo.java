package JUSPAY.HackethonA;

import java.util.*;

class TreeNode {
    String name;
    int lockedBy = 0; // 0 means unlocked
    int lockedCount = 0;
    List<TreeNode> children = new ArrayList<>();
    TreeNode parent = null;
    Set<TreeNode> lockedDescendants = new HashSet<>();

    public TreeNode(String name) {
        this.name = name;
    }
}

class LockingTreeSystem {
    Map<String, TreeNode> nameToTreeNode = new HashMap<>();

    public synchronized boolean lock(String name, int id) {
        TreeNode node = nameToTreeNode.get(name);
        if (node == null) return false;

        if (node.lockedCount > 0 || !node.lockedDescendants.isEmpty()) {
            return false;
        }

        node.lockedCount++;
        if (node.lockedCount > 1) {
            node.lockedCount--;
            return false;
        }

        TreeNode parent = node.parent;
        while (parent != null) {
            if (parent.lockedCount > 0 || !parent.lockedDescendants.isEmpty()) {
                node.lockedCount--;
                TreeNode rollback = node.parent;
                while (rollback != parent) {
                    rollback.lockedDescendants.remove(node);
                    rollback = rollback.parent;
                }
                return false;
            }
            parent.lockedDescendants.add(node);
            parent = parent.parent;
        }

        node.lockedBy = id;
        System.out.println("Node " + name + " locked by ID " + id);
        return true;
    }

    public void addNode(TreeNode node, TreeNode parent) {
        node.parent = parent;
        if (parent != null) {
            parent.children.add(node);
        }
        nameToTreeNode.put(node.name, node);
    }
}

public class LockingTreeDemo {
    public static void main(String[] args) {
        LockingTreeSystem system = new LockingTreeSystem();

        // Build a small tree
        TreeNode root = new TreeNode("A");
        TreeNode child1 = new TreeNode("B");
        TreeNode child2 = new TreeNode("C");

        system.addNode(root, null);
        system.addNode(child1, root);
        system.addNode(child2, root);

        // Threads attempting to lock the same node
        Runnable lockTask1 = () -> {
            boolean result = system.lock("B", 1);
            System.out.println("Thread 1 lock result: " + result);
        };

        Runnable lockTask2 = () -> {
            boolean result = system.lock("B", 2);
            System.out.println("Thread 2 lock result: " + result);
        };

        Thread t1 = new Thread(lockTask1);
        Thread t2 = new Thread(lockTask2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final lockedBy for B: " + system.nameToTreeNode.get("B").lockedBy);
    }
}
