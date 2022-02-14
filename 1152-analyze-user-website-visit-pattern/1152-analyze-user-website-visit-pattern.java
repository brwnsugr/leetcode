class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        /*
        joe: [(home, 2), (about, 3), career]
        james: [home, cart, maps, home]
        mary: [home, about, career]
        first of all, we store the each name of the user and its visitied website and timestamp as pair
        */
        
        /*
        home, about, career : 2
        home cart maps: 1
        home, cart, home : 1
        home, maps, home: 1
        cart, maps, 
        */
        
        /*
        
        */
        String res = "";
        
        int len = username.length;
        
        Map<String, List<Pair>> userMap = new HashMap<>();
        for(int i = 0; i < len; i++) {
            userMap.putIfAbsent(username[i], new ArrayList<>());
            userMap.get(username[i]).add(new Pair(website[i], timestamp[i]));
        }
        
        Map<String, Integer> countMap = new HashMap<>();
        
        for(String key : userMap.keySet()) {
            Set<String> s = new HashSet<>();
            
            List<Pair> userWebs = userMap.get(key);
            
            Collections.sort(userWebs, (a,b) -> (a.time - b.time));
            int size = userWebs.size();
            for(int i = 0; i < size-2; i++) {
                for(int j = i+1; j < size - 1; j++) {
                    for(int k = j+1; k < size; k++) {
                        StringBuilder strBuilder = new StringBuilder();
                        strBuilder.append(userWebs.get(i).web).append(" ").append(userWebs.get(j).web).append(" ").append(userWebs.get(k).web);
                        String temp = new String(strBuilder);
                        if(!s.contains(temp)) {
                            countMap.put(temp, countMap.getOrDefault(temp, 0) + 1);
                            s.add(temp);
                        }
                        
                        if(res == "" || countMap.get(temp) > countMap.get(res) || (countMap.get(temp) == countMap.get(res) && res.compareTo(temp) >= 0)) {
                            res = temp;
                        }
                        
                    }
                }
            }
            
            
        }
        
        List<String> ans = Arrays.asList(res.split(" "));
        return ans;
        
    }
    
    static class Pair{
        String web;
        int time;
        
        public Pair(String web, int time){
            this.web = web;
            this.time = time;
        }
    }
}

