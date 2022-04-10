class MyHashSet {
    private Bucket[] buckets;
    private int bucketSize;
    
    public MyHashSet() {
        this.bucketSize = 10000;
        this.buckets = new Bucket[this.bucketSize];
        for (int i = 0; i < this.bucketSize; ++i)
          this.buckets[i] = new Bucket();
    }
    
    private int hash(int key) {
        return (key % this.bucketSize);
    }
    
    public void add(int key) {
        buckets[hash(key)].add(key);
    }
    
    public void remove(int key) {
        buckets[hash(key)].remove(key);
    }
    
    public boolean contains(int key) {
        return buckets[hash(key)].exist(key);
    }
    //Modulo + LinkedList
    
    
    static class Bucket{
        private LinkedList<Integer> container;
        
        public Bucket(){
            container = new LinkedList<Integer>();
        }
        
        public boolean exist(Integer key) {
            int index = this.container.indexOf(key);
            return (index != -1);
        }
        
        public void add(Integer key) {
            int index = this.container.indexOf(key);
            if (index == -1) {
              this.container.addFirst(key);
            }
        }
        
        public void remove(Integer key) {
            this.container.remove(key);
        }
    }
    
        
}




/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */