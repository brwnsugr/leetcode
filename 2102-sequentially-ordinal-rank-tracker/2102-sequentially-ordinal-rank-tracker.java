class SORTracker {

    PriorityQueue<LocationScore> maxHeap = new PriorityQueue<>((a,b) ->{
        return a.score == b.score ? a.name.compareTo(b.name) : b.score - a.score;
    });
    
    PriorityQueue<LocationScore> minHeap = new PriorityQueue<>((a,b) ->{
        return a.score == b.score ? b.name.compareTo(a.name) : a.score - b.score;
    });
    
    int rank;
    // private 
    public SORTracker() {
        this.rank = 1;
    }
    
    public void add(String name, int score) {
        minHeap.add(new LocationScore(name, score));
        if(minHeap.size() >= rank) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public String get() {
        String res = maxHeap.peek().name;
        rank++;
        minHeap.add(maxHeap.poll());
        return res;
    }
}

class LocationScore {
    public String name;
    public int score;
    public LocationScore(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */