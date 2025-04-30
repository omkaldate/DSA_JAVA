package JUSPAY.HackethonA;
import java.util.*;

class Node {
    String label;
    List<Node> children;
    Node parent;
    int ancestorLocked, descendantLocked, userID;
    boolean isLocked;

    Node(String name, Node parentNode) {
        this.label = name;
        this.parent = parentNode;
        this.ancestorLocked = 0;
        this.descendantLocked = 0;
        this.userID = 0;
        this.isLocked = false;
        this.children = new ArrayList<>();
    }

    void addChildren(List<String> childLabels, Node parentNode) {
        for (String childLabel : childLabels) {
            this.children.add(new Node(childLabel, parentNode));
        }
    }
}

class LockingTree {
    private Node root;
    private Map<String, Node> labelToNode;
    private List<String> outputLog;

    LockingTree(Node treeRoot) {
        this.root = treeRoot;
        this.labelToNode = new HashMap<>();
        this.outputLog = new ArrayList<>();
    }

    Node getRoot() {
        return root;
    }

    void fillLabelToNode(Node currentNode) {
        if (currentNode == null) return;
        labelToNode.put(currentNode.label, currentNode);
        for (Node child : currentNode.children) {
            fillLabelToNode(child);
        }
    }

    void updateDescendant(Node currentNode, int value) {
        for (Node child : currentNode.children) {
            child.ancestorLocked += value;
            updateDescendant(child, value);
        }
    }

    boolean checkDescendantsLocked(Node currentNode, int id, List<Node> lockedNodes) {
        if (currentNode.isLocked) {
            if (currentNode.userID != id) {
                return false;
            }
            lockedNodes.add(currentNode);
        }
        if (currentNode.descendantLocked == 0) return true;

        for (Node child : currentNode.children) {
            if (!checkDescendantsLocked(child, id, lockedNodes)) {
                return false;
            }
        }
        return true;
    }

    boolean lockNode(String label, int id) {
        Node targetNode = labelToNode.get(label);

        if (targetNode.isLocked) return false;

        if (targetNode.ancestorLocked != 0 || targetNode.descendantLocked != 0) return false;

        Node currentNode = targetNode.parent;
        while (currentNode != null) {
            currentNode.descendantLocked++;
            currentNode = currentNode.parent;
        }

        updateDescendant(targetNode, 1);
        targetNode.isLocked = true;
        targetNode.userID = id;

        return true;
    }

    boolean unlockNode(String label, int id) {
        Node targetNode = labelToNode.get(label);

        if (!targetNode.isLocked) return false;
        if (targetNode.userID != id) return false;

        Node currentNode = targetNode.parent;
        while (currentNode != null) {
            currentNode.descendantLocked--;
            currentNode = currentNode.parent;
        }

        updateDescendant(targetNode, -1);
        targetNode.isLocked = false;

        return true;
    }

    boolean upgradeNode(String label, int id) {
        Node targetNode = labelToNode.get(label);

        if (targetNode.isLocked) return false;
        if (targetNode.ancestorLocked != 0 || targetNode.descendantLocked == 0) return false;

        List<Node> lockedDescendants = new ArrayList<>();
        if (!checkDescendantsLocked(targetNode, id, lockedDescendants)) return false;

        for (Node lockedDescendant : lockedDescendants) {
            unlockNode(lockedDescendant.label, id);
        }

        lockNode(label, id);
        return true;
    }

    void processQueries(List<Object[]> queries) {
        for (Object[] query : queries) {
            int opcode = (int) query[0];
            String nodeLabel = (String) query[1];
            int userId = (int) query[2];

            switch (opcode) {
                case 1:
                    outputLog.add(lockNode(nodeLabel, userId) ? "true" : "false");
                    break;
                case 2:
                    outputLog.add(unlockNode(nodeLabel, userId) ? "true" : "false");
                    break;
                case 3:
                    outputLog.add(upgradeNode(nodeLabel, userId) ? "true" : "false");
                    break;
            }
        }
    }

    void printOutputLog() {
        for (String result : outputLog) {
            System.out.println(result);
        }
    }
}

public class Main {



    public static Node buildTree(Node root, int numChildren, List<String> nodeLabels) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int startIndex = 1;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (startIndex >= nodeLabels.size()) continue;

            List<String> tempChildrenLabels = new ArrayList<>();

            for (int i = startIndex; i < Math.min(startIndex + numChildren, nodeLabels.size()); i++) {
                tempChildrenLabels.add(nodeLabels.get(i));
            }

            currentNode.addChildren(tempChildrenLabels, currentNode);
            startIndex += numChildren;

            for (Node child : currentNode.children) {
                queue.offer(child);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numNodes = sc.nextInt();
        int numChildren = sc.nextInt();
        int numQueries = sc.nextInt();
        sc.nextLine();

        List<String> nodeLabels = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            nodeLabels.add(sc.nextLine());
        }

        Node rootNode = new Node(nodeLabels.get(0), null);
        rootNode = buildTree(rootNode, numChildren, nodeLabels);

        LockingTree lockingTree = new LockingTree(rootNode);
        lockingTree.fillLabelToNode(lockingTree.getRoot());

        List<Object[]> queries = new ArrayList<>();
        for (int i = 0; i < numQueries; i++) {
            String[] parts = sc.nextLine().split(" ");
            int opcode = Integer.parseInt(parts[0]);
            String nodeLabel = parts[1];
            int userId = Integer.parseInt(parts[2]);
            queries.add(new Object[]{opcode, nodeLabel, userId});
        }

        lockingTree.processQueries(queries);
        lockingTree.printOutputLog();
    }
}