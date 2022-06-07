class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        
        char[] strArr = strs[0].toCharArray();
        
        int prefixEnd = strArr.length - 1;
        
        for(int i = 1; i < strs.length; i++) {
            char[] currArr = strs[i].toCharArray();
            prefixEnd = Math.min(prefixEnd, currArr.length-1);
            for(int j = 0; j <= prefixEnd; j++) {
                if(strArr[j] != currArr[j]) {
                    prefixEnd = j - 1;
                    break;
                }
            }
            if(prefixEnd == -1) return "";
        }
        StringBuilder strBuilder = new StringBuilder();
        for(int i = 0; i <= prefixEnd; i++) {
            strBuilder.append(strArr[i]);
        }
        return new String(strBuilder);
    }
}