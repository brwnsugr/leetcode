class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> rightMostIdxMap = new HashMap<>();
        int idx = 0;
        for(char c : s.toCharArray()) {
            rightMostIdxMap.put(c, idx++);
        }
        List<Integer> partitions = new ArrayList<>();
        int maxIdx = 0;
        for(int i = 0; i < s.length(); i++) {
            maxIdx = Math.max(maxIdx, rightMostIdxMap.get(s.charAt(i)));
            while( i < maxIdx) {
                maxIdx = Math.max(maxIdx, rightMostIdxMap.get(s.charAt(i)));
                i++;
            }
            partitions.add(maxIdx+1);
        }
        
        for(int i = partitions.size() -1; i > 0; i--) {
            int diff = partitions.get(i) - partitions.get(i-1);
            partitions.set(i, diff);
        }
        return partitions;
    }
}