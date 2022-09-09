class MedianFinder {
    private PriorityQueue<Integer> smallHeap;
    private PriorityQueue<Integer> largeHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a,b) -> b-a);
        largeHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smallHeap.add(num);
        if(smallHeap.size() - largeHeap.size() > 1 
           || (!largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek())
          ) {
            largeHeap.add(smallHeap.poll());
        }
        
        if(largeHeap.size() - smallHeap.size() > 1) {
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        if(smallHeap.size() > largeHeap.size()) {
            return smallHeap.peek();
        }
        else if(largeHeap.size() > smallHeap.size()) {
            return largeHeap.peek();
        }
        else {
            return (double) (largeHeap.peek() + smallHeap.peek()) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */