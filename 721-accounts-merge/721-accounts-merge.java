class Solution {
    
    private Set<String> visited = new HashSet<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        
        // with same email -> merge
        // 
        //step 1. build AdjMap
        
        Map<String, List<String>> adjMap = new HashMap<>();
        //step 1. build AdjMap 
        
        for(List<String> account : accounts) {
            String firstName = account.get(1);
            if(!adjMap.containsKey(firstName)) {
                adjMap.put(firstName, new ArrayList<>());
            }
            for(int i = 2; i < account.size(); i++) {
                adjMap.get(firstName).add(account.get(i));
                String name = account.get(i);
                if(!adjMap.containsKey(name)) {
                    adjMap.put(name, new ArrayList<>());
                }   
                adjMap.get(name).add(firstName);
            }
        }
        
        List<List<String>> answer = new ArrayList<>();
        for(List<String> account : accounts) {
            
            
            String accountName = account.get(0);
            String firstEmail = account.get(1);
            
            if(!visited.contains(firstEmail)) {
                visited.add(firstEmail);
                List<String> res = new ArrayList<>();
                res.add(accountName);
                dfs(firstEmail, adjMap, res);
                Collections.sort(res.subList(1, res.size()));
                answer.add(res);
            }   
        }
        
        return answer;
    }
    
    private List<String> dfs(String currName, Map<String, List<String>> adjMap, List<String> res) {
        
        res.add(currName);
        List<String> adjList = adjMap.get(currName);
        for(String next : adjList) {
            if(!visited.contains(next)) {
                visited.add(next);
                dfs(next, adjMap, res);
            }
        }
        return res;
        
    }
}