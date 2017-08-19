import java.util.*;

class Node{
    int key;
    int value;
    Node prev;
    Node next;
    
    public Node(int key, int value){
        this.key   = key;
        this.value = value;
        this.next  = null;
        this.prev  = null;
    }
}

public class LRUCache {

    private int size = 0;
    private Node head = null;
    private Node tail = null;
    private HashMap<Integer, Node> map = null;
    
    public LRUCache(int capacity) {
        this.size = capacity;
        this.head = null;
        this.tail = null;
        map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            makeRecent(key, false);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.size()==size && !map.containsKey(key)){
            Node lastNode = tail;
            tail = tail.prev;
            if(tail!=null) tail.next = null;
            map.remove(lastNode.key);
        }
        
        if(!map.containsKey(key)) {
        		Node node = new Node(key, value);
            map.put(key, node);
            makeRecent(key, true);
        }   
        else {
        		Node node = map.get(key);
        		node.value = value;
            map.put(key, node);
            makeRecent(key, false);
        }
    }
    
    private void makeRecent(int key, boolean isNew){
        Node node = map.get(key);
        
        if(isNew){
            if(head == null){
                head = node;
                tail = node;
            }
            else{
                node.next = head;
                node.prev = null;
                head.prev = node;
                head = node;
            }
        }
        else{
            if(node != head && node!=null){
                Node prev = node.prev;
                Node next = node.next;
                
                if(prev!=null) prev.next = next;
                if(next!=null) next.prev = prev;
                
                node.next = head;
                node.prev = null;
                head.prev = node;
                head = node;
                
                if(tail == node) tail = prev;
            }
        }
    }
    
    public static void main(String[] args) {
    		LRUCache obj = new LRUCache(2);
    		
    		
    	
    		obj.put(2, 1);
    		obj.put(1, 1);
    		obj.put(2, 3);
    		obj.put(4, 1);
    		
    		System.out.println(obj.get(1));
    		System.out.println(obj.get(2));
    		
    		/*System.out.println(obj.get(1));
    		
    		System.out.println(obj.get(2));
    		obj.put(4, 4);
    		System.out.println(obj.get(1));
    		System.out.println(obj.get(3));
    		System.out.println(obj.get(4));*/
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */