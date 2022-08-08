class Solution {
    
    String answer;
    
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        StringBuilder strBuilder = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(!st.isEmpty() && st.peek().key == curr) {
                st.peek().freq++;
            }
            else {
                st.add(new Pair(curr, 1));
            }
        
            if(st.peek().freq == k) {
                st.pop();
            }
        }
        
        while(!st.isEmpty()) {
            Pair pair = st.pop();
            while(pair.freq > 0) {
                strBuilder.append(pair.key);
                pair.freq--;
            }
        }
        
        answer = strBuilder.reverse().toString();
        return answer;
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