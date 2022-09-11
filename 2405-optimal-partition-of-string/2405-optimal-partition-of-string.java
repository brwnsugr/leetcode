class Solution {
    public int partitionString(String s) {
        int res = 1;
        boolean[] visited = new boolean[26];
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(visited[curr-'a']) {
                visited = new boolean[26];
                res++;
            }
            visited[curr-'a'] = true;
        }
        
        return res;
    }
}