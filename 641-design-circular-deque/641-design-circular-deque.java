class MyCircularDeque {
    // Rear
    //. [3,1,2] 
    LinkedList<Integer> container;
    int currentSize;
    int maxSize;

    public MyCircularDeque(int k) {
        container = new LinkedList<Integer>();
        currentSize = 0;
        maxSize = k;
    }
    
    public boolean insertFront(int value) {
        if(currentSize == maxSize) return false;
        else {
            container.addFirst(value);
            currentSize++;
        } 
        return true;
    }
    
    public boolean insertLast(int value) {
        if(currentSize == maxSize) return false;
        else {
            container.addLast(value);
            currentSize++;
        }
        return true;
    }
    
    public boolean deleteFront() {
        if(currentSize == 0) return false;
        else {
            container.removeFirst();
            currentSize--;
            return true;
        }
    }
    
    public boolean deleteLast() {
        if(currentSize == 0) return false;
        else {
            container.removeLast();
            currentSize--;
            return true;
        }
    }
    
    public int getFront() {
        if(currentSize == 0) return -1;
        else return container.getFirst();
    }
    
    public int getRear() {
        if(currentSize == 0) return -1;        
        else return container.getLast();
    }
    
    public boolean isEmpty() {
        return currentSize == 0;
    }
    
    public boolean isFull() {
        return currentSize == maxSize;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */