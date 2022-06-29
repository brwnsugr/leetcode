class LRUCache {
    
    private DNode head;
    private DNode tail;
    private int currentSize;
    private int capacity;
    private Map<Integer, DNode> cacheMap;

    public LRUCache(int capacity) {
        head = new DNode();
        tail = new DNode();
        
        head.next = tail;
        tail.prev = head;
        
        this.currentSize = 0;
        this.capacity = capacity;
        
        cacheMap = new HashMap<>();
    }
    
    public int get(int key) {
        DNode node = cacheMap.get(key);
        
        if(node == null) return -1;
        else {
            moveToHead(node);
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        DNode node = cacheMap.get(key);
        
        if(node == null) {
            currentSize++;
            node = new DNode();
            node.key = key;
            node.value = value;
            cacheMap.put(key, node);
            
            addNode(node);
            if(currentSize > capacity) {
                DNode lastNode = popTail();
                removeNode(lastNode);
                cacheMap.remove(lastNode.key);
                currentSize--;
            }
        }
        else {
            node.value = value;
            moveToHead(node);
        }
    }
    
    private void moveToHead(DNode node) {
        removeNode(node);
        addNode(node);
    }
    
    private void addNode(DNode node) {
        DNode tmp = head.next;
        head.next = node;
        node.prev = head;
        
        node.next = tmp;
        tmp.prev = node;
    }
    
    private void removeNode(DNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private DNode popTail() {
        return tail.prev;
    }
}

class DNode{
    int key;
    int value;
    DNode next;
    DNode prev;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */