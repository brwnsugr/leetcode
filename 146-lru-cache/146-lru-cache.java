class LRUCache {
    
    private int capacity;
    private int currentSize;
    private Map<Integer, DNode> map = new HashMap<>();
    private DNode head;
    private DNode tail;

    public LRUCache(int capacity) {
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        this.currentSize = 0;
    }
    
    public int get(int key) {
        DNode node = map.get(key);
        if(node == null) return -1;
        else {
            moveToHead(node);
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        DNode node = map.get(key);
        
        if(node == null) {
            node = new DNode();
            node.key = key;
            node.value = value;
            map.put(key, node);
            addNode(node);
            currentSize++;
            
            if(currentSize > capacity) {
                
                DNode lastNode = popTail();
                map.remove(lastNode.key);
                --currentSize;
            }
        }
    
        else {
            node.value = value;
            moveToHead(node);
        }
    }
    
    private void moveToHead(DNode node) {
//         node.prev.next = node.next;
        
//         DNode temp = head.next;
        
//         head.next = node;
//         node.next = temp;
//         node.prev = head;
        removeNode(node);
        addNode(node);
    }
    
    private void addNode(DNode node) {
        DNode temp = head.next;
        head.next = node;
        node.next = temp;
        temp.prev = node;
        node.prev = head;
    }
    
    private void removeNode(DNode node) {
        DNode prev = node.prev;
        DNode next = node.next;
        
        prev.next = next;
        next.prev = prev;
    }
    
    private DNode popTail() {
        DNode lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }
    
    
    
}

class DNode {
    int key;
    int value;
    DNode prev;
    DNode next;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */