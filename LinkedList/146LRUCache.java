package LinkedList;

import java.util.HashMap;

class LRUCache {
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head; // for Most Recently Used
    private final Node tail; // for Least Recently Used

//[HEAD] <-> [Node1] <-> [Node2] <-> ... <-> [NodeN] <-> [TAIL]

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insertAtHead(node); //keep it as most recently value
        return node.value;
    }
    
    public void put(int key, int value) {
        // check whether it exists
        if(map.containsKey(key)){
            Node node = map.get(key); // get the node
            node.value = value; // update the value
            remove(node);
            insertAtHead(node); //make it the most recent used value
        }
        else{
            if(map.size() == capacity){ // if we are running out of capacity
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAtHead(newNode); //most recent used value
        }
    }
    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void insertAtHead(Node node){
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
