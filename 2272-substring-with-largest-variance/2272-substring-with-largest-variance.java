class Solution {
    public int largestVariance(String s) {
        int answer = 0;
        
        for(char i = 'a'; i <= 'z'; i++) {
            for(char j = 'a'; j <= 'z'; j++) {
                if(i == j) continue;
                
                
                char[] strArr = s.toCharArray();
                for(int k = 0; k < 2; k++) {
                    int count1 = 0;
                    int count2 = 0;
                    for(char c : strArr) {
                        if(c == i) count1++;
                        if(c == j) count2++;
                        if(count1 < count2) {
                            count1 = 0;
                            count2 = 0;
                        }
                        
                        if(count1 > 0 && count2 > 0) {
                            
                            answer = Math.max(answer, count1 - count2);
                        }
                    }
                    
                    reverse(strArr);
                }
                
            }
        }
        
        
        return answer;
    }
    
    private void reverse(char[] chArr) {
        int len = chArr.length;
        // char[] chArr = s.toCharArray();
        for(int i = 0; i < len/2; i++){
            char temp = chArr[len-i-1];
            chArr[len-i-1] = chArr[i];
            chArr[i] = temp;
        }
    }
}