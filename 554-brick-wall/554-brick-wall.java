class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        // 1, 3, 5
        // 3 
        // 1, 4
        // TC: O(n * n)
        Map<Integer, Integer> holeCount = new HashMap<>();
        int layers = wall.size();
        int answer = layers;
        
        
        for(List<Integer> chunkLayer : wall) {
            int holeColumn = 0;
            for(int i = 0; i < chunkLayer.size() - 1; i++) {
                holeColumn += chunkLayer.get(i);
                if(!holeCount.containsKey(holeColumn)) {
                    holeCount.put(holeColumn, 0);
                }
                holeCount.put(holeColumn, holeCount.get(holeColumn) + 1);
            }    
        }
        
        
        for(Map.Entry<Integer, Integer> entry : holeCount.entrySet()) {
            answer = Math.min(answer, layers - entry.getValue());
        }
        
        
        return answer;
    }
}