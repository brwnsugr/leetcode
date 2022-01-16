class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        for(int i = 0; i < len/2; i++) {
            int complement = len - i - 1;
            char temp = s[i];
            s[i] = s[complement];
            s[complement] = temp;
        }
    }
}