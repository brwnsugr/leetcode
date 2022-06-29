class Solution {
    
    
    
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> userMap = new HashMap<>();
        for(int i = 0; i < username.length; i++) {
            userMap.putIfAbsent(username[i], new ArrayList<>());
            userMap.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }
        
        Map<String, Integer> countMap = new HashMap<>();
        String answer = "";
        int currentSize = 0;
        
        for(Map.Entry<String, List<Pair>> entry : userMap.entrySet()) {
            List<Pair> list = entry.getValue();
            
            Collections.sort(list, (a, b) -> a.time - b.time);
            int len = list.size();
            Set<String> s = new HashSet<>();
            for(int i = 0; i < len - 2; i++) {
                for(int j = i + 1; j < len - 1; j++) {
                    for(int k = j + 1; k < len; k++) {
                        StringBuilder strBuilder = new StringBuilder();
                        strBuilder.append(list.get(i).web);
                        strBuilder.append(' ');
                        strBuilder.append(list.get(j).web);
                        strBuilder.append(' ');
                        strBuilder.append(list.get(k).web);
                        String concatWeb = new String(strBuilder);
                        
                        if(!s.contains(concatWeb)) {
                            countMap.put(concatWeb, countMap.getOrDefault(concatWeb, 0) + 1);
                            s.add(concatWeb);
                        }
                            
                        
                        if(answer.equals("") || currentSize < countMap.get(concatWeb) 
                           || (currentSize == countMap.get(concatWeb) && answer.compareTo(concatWeb) >= 0)) {
                            answer = concatWeb;
                            currentSize = countMap.get(concatWeb);
                        }
                    }
                }
            }

            
            
            
        }
        List<String> ans = Arrays.asList(answer.split(" "));
        // Collections.sort(ans);
        return ans;
    }
}

class Pair{
    public int time;
    public String web;
    public Pair(int time, String web){
        this.time = time;
        this.web = web;
    }
}