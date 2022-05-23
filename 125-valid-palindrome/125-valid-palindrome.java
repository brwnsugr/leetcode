class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder strBuilder = new StringBuilder();
        s = s.toLowerCase();
        for(int i = 0; i < s.length(); i++) {
            if(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                strBuilder.append(s.charAt(i));
            }
        }
        
        s = new String(strBuilder);
        
        int l = 0;
        int r = s.length() - 1;
        
        while(l < r) {
            char leftCh = s.charAt(l);
            char rightCh = s.charAt(r);
            if(leftCh != rightCh) return false;
            l++; r--;
        }
        
        return true;
    }
}