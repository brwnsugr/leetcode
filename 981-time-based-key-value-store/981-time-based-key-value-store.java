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
        return search(map.get(key), timestamp);
    }
    
    
    private String search(List<Pair<String,Integer>> list, int timestamp) {
        int left = 0;
        int right = list.size() - 1;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(list.get(mid).getValue() == timestamp) {
                left = mid;
                break;
            }
            if(list.get(mid).getValue() > timestamp) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        
        if(left == 0 && timestamp < list.get(left).getValue()) return "";
        if(timestamp < list.get(left).getValue()) return list.get(left - 1).getKey();
        return list.get(left).getKey();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */