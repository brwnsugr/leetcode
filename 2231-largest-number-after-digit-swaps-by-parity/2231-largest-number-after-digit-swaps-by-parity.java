class Solution {
    public int largestInteger(int num) {
        String numStr = String.valueOf(num);
        char[] numChars = numStr.toCharArray();
        
        for(int i = 0; i < numChars.length - 1; i++) {
            for(int j = i + 1; j < numChars.length; j++) {
                if(numChars[j] > numChars[i] && (numChars[j] - numChars[i]) % 2 == 0) {
                    char tmp = numChars[j];
                    numChars[j] = numChars[i];
                    numChars[i] = tmp;
                }
            }
        }
        
        StringBuilder strBuilder = new StringBuilder();
        
        for(char c : numChars) strBuilder.append(c);
        
        return Integer.parseInt(new String(strBuilder));
    }
}