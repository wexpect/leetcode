 Total Accepted: 2425 Total Submissions: 20985 My Submissions
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.




public class LRUCache {
    
    //Solu 1: LinkedHashMap
    
    
    //Solu 2: write the code by myself
    private HashMap<Integer, Node> map;
    
    private Node head;
    private Node tail;
    public int capacity;
    
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        
        head = null;
        tail = null;
        this.capacity = capacity; // capacity must be >= 1
    }
    
    public int get(int key) {
        if( map.containsKey(key) ){
            Node n = map.get(key);
            moveToTail( n );
            return n.value;
        }
        else
            return -1;
    }
    
    public void set(int key, int value) {
        if( map.containsKey( key) ){
            Node n = map.get( key );
            n.value = value;
            moveToTail( n );
        }
        else{
            if( map.size() == capacity ){
                map.remove( head.key );
                removeHead();
            }    
        
            Node n = new Node(key, value);
            map.put(key, n);
            addToTail( n );
        }
    }
    
    public void moveToTail(Node n){
        if( n.next == null)
            return;
        else if( n.pre == null){
            Node next = n.next;
            
            head = next;
            next.pre = null;
        }
        else{
            Node pre = n.pre;
            Node next = n.next;
            pre.next = next;
            next.pre = pre;
        }
                      
        tail.next = n;
        n.pre = tail;
        n.next = null;
        tail = n;
    }
    
    public void removeHead(){
        if( head.next == null){
            head = null;
            tail = null;
        }
        else{
            head = head.next;
            head.pre = null;
        }
    }
    
    public void addToTail(Node n){
        if( head == null){
            head = n;
            tail = head;
        }
        else{
            tail.next = n;
            n.pre = tail;
            tail = n;
        }
    }
    
    
    public class Node{
        public int key;
        public int value;
        
        public Node next;
        public Node pre;
        
        public Node(int k, int v){
            key = k;
            value = v;
            
            next = null;
            pre = null;
        }
        
    }
    
}