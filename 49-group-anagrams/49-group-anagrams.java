class Solution {
    Map<String, String> unionMap = new HashMap<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        for(String str : strs) {
            unionMap.put(str, str);
        }
        
        for(int i = 0; i < strs.length-1; i++) {
            for(int j = i+1; j < strs.length; j++) {
                if(isSameAnagramGroup(strs[i], strs[j])) {
                    union(strs[i], strs[j]);
                }
            }
        }
        
        Map<String, List<String>> groupMap = new HashMap<>();
        
        for(String str : strs) {
            String root = find(str);
            if(!groupMap.containsKey(root)) groupMap.put(root, new ArrayList<>());
            groupMap.get(root).add(str);
        }
        
        for(Map.Entry<String, List<String>> entry : groupMap.entrySet()) {
            answer.add(entry.getValue());
        }
        
        return answer;
    }
    
    private boolean isSameAnagramGroup(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int[] charCounts = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            char charS1 = s1.charAt(i);
            char charS2 = s2.charAt(i);
            
            charCounts[charS1-'a']++;
            charCounts[charS2-'a']--;
        }
        
        for(int count : charCounts) {
            if(count != 0) return false;
        }
        
        return true;
    }
    
    
    private void union(String a, String b) {
        String parentA = find(a);
        String parentB = find(b);
        if(!parentA.equals(parentB)) unionMap.put(parentB, parentA);
    }
    
    
    private String find(String a) {
        if(a.equals(unionMap.get(a))) return a;
        return find(unionMap.get(a));
    }
}