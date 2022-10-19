package companies.airtel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

public class BinaryTreeTest {
    Node root;

    public void addNode(int num) {
        if (root == null) {
            Node node = new Node(num);
            root = node;
        } else {
            Node node = new Node(num);
            Node pos = root;
            Node prev = root;
            while (pos != null) {
                if (num < pos.data) {
                    prev = pos;
                    pos = pos.left;
                } else if (num > pos.data) {
                    prev = pos;
                    pos = pos.right;
                } else {
                    throw new IllegalArgumentException(num + " : is already present in tree");
                }
            }
            if (num < prev.data) {
                prev.left = node;
            } else {
                prev.right = node;
            }
        }
    }

    public boolean search(int num) {
        Node pos = root;
        while (pos != null) {
            if (num == pos.data) {
                return true;
            } else if (num < pos.data) {
                pos = pos.left;
            } else {
                pos = pos.right;
            }
        }
        return false;
    }

    public int height(Node root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public void levelOrderTraversal1(Node pos){
        Queue<Node> queue = new LinkedList<>();
        queue.add(pos);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            System.out.print(current.data+ " ");

            //enqueue left child
            if(current.left != null){
                queue.add(current.left);
            }
            //enqueue right child
            if(current.right != null){
                queue.add(current.right);
            }
        }
    }
    public void levelOrderTraversal2(Node pos){
        Queue<Node> queue = new LinkedList<>();
        queue.add(pos);
        queue.add(null);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current == null){
                if(queue.isEmpty()){
                    return;
                }
                queue.add(null);
                System.out.println();
                continue;
            }
            System.out.print(current.data+" ");
            // enqueue left child
            if(current.left != null){
                queue.add(current.left);
            }
            //enqueue right child
            if(current.right != null){
                queue.add(current.right);
            }
        }
    }
    public void leftSideView(Node root){
        if(root == null) return;
        List<Integer> list = new ArrayList<>();
        leftSideViewUtil(list,root);
    }

    private void leftSideViewUtil(List<Integer> list, Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int levelSize = q.size();
            for(int i=0;i<levelSize;i++){
                Node current = q.poll();
                if(i==0) System.out.print(current.data+" ");
                if(current.left != null) q.offer(current.left);
                if(current.right != null) q.offer(current.right);
            }
        }
    }

    //L N R
    public void inOrderRecurrsiveTraverse(Node pos) {
        if (pos != null) {
            inOrderRecurrsiveTraverse(pos.left);
            System.out.println(pos.data);
            inOrderRecurrsiveTraverse(pos.right);
        }
    }

    //N L R
    public void preOrderRecurrsiveTraverse(Node pos) {
        if (pos != null) {
            System.out.println(pos.data);
            preOrderRecurrsiveTraverse(pos.left);
            preOrderRecurrsiveTraverse(pos.right);
        }
    }

    //L R N
    public void postOrderRecurrsiveTraverse(Node pos) {
        if (pos != null) {
            postOrderRecurrsiveTraverse(pos.left);
            postOrderRecurrsiveTraverse(pos.right);
            System.out.println(pos.data);
        }
    }

}

class Driver {
    public static void main(String[] args) {
        BinaryTreeTest bt = new BinaryTreeTest();
        bt.addNode(9);
        bt.addNode(8);
        bt.addNode(6);
        bt.addNode(15);
        bt.addNode(13);
        bt.addNode(14);

        //bt.inOrderRecurrsiveTraverse(bt.root);
        //System.out.println(bt.search(151));
        //System.out.println(bt.height(bt.root));
        //bt.levelOrderTraversal2(bt.root);
        bt.leftSideView(bt.root);
    }
}
