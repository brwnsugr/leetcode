class Solution {
    public int largestVariance(String s) {
        
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c-'a']++;
        }
        
        int maxVariance = 0;
        
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < 26; j++) {
                if(i == j || freq[i] == 0 || freq[j] == 0) continue;
                
                int remainA = freq[i];
                
                int freqA = 0;
                int freqB = 0;
                for(char c : s.toCharArray()) {
                    if((int) c-'a' == j) freqB++;
                    if((int) c-'a' == i) {
                        freqA++;
                        remainA--;
                    }
                    
                    if(freqA > 0 && freqB > 0) {
                        maxVariance = Math.max(maxVariance, freqB - freqA);
                    }
                    
                    if(freqA > freqB && remainA >= 1) {
                        freqA = 0;
                        freqB = 0;
                    }
                }
            }
        }
        
        return maxVariance;
    }
}