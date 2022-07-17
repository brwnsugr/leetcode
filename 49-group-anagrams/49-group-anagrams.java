class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        
        // making key as 2 ways : 
        // 1. sort it. (abc, cba) -> abc(sorted!) and key itself
        //
        if(strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> anaMap = new HashMap<>();
        
        for(String s : strs) {
            char[] chArr = s.toCharArray();
            Arrays.sort(chArr);
            String key = String.valueOf(chArr);
            if(!anaMap.containsKey(key)) anaMap.put(key, new ArrayList<>());
            anaMap.get(key).add(s);
        }
        
        return new ArrayList<>(anaMap.values());
        
    }
}