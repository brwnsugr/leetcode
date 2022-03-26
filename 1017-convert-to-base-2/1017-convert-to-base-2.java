class Solution {
    public String baseNeg2(int n) {
                
        if(n == 0) return "0";
        int base = -2;
        StringBuilder strBuilder = new StringBuilder();
        while(n != 0) {
            int r = n % base;
            n /= base;
            if(r < 0) {
                r += -base;
                n += 1;
            }
            strBuilder.insert(0, r);            
            
        }
        return strBuilder.toString();
    }
}