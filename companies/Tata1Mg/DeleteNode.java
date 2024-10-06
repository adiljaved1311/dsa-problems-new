package companies.mongodb;

public class DeleteNode {
    Node head;
    Node end;
    public void deleteAtEnd() {
        if(head == null || head.next == null) {
            head = end = null;
        }else {
            Node pos = head;
            while(pos.next != end) {
                pos = pos.next;
            }
            pos.next = null;
            end = pos;
        }
    }

    public void deleteAtBegin() {
        if(head.next == null) {
            head = end = null;
        }else {
            Node pos = head.next;
            head.next = null;
            head = pos;
        }
    }

    public void deleteAtPosition(int index) {
        Node pos = head;
        Node prev = null;
        for(int i=1; i<=index-2; i++) {
            pos = pos.next;
        }
        prev = pos.next;
        pos.next = prev.next;
        prev.next = null;
    }
}


