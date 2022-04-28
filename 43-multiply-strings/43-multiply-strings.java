class Solution {
    public String multiply(String num1, String num2) {
        // TC: O(N*N), SC: O(N)
        //. "11" ->1, "22"
        //. "22" -> 1
        //   new int[4]
        //   22  -> from the end digit of any number, multiply with each digit of the other number, each digit is from end to start, after the iteration ended, move on to end to (end - 1) and multiply digits from end of digit of other number 
        //. 22
        //  242
        // 100 100 -> 10000
        int len1 = num1.length();
        int len2 = num2.length();
        int[] multipliedDigits = new int[len1 + len2];        
        // from the end of digit, iterate 
        
        for(int i = len1-1; i >= 0; i--) {
            int startDigit = num1.charAt(i) - '0';
            for(int j = len2-1; j >= 0; j--) {
                int digitToMultiply = num2.charAt(j) - '0';
                // calcaulte each digit to place
                int idx = i + j + 1;
                int value = (startDigit * digitToMultiply) + multipliedDigits[idx];
                multipliedDigits[idx] = value % 10;
                int carry = value / 10;
                multipliedDigits[idx - 1] += carry;                
            }
        }
        
        int start = multipliedDigits[0] == 0 ? 1 : 0;
        if(multipliedDigits[start] == 0) return "0";
        StringBuilder strBuilder = new StringBuilder();
        for(int i = start; i < multipliedDigits.length; i++) {
            strBuilder.append(multipliedDigits[i]);
        }
        return new String(strBuilder);
    }
}