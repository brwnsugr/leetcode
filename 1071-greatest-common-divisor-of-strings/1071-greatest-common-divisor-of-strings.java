class Solution {
    public String gcdOfStrings(String str1, String str2) {  //str1 "ABCABC", str2 "ABC" -> 
        String concatStr = str1 + str2;
        String reverseConcatStr = str2 + str1;
        if(!concatStr.equals(reverseConcatStr)) return "";
        int gcd = getGCD(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }
    
    
    private int getGCD(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    
    
}