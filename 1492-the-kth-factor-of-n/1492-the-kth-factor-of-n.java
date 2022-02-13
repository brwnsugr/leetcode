class Solution {
    public int kthFactor(int n, int k) {
        int count = 0;
        int factor = -1;
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                factor = i;
                count++;
            }
            if(k==count) break;
        }
        return count < k ? -1 : factor;
    }
}