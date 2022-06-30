class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> userMap = new HashMap<>();
        
        for(int i = 0; i < username.length; i++){
            userMap.putIfAbsent(username[i], new ArrayList<>());
            userMap.get(username[i]).add(new Pair(website[i], timestamp[i]));
        }
        
        Map<String, Integer> countMap = new HashMap<>();
        String res = "";
        int currentFreq = 0;
        for(Map.Entry<String, List<Pair>> entry : userMap.entrySet()) {
            
            Set<String> visited = new HashSet<>();
            List<Pair> userWebs = entry.getValue();
            
            Collections.sort(userWebs, (a,b) -> a.time - b.time);
            
            int size = userWebs.size();
            
            for(int i = 0; i < size - 2; i++) {
                for(int j = i + 1; j < size - 1; j++) {
                    for(int k = j + 1; k < size; k++) {
                        StringBuilder strBuilder = new StringBuilder();
                        strBuilder.append(userWebs.get(i).web).append(' ');
                        strBuilder.append(userWebs.get(j).web).append(' ');
                        strBuilder.append(userWebs.get(k).web);
                        String concatWeb = new String(strBuilder);
                        if(!visited.contains(concatWeb)) {
                            countMap.put(concatWeb, countMap.getOrDefault(concatWeb, 0) + 1);
                            visited.add(concatWeb);
                        }
                        
                        if(res.equals("") || countMap.get(concatWeb) > currentFreq 
                           ||(countMap.get(concatWeb) == currentFreq && res.compareTo(concatWeb) >= 0)) {
                            res = concatWeb;
                            currentFreq = countMap.get(concatWeb);
                        }
                    }
                }
            }
        }
        
        return Arrays.asList(res.split(" "));
    }
}


class Pair{
    int time;
    String web;
    
    public Pair(String web, int time) {
        this.web = web;
        this.time = time;
    }
}