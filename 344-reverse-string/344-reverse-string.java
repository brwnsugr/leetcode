class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        for(int i = 0; i <= len/2; i++) {
            if(i == len/2 && len % 2 == 0) break;
            int complement = len - i - 1;
            char temp = s[i];
            s[i] = s[complement];
            s[complement] = temp;
        }
    }
}