import java.util.Map.Entry;

class AutocompleteSystem {

  private String prefix;
  private TrieNode root;
  public AutocompleteSystem(String[] sentences, int[] times) {
    root = new TrieNode();
    prefix = "";
    for(int i = 0; i < sentences.length; i++) {
      add(sentences[i], times[i]);
    }
  }
  
  private void add(String input, int count) {
    TrieNode curr = root;
    for(char c : input.toCharArray()) {
      TrieNode next = curr.children.get(c);
      if(next == null) {
        next = new TrieNode();
        curr.children.put(c, next);
      }
      curr = next;
      curr.counts.put(input, curr.counts.getOrDefault(input, 0) + count);
    }
  }

  public List<String> input(char c) {
    if(c == '#') {
      add(prefix, 1);
      prefix="";
      return new ArrayList<>();
    }
    prefix += c;
    
    TrieNode curr = root;
    
    for(char ch : prefix.toCharArray()) {
      TrieNode next = curr.children.get(ch);
      if(next == null) {
        return new ArrayList<>();
      }
      curr = next;
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
    
    List<String> res = new ArrayList<>();
    int n = 0;
    for(Entry<String, Integer> entry : curr.counts.entrySet()) {
      pq.add(new Pair(entry.getKey(), entry.getValue()));

    }
    
    while(!pq.isEmpty() && n < 3) {
      res.add(pq.poll().s);
      n++;
    }
    return res;
  }
  
  class Pair{
    int c;
    String s;
    public Pair(String s, int c) {
      this.c = c;
      this.s = s;
    }
  }
    
  class TrieNode {

  Map<String, Integer> counts;
  Map<Character, TrieNode> children;
  public TrieNode() {
    children = new HashMap<>();
    counts = new HashMap<>();
  }

}
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */