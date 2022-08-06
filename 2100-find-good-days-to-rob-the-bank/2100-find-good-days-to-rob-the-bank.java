class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int[] inc = new int[security.length];
        int[] dec = new int[security.length];
        
        int incCount = 0;
        for(int i = 1; i < security.length; i++) {
            if(security[i] <= security[i-1]) {
                incCount++;
            }
            else {
                incCount = 0;
            }
            
            inc[i] = incCount;
        }
        
        
        int decCount = 0;
        for(int i = security.length - 2; i >= 0; i--) {
            if(security[i] <= security[i+1]) {
                decCount++;
            }
            else {
                decCount = 0;
            }
            dec[i] = decCount;
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = time; i < security.length - time; i++) {
            if(inc[i] >= time && dec[i] >= time) list.add(i);
        }
        
        
        return list;
    }
}