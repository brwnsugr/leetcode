class TimeMap {
    
    Map<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        System.out.println("start ");
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
        int right = list.size();
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            // if(timestamp == list.get(mid).getValue()) {
            //     left = mid;
            //     break;
            // }
            if(timestamp >= list.get(mid).getValue().intValue()) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        
        if(right == 0) return "";
        return list.get(right - 1).getKey();
    }
    
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */