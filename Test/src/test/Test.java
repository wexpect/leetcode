/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashMap;

/**
 *
 * @author Rui
 */
public class Test {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Test t = new Test(1);
        
        t.set(2,1);                        
        System.out.println( t.get(2) );
        
    }
    
    
    
    //Solu 1: LinkedHashMap
    
    
    //Solu 2: write the code by myself
    private HashMap<Integer, Node> map;
    
    private Node head;
    private Node tail;
    public int capacity;
    
    
    public Test(int capacity) {
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
