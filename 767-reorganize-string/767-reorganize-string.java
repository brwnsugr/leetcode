class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);
        
        int[] counts = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < counts.length; i++) {
            if(counts[i] > 0) pq.add(
                new Pair( (char)(i+'a'), counts[i])
            );
        }
        
        String answer = "";
        Pair temp = new Pair('#', -1);
        
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            answer += curr.key;
            curr.freq--;
            
            if(temp.freq > 0) {
                pq.add(temp);
            }
            temp = curr;
        }

        return s.length() == answer.length() ? answer : "";
    }
}


class Pair {
    public char key;
    public int freq;
    
    public Pair(char key, int freq) {
        this.key = key;
        this.freq = freq;
    } 
}