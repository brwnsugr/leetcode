class LRUCache {
    
    private int currentSize;
    private int capacity;
    DNode head;
    DNode tail;
    Map<Integer, DNode> cacheMap;
    

    public LRUCache(int capacity) {
        this.currentSize = 0;
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        DNode node = cacheMap.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)) {
            DNode node = cacheMap.get(key);
            node.val = value;
            moveToHead(node);
        }
        else {
            DNode newNode = new DNode();
            newNode.key = key;
            newNode.val = value;
            
            cacheMap.put(key, newNode);
            addNode(newNode);
            currentSize++;
            if(currentSize > capacity) {
                DNode tail = popTail();
                cacheMap.remove(tail.key);
                currentSize--;
            }
        }
        
    }
    
    private DNode popTail() {
        DNode res = tail.prev;
        removeNode(res);
        return res;
    }
    
    private void moveToHead(DNode node) {
        removeNode(node);
        addNode(node);
    }
    
    private void addNode(DNode node) {
        node.prev = head;
        node.next = head.next;
        
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(DNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    
    
    
    
}

class DNode {
    int val;
    int key;
    DNode prev;
    DNode next;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */