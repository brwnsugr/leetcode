class Solution {
    public String reverseWords(String s) {
        if(s.length() == 1) return s;
        s = s.trim();
        String[] wordsList = s.split("\\s+");
        StringBuilder strBuilder = new StringBuilder();

        for(int i = wordsList.length-1; i>=0 ; i--) {
            strBuilder.append(wordsList[i]);
            if(i != 0) strBuilder.append(' ');
        }
        
        return strBuilder.toString();
    }
}