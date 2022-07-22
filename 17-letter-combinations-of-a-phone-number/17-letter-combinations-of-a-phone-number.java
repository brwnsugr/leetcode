class Solution {
    
    private char[][] numberBook = new char[][]{
        {' '},
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'},
        {'a', 'b', 'c'},
    };
    
    private List<String> answer = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return new ArrayList<>();
        recursion(0, digits, new StringBuilder());
        return answer;
    }
    
    private void recursion(int currIdx, String digits, StringBuilder strBuilder) {
        if(currIdx == digits.length()) {
            answer.add(new String(strBuilder));
            return;
        }
        
        else {
            int currNumber = (int) digits.charAt(currIdx) - '0';
            char[] currDials = numberBook[currNumber-1];
            for(char c : currDials) {
                strBuilder.append(c);
                recursion(currIdx+1, digits, strBuilder);
                strBuilder.deleteCharAt(strBuilder.length() - 1);
            }
        }
    }
}