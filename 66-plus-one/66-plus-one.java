class Solution {
    public int[] plusOne(int[] digits) {
        
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            int num = carry + digits[i];
            if(i == digits.length - 1) num++;
            carry = num / 10;
            int r = num % 10;
            digits[i] = r;
        }
        
        if(carry > 0) {
            return buildExtraDigitsArr(digits, carry);
        }
        else return digits;
    }
    
    private int[] buildExtraDigitsArr(int[] digits, int carry) {
        int[] res = new int[digits.length + 1];
        
        res[0] = carry;
        for(int i = 1; i < res.length; i++) {
            res[i] = digits[i-1];
        }
        
        return res;
    }
}