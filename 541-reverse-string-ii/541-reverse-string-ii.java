class Solution {
    public String reverseStr(String s, int k) {
        int start = 0;
        int end = k - 1;
        char[] charArr = s.toCharArray();
        if(end >= s.length() - 1) {
            reverse(start, s.length()-1, charArr);
            return new String(charArr);
        }
        
        while(true) {
            end = Math.min(end, s.length() - 1);
            reverse(start, end, charArr);    
            if(end == s.length() -1) break;
            start = start + k + k;
            end = start + k - 1;
        }
        
        return new String(charArr);
        
    }
    
    private void reverse(int start, int end, char[] charArr) {
        while(start < end) {
            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;
            start++;
            end--;
        }
    }
}