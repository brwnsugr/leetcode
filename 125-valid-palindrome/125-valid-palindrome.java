class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder strBuilder = new StringBuilder();
        
        for(char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) strBuilder.append(Character.toLowerCase(c));
        }
        

        String sentence = new String(strBuilder);
        int len = sentence.length();
        if(len == 1) return true;
        for(int i = 0; i < len / 2; i++) {
            char left = sentence.charAt(i);
            char right = sentence.charAt(len - i -1);
            if(left != right) return false;
        }
        
        return true;
    }
}