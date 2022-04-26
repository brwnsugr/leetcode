


class MyHashMap {
    private int[] map;
    private static int HASH_KEY_SIZE = 2000;
    List<Bucket> buckets;
    
    public MyHashMap() {
        buckets = new ArrayList<>();
        for(int i = 0; i < HASH_KEY_SIZE; i++) {
            buckets.add(new Bucket());
        }
    }
    
    private int getHashKey(int key) {
        return key % HASH_KEY_SIZE;
    }
    
    public void put(int key, int value) {
        int hashKey = getHashKey(key);
        buckets.get(hashKey).putPair(key, value);
    }
    
    public int get(int key) {
        int hashKey = getHashKey(key);
        return buckets.get(hashKey).getValueFromKey(key);
    }
    
    public void remove(int key) {
        int hashKey = getHashKey(key);
        buckets.get(hashKey).removePair(key);
    }
    
    static class Pair<U,V>{
        public U first;
        public V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }
    
    static class Bucket {
        private List<Pair<Integer, Integer>> innerList = new ArrayList<>();
        
        
        public Bucket(){
            innerList = new ArrayList<Pair<Integer,Integer>>();
        }
        
        public Integer getValueFromKey(int key) {
            for(Pair<Integer, Integer> pair : innerList) {
                if(pair.first.equals(key)) return pair.second;
            }
            return -1;
        }
        
        public void putPair(int key, int value) {
            boolean isFound = false;
            for(Pair pair : innerList) {
                if(pair.first.equals(key)) {
                    pair.second = value;
                    isFound = true;
                    break;
                }
            }
            if(!isFound) {
                innerList.add(new Pair(key, value));
            }
            return;
        }
        
        public void removePair(int key) {
            int idx = 0;
            for(Pair pair : innerList) {
                if(pair.first.equals(key)) {
                    innerList.remove(idx);
                    break;
                }
                idx++;
            }
            return;
        }
        
    }
    
}



/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */