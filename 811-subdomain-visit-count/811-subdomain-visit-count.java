class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainCounts = new HashMap<>();
        for(String cpdomain : cpdomains) {
            int i = 0; 
            while(true) {
                int countNumber = 0;
                while(Character.isDigit(cpdomain.charAt(i))) {
                    countNumber = (countNumber * 10) + cpdomain.charAt(i) - '0';
                    i++;
                }
                while(Character.isWhitespace(cpdomain.charAt(i))) i++;
                
                String firstDomain = cpdomain.substring(i);
                updateDomainCount(domainCounts, firstDomain, countNumber);
                break;
            }
        }
        
        List<String> answers = new ArrayList<>();
        buildDomainCount(domainCounts, answers);
        return answers;
    }
    
    private void updateDomainCount(Map<String, Integer> domainCounts, String firstDomain, int countToAdd) {
        List<String> domains = new ArrayList<>();
        domains.add(firstDomain);
        for(int i = 0; i < firstDomain.length(); i++) {
            if(firstDomain.charAt(i) == '.') domains.add(firstDomain.substring(i+1));
        }
        
        for(String domain : domains) {
            domainCounts.put(domain, domainCounts.getOrDefault(domain, 0)+ countToAdd);
        }
        return;
    }
    
    private void buildDomainCount(Map<String, Integer> domainCounts, List<String> answers) {
        for(Map.Entry<String, Integer> domainCount : domainCounts.entrySet()) {
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append(domainCount.getValue() + " " + domainCount.getKey());
            answers.add(strBuilder.toString());
        }
    }
}