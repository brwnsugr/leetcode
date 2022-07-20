class Solution {
    
    private List<String> answer = new ArrayList<>();
    private int pairs;
    
    public List<String> generateParenthesis(int n) {
        pairs = n;
        recursiveGenerate(0, 0, new StringBuilder());
        return answer;
    }
    
    
    private void recursiveGenerate(int openCount, int closeCount, StringBuilder strBuilder) {
        if(openCount == pairs && closeCount == pairs) {
            answer.add(new String(strBuilder));
            return;
        }
        
        if(openCount >= closeCount && openCount < pairs) {
            strBuilder.append('(');
            recursiveGenerate(openCount+1, closeCount, strBuilder);
            strBuilder.deleteCharAt(strBuilder.length() - 1);
        }
        
        if(openCount > closeCount) {
            strBuilder.append(')');
            recursiveGenerate(openCount, closeCount+1, strBuilder);
            strBuilder.deleteCharAt(strBuilder.length() - 1);
        }
    }
}