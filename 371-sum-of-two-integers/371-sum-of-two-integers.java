class Solution {
    public int getSum(int a, int b) {
        int ans = 0;
        while( b != 0) {
            ans = a ^ b;
            int carry = (a&b) << 1;
            a = ans;
            b = carry;
        }
        return a;
    }
}