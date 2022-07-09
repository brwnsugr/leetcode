class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        int i = 0;
        Map<Integer, String[]> indexMap = new HashMap<>();
        for(int j = 0; j < indices.length; j++) {
            indexMap.put(indices[j], new String[]{sources[j], targets[j]});
        }
        
        StringBuilder strBuilder = new StringBuilder();
        
        while(i < s.length()) {
            
            if(indexMap.containsKey(i)) {
                String sourceWord = indexMap.get(i)[0];
                String subStr = s.substring(i, i + sourceWord.length());
                
                if(sourceWord.equals(subStr)) {
                    strBuilder.append(indexMap.get(i)[1]);
                    i += sourceWord.length();
                }
                else {
                    strBuilder.append(s.charAt(i));
                    i++;
                }
            }
            
            else {
                strBuilder.append(s.charAt(i));
                i++;
            }
        }
        
        return new String(strBuilder);
    }
}