class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        
        int plateCount = 0;
        int[] answer = new int[queries.length];
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '*') plateCount++;
            else m.put(i, plateCount);
        }
        
        int idx = 0;
        for(int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int plates = 0;
            
            Map.Entry<Integer, Integer> startCandle = m.ceilingEntry(start);
            Map.Entry<Integer, Integer> endCandle = m.floorEntry(end);
            
            if(startCandle != null && endCandle != null) {
                plates = Math.max(0, endCandle.getValue() - startCandle.getValue());
            }
            answer[idx] = plates;
            idx++;
        }
        
        
        return answer;
    }
}