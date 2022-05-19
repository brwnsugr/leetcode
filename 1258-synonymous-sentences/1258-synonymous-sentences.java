class Solution {
    
    Map<String, String> unionMap = new HashMap<>();
    List<String> answers = new ArrayList<>();
    
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        // try to generate all the comb of the text using synomyms
        
        // and sort it
        
        // union find -> try to merge all the synonyms. 
        Set<String> words = new HashSet<>();
        for(List<String> synonym : synonyms) {
            for(String word : synonym) {
                unionMap.put(word, word);
                words.add(word);
            }
        }
        
        for(List<String> synonym : synonyms) {
            union(synonym.get(0), synonym.get(1));
        }
        
        Map<String, TreeSet<String>> clusteredMap = new HashMap<>();
        
        for(String word : unionMap.keySet()) {
            if(unionMap.get(word).equals(word)) clusteredMap.put(word, new TreeSet<>());
        }
        
        for(String word : words) {
            String parent = findParent(word);
            clusteredMap.get(parent).add(word);
        }
        
        
        
        String[] textArr = text.split(" ");
        
        List<Integer> replaceIdxList = new ArrayList<>();
        
        for(int i = 0; i <  textArr.length; i++) {
            if(words.contains(textArr[i])) replaceIdxList.add(i);
        }
        
        backTrack(0, replaceIdxList, clusteredMap, textArr);
        
        
        return answers;
    }
    
    
    private void backTrack(int idx, List<Integer> replaceIdxList, Map<String, TreeSet<String>> clusteredMap, String[] textArr) {
        if(idx == replaceIdxList.size()) {
            answers.add(String.join(" ", textArr));
            return;
        }
        
        int replaceIdx = replaceIdxList.get(idx);
        String str = textArr[replaceIdx];
        TreeSet<String> synonyms = clusteredMap.get(findParent(str));
        
        for(String synonym : synonyms) {
            textArr[replaceIdx] = synonym;
            backTrack(idx+1, replaceIdxList, clusteredMap, textArr);
            textArr[replaceIdx] = str;
        }
    }
    
    
    
    private void union(String a, String b) {
        String parentA = findParent(a);
        String parentB = findParent(b);
        if(!parentA.equals(parentB)) unionMap.put(parentA, parentB);
        
    }
    
    private String findParent(String a) {
        if(unionMap.get(a).equals(a)) return a;
        
        unionMap.put(a, findParent(unionMap.get(a)));
        
        return unionMap.get(a);
    }
     
    
    
}