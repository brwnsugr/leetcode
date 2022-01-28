class LRUCache {

  Map<Integer, DNode> m;
  private int capacity;
  private int currentSize;
  private DNode head, tail;

  public LRUCache(int capacity) {
    this.m = new HashMap<>();
    this.capacity = capacity;
    this.currentSize = 0;

    head = new DNode();
    tail = new DNode();
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    DNode curr = m.get(key);

    if(curr == null) {
      return -1;
    }
    else{
      moveToHead(curr);
      return curr.value;
    }
  }

  private void addNode(DNode node) {
    node.prev = head;
    node.next = head.next;
    
    head.next.prev = node;
    head.next = node;
  }

  private void moveToHead(DNode node) {
    DNode nodeToAdd = node;

    DNode prev = node.prev;
    DNode next = node.next;
    prev.next = next;
    next.prev = prev;

    nodeToAdd.prev = head;
    nodeToAdd.next = head.next;

    head.next.prev = nodeToAdd;
    head.next = nodeToAdd;
  }

  private DNode popTail() {
    if(tail.prev == null) return null;
    else {
      DNode ret = tail.prev;
      DNode nodeToRemove = tail.prev;
      DNode prev = nodeToRemove.prev;
      DNode next = nodeToRemove.next;

      prev.next = next;
      next.prev = prev;
      return ret;
    }
  }

  public void put(int key, int value) {
    DNode curr = m.get(key);
    
    if(curr == null) {
      DNode newNode = new DNode();
      newNode.key = key;
      newNode.value = value;
      
      m.put(key, newNode);
      addNode(newNode);
      
      if(currentSize < capacity) {
        currentSize++;
      }
      else {
        DNode lastNode = popTail();
        m.remove(lastNode.key);
      }
    }
    else {
      curr.value = value;
      moveToHead(curr);
    }
  }
}

class DNode {

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