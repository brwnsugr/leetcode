class Solution {
    
    List<String> answers;
    private static Map<Integer, char[]> dialMap = new HashMap<>(){{
        put(2, new char[]{'a','b','c'});
        put(3, new char[]{'d','e','f'});
        put(4, new char[]{'g','h','i'});
        put(5, new char[]{'j','k','l'});
        put(6, new char[]{'m','n','o'});
        put(7, new char[]{'p','q','r','s'});
        put(8, new char[]{'t','u','v'});
        put(9, new char[]{'w','x','y','z'});}};
    
    
    public List<String> letterCombinations(String digits) {
        //2: [abc], 3: [def]
        answers = new ArrayList<>();
        if(digits.length() == 0) return answers;
        recursive(digits, 0, new StringBuilder());
        return answers;
    }
    
    private void recursive(String digits, int count, StringBuilder strBuilder) {
        if(count == digits.length()) {
            answers.add(new String(strBuilder));
            return;
        }
        int currNum = digits.charAt(count) - '0';
        char[] chars = dialMap.get(currNum);
        for(char c : chars) {
            strBuilder.append(c);
            recursive(digits, count + 1, strBuilder);
            strBuilder.deleteCharAt(strBuilder.length()-1);
        }
    }
}