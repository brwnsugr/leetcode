class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int num : hand) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        Arrays.sort(hand);
        
        for(int num : hand) {
            if(countMap.get(num) == 0) continue; 
            for(int i = 1; i < groupSize; i++) {
                if(!countMap.containsKey(num + i) || countMap.get(num + i) == 0)  return false;
                countMap.put(num + i, countMap.get(num + i) - 1);
            }
            countMap.put(num, countMap.get(num) - 1);
        }
        
        return true;
    }
}