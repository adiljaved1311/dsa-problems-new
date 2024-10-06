package companies.mongodb;

public class ReverseLinkedList {
}

class LinkedList{
    Node head;
    public Node reverseLinkedList(){
        Node current = head;
        Node prev = null;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}
class Node{
    int num;
    Node next;
}
