class LRUCache {

    
    private int capacity;
    private int currentCapacity;
    private Map<Integer, DNode> map;
    private DNode head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.currentCapacity = 0;
        this.map = new HashMap<>();
        this.head = new DNode();
        this.tail = new DNode();
        tail.next = null;
        head.prev = null;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            DNode node = map.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        DNode node = map.get(key);
        
        if(node == null) {
            node = new DNode();
            node.key = key;
            node.value = value;
            map.put(key, node);
            addToHead(node);
            currentCapacity++;
            if(currentCapacity > capacity) {
                DNode tailNode = tail;
                map.remove(tailNode.prev.key);
                removeTail();
                currentCapacity--;
            }
            
        }
        else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
        
        
    private void removeTail() {
        DNode nodeToRemove = tail.prev;
        removeNode(nodeToRemove);
    }
        
    private void moveToHead(DNode node) {
        removeNode(node);
        addToHead(node);
    }
    
    private void removeNode(DNode node) {
        DNode prev = node.prev;
        DNode next = node.next;
        
        prev.next = next;
        next.prev = prev;
    }
        
           
    static class DNode {
        DNode next;
        DNode prev;
        int value;
        int key;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

