class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String, Integer> countMap = new HashMap<>();
        for(String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.count == b.count ? a.word.compareTo(b.word) : b.count-a.count);
        for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        
        List<String> answer = new ArrayList<>();
        while(k >0 && !pq.isEmpty()) {
            Pair pair = pq.poll();
            answer.add(pair.word);
            k--;
        }
        
        return answer;
    }
    
}

class Pair{
    int count;
    String word;
    
    public Pair(String word, int count){
        this.word = word;
        this.count = count;
    }
}
