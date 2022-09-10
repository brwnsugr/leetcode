class TimeMap {
    
    Map<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair<String, Integer>> pairs = map.get(key);
        return search(pairs, timestamp);
    }
    
    private String search(List<Pair<String, Integer>> list, int timestamp) {
        int left = 0;
        int right = list.size() - 1;
        
        while(left < right) {
            int mid = left + (right - left + 1) / 2;
            
            if(timestamp >= list.get(mid).getValue().intValue()) {
                left = mid;
            }
            else {
                right = mid - 1;
            }
        }
        
        return list.get(left).getValue().intValue() <= timestamp ? list.get(left).getKey() : "";
    }
    
    // love -> (high, 10), (low, 20)
    // get, love, 5
    // get, love, 10 (high)
    // get, love, 15 (high)
    // get, love, 20 (low)
    // get, love, 20(low)
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */