package companies.mongodb;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.addNode(2);
        bst.addNode(4);
        bst.addNode(1);
        bst.addNode(7);
        bst.addNode(3);
        bst.addNode(6);

        bst.inOrder(bst.root);
        System.out.println();
        bst.preOrder(bst.root);
        System.out.println();
        bst.postOrder(bst.root);
        System.out.println();
        System.out.println("Height: "+bst.height(bst.root));
        System.out.println("Size : "+bst.size(bst.root));
        System.out.println("Max : "+bst.max(bst.root));
        System.out.println("Min : "+bst.min(bst.root));

        //bst.levelOrderTraversal(bst.root);
        bst.levelOrderTraversal2(bst.root);
    }
}

class BinarySearchTree{
    class Node{
        int num;
        Node left;
        Node right;
    }
    Node root;
    public void addNode(int num){
        if(root == null){
            Node node = new Node();
            node.num = num;
            root = node;
        }else{
            Node prev = null;
            Node pos = root;
            while(pos != null){
                prev = pos;
                if(num < pos.num){
                    pos = pos.left;
                }else {
                    pos = pos.right;
                }
            }
            Node node = new Node();
            node.num = num;
            if(num < prev.num){
                prev.left = node;
            }else {
                prev.right = node;
            }
        }
    }
    public void levelOrderTraversal(Node pos){
        Queue<Node> queue = new LinkedList<>();
        queue.add(pos);
        while(!queue.isEmpty()){

            // poll() removes the current head
            Node current = queue.poll();
            System.out.print(current.num+" ");

            // enqueue left child
            if(current.left != null)
                queue.add(current.left);

            // enqueue the right child
            if(current.right != null)
                queue.add(current.right);
        }
    }
    // If you want to print level wise data, like in firstline first level data and in second line
    // second level data and so on
    public void levelOrderTraversal2(Node pos){
        Queue<Node> queue = new LinkedList<>();
        queue.add(pos);
        queue.add(null);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current == null){
                if(queue.isEmpty())
                    return;
                queue.add(null);
                System.out.println();
                continue;
            }
            System.out.print(current.num+" ");
            if(current.left != null)
                queue.add(current.left);
            if(current.right != null)
                queue.add(current.right);
        }
    }
    public void inOrder(Node root){ // L N R
        if(root != null){
            inOrder(root.left);
            System.out.print(root.num + " ");
            inOrder(root.right);
        }
    }
    public void preOrder(Node root){ // N L R
        if(root != null){
            System.out.print(root.num + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void postOrder(Node root){ // L R N
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.num +" ");
        }
    }
    public int height(Node root){
        if(root == null)
            return 0;
        return Math.max(height(root.left),height(root.right)+1);
    }
    public int size(Node root){
        if(root == null)
            return 0;
        return (size(root.left)+size(root.right)+1);
    }
    public int max(Node root){
        if(root == null)
            return Integer.MIN_VALUE;
        return Math.max(root.num,Math.max(max(root.left),max(root.right)));
    }
    public int min(Node root){
        if(root == null)
            return Integer.MAX_VALUE;
        return Math.min(root.num,Math.min(min(root.left),min(root.right)));
    }
}
