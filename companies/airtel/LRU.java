package companies.airtel;
import java.util.HashMap;

public class LRU {
    private HashMap<Integer,DoublyNode> cache;
    int capacity;
    DoublyNode left; // least recent used
    DoublyNode right; // most recent used
    LRU(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>();

        left = new DoublyNode(0,0);
        right = new DoublyNode(0,0);

        left.next = right;
        right.prev = left;
    }
    public int get(int key){
        if(cache.containsKey(key)){
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        }else{
            return -1;
        }
    }

    public void put(int key, int val){
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        cache.put(key,new DoublyNode(key,val));
        insert(cache.get(key));
        if(cache.size() > capacity){
            // remove from the list and delete the LRU from the hashmap
            DoublyNode lru = left.next;
            remove(lru);
            cache.remove(key);
        }
    }

    //remove node from list
    public void remove(DoublyNode node) {
        DoublyNode prev = node.prev;
        DoublyNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    // insert node at right
    public void insert(DoublyNode node) {
        DoublyNode prev = this.right.prev;
        DoublyNode next = this.right;

        prev.next = node;
        next.prev = node;

        node.next = next;
        node.prev = prev;
    }

}
class DoublyNode{
    int key;
    int val;
    DoublyNode prev;
    DoublyNode next;

    DoublyNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}
