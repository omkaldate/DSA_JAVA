package SegmentTree.usingNode;

public class sTree {
    class Node{
        int startInd;
        int endInd;
        int data;
        Node left;
        Node right;

        Node(int s, int e){
            this.startInd = s;
            this.endInd = e;
        }
    }

    Node root;

    sTree(int[]arr) {
        this.root = constructsTree(arr, 0, arr.length-1);
    }

    private Node constructsTree(int[]arr, int start, int end){
        if(start == end){
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        Node node = new Node(start, end);
        int mid = start+(end-start)/2;

        node.left = constructsTree(arr,start,mid);
        node.right = constructsTree(arr,mid+1, end);
        node.data = node.left.data + node.right.data;

        return node;
    }

    public int query(int s, int e){
        return this.query(root,s,e);
    }
    public int query(Node node, int s, int e){
        if(node.startInd >= s && node.endInd <= e) return node.data;
        if(node.startInd > e || node.endInd < s) return 0;
        else{
            return query(node.left, s, e) + query(node.right,s,e);
        }
    }

    public void update(int ind, int val){
        this.update(root, ind, val);
    }

    public int update(Node node, int ind, int val){
        if(node.startInd == node.endInd && node.startInd == ind){
            node.data = val;
            return val;
        }

        if(node.startInd > ind || node.endInd < ind){
            return node.data;
        }

        node.data = update(node.left, ind,val) + update(node.right,ind , val);
        return node.data;
    }
}
