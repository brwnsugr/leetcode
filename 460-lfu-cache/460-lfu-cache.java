class LFUCache {

    private int capacity;
    private int size;
    private int minFrequency;
    private Map<Integer, Node> cache;
    private Map<Integer, DoulbyLinkedList> freqMap;
    
    public LFUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        else {
            int val = cache.get(key).value;
            //update node
            updateNode(cache.get(key));
            return val;
        }
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (cache.containsKey(key)) {
            Node n = cache.get(key);
            n.value = value;
            updateNode(n);
        }
        else {
            size++;
            if(size > capacity) {
                DoulbyLinkedList minList = freqMap.get(minFrequency);
                Node nodeToDelete = minList.removeTail();
                cache.remove(nodeToDelete.key);
                size--;
            }
            minFrequency = 1;
            Node newNode = new Node(key, value);
            DoulbyLinkedList currList = freqMap.getOrDefault(1, new DoulbyLinkedList());
            currList.addNode(newNode);
            freqMap.put(1, currList);
            cache.put(key, newNode);
        }
    }
    
    private void updateNode(Node node) {
        DoulbyLinkedList currList = freqMap.get(node.freq);
        currList.removeNode(node);
        if(currList.size == 0 && node.freq == minFrequency) {
            minFrequency++;
        }
        node.freq++;
        if(!freqMap.containsKey(node.freq)) {
            freqMap.put(node.freq, new DoulbyLinkedList());
        }
        freqMap.get(node.freq).addNode(node);
    }
    
    private static class Node{
        
        int key, value, freq;
        
        Node prev, next;
        public Node() {
            
        }
        
        public Node(int key, int val) {
            this.key = key;
            this.value = val;
            this.freq = 1;
        }
        
    }
    
    
    private static class DoulbyLinkedList{
        Node head;
        Node tail;
        int size;
        
        public DoulbyLinkedList(){
            this.head = new Node();
            this.tail = new Node();
            head.next = tail;
            tail.prev = head;
        }
        
        public void addNode(Node node) {
            // node.next = head;
            // head = node;
            // size++;
            Node after = head.next;
            after.prev = node;
            node.next = after;
            head.next = node;
            node.prev = head;
            size++;
        }
        
        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        public Node removeTail() {
            if (size > 0) {
                Node tailNode = tail.prev;
                removeNode(tailNode);
                return tailNode;
            }
            return null;
        }
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */