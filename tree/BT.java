package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;
}

class BST {
    Node root;

    public void addNode(int num) {
        if (root == null) {
            Node node = new Node();
            node.data = num;
            node.left = null;
            node.right = null;
            root = node;
        }
        Node prev = null;
        Node pos = root;
        while (pos != null) {
            prev = pos;
            if (pos.data == num)
                return;
            else if (num > pos.data)
                pos = pos.right;
            else
                pos = pos.left;
        }
        Node node = new Node();
        node.data = num;
        if (node.data > prev.data)
            prev.right = node;
        else
            prev.left = node;
    }

    public void inOrederecurrsivetraverse(Node pos) {
        if (pos != null) {
            inOrederecurrsivetraverse(pos.left);
            System.out.println(pos.data);
            inOrederecurrsivetraverse(pos.right);
        }
    }

    public void preOrderrecurrsivetraverse(Node pos) {
        if (pos != null) {
            System.out.println(pos.data);
            preOrderrecurrsivetraverse(pos.left);
            preOrderrecurrsivetraverse(pos.right);
        }
    }

    public void postOrderrecurrsivetraverse(Node pos) {
        if (pos != null) {
            postOrderrecurrsivetraverse(pos.left);
            postOrderrecurrsivetraverse(pos.right);
            System.out.println(pos.data);
        }
    }

    public void levelOrderTraversal(Node pos) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(pos);
        while (!queue.isEmpty()) {

            /* poll() removes the present head */
            Node current = queue.poll();
            System.out.print(current.data + " ");

            /*Enqueue left child */
            if (current.left != null) {
                queue.add(current.left);
            }

            /*Enqueue right child */
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public void levelOrderTraversal2(Node pos) {
        Queue<Node> q = new LinkedList<>();
        q.add(pos);
        q.add(null);
        while (!q.isEmpty()) {
            Node current = q.poll();
            //System.out.print(current.data);
            if(current == null){
                if(q.isEmpty()){
                    return;
                }
                q.add(null);
                System.out.println();
                continue;
            }
            System.out.print(current.data + " ");
            if(current.left != null){
                q.add(current.left);
            }
            if(current.right != null){
                q.add(current.right);
            }
        }
    }

    public boolean search(int num) {
        Node pos = root;
        while (pos != null) {
            if (num == pos.data)
                return true;
            else if (num > pos.data)
                pos = pos.right;
            else
                pos = pos.left;
        }
        return false;
    }

    public Node recurrsiveSearch(Node pos, int num) {
        if (pos == null)
            return null;
        if (pos.data == num)
            return pos;
        else if (num > pos.data)
            return recurrsiveSearch(pos.right, num);
        else
            return recurrsiveSearch(pos.left, num);
    }

    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public int size(Node root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

//    public void printLeftView(Node root){
//        ArrayList<Node> list = new ArrayList();
//        list.add(root);
//        printLeftViewUtil(root,list,0);
//
//        for(Node current : list){
//            System.out.print(current.data + " ");
//        }
//    }
//    private void printLeftViewUtil(Node root, ArrayList list, int level){
//        if(root == null){
//            return;
//        }
//        if(list.get(level) == null){
//            list.set(level,root);
//        }
//        printLeftViewUtil(root.left,list,level+1);
//        printLeftViewUtil(root.right,list,level+1);
//    }

    public List<Integer> rightSideView(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        rightViewUtil(list, root);
        return list;
    }
    private void rightViewUtil(List<Integer> list, Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Node cur = q.poll();
                if (i == 0) list.add(cur.data);
                if (cur.right != null) q.offer(cur.right);
                if (cur.left != null) q.offer(cur.left);
            }
        }
    }

    //public List<Integer> leftSideView(Node root) {
    public void leftSideView(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        //if (root == null) return list;
        if (root == null) return;
        leftViewUtil(list, root);
        //return list;
    }
    private void leftViewUtil(List<Integer> list, Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Node cur = q.poll();
                //if (i == 0) list.add(cur.data);
                if (i == 0) System.out.print(cur.data+ " ");
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
        }
    }
}

public class BT {

    public static void main(String[] args) {
        BST bt = new BST();
        bt.addNode(4);
        bt.addNode(3);
        bt.addNode(5);
        bt.addNode(2);
        bt.addNode(1);
        bt.addNode(6);
        bt.addNode(7);
        //bt.preOrderrecurrsivetraverse(bt.root);
        //bt.inOrederecurrsivetraverse(bt.root);
        //bt.postOrderrecurrsivetraverse(bt.root);
        //bt.levelOrderTraversal2(bt.root);
//		bt.addNode(10);
//		bt.addNode(15);
//		bt.addNode(5);
//		bt.addNode(2);
//		bt.addNode(6);
//		bt.addNode(30);
//		bt.addNode(60);
//		System.out.println(bt.root.data);      // 20
//		System.out.println(bt.root.left.data); // 10
//		System.out.println(bt.root.right.data); // 50
//		System.out.println(bt.root.left.left.data); // 5
//		System.out.println(bt.root.left.right.data); // 15
//		System.out.println(bt.root.left.left.left.data); // 2
//		System.out.println(bt.root.left.left.right.data); // 6
//		System.out.println(bt.root.right.left.data);  // 30
//		System.out.println(bt.root.right.right.data); // 60
//		System.out.println(bt.search(20));
//		System.out.println(bt.search(50));
//		System.out.println(bt.search(10));
//		System.out.println(bt.search(15));
//		System.out.println(bt.search(5));
//		System.out.println(bt.search(2));
//		System.out.println(bt.search(6));
//		System.out.println(bt.search(30));
//		System.out.println(bt.search(60));
//		System.out.println(bt.search(1));
//		System.out.println(bt.search(54));
        //System.out.println("Height : " + bt.height(bt.root));
//        List list = bt.rightSideView(bt.root);
//        System.out.println(list);
        bt.leftSideView(bt.root);
    }
}
