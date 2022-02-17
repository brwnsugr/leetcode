class Solution {
    public int sumSubarrayMins(int[] arr) {
        int len = arr.length;
        int[] left = new int[len];
        int[] right = new int[len];
        for(int k = 0; k < len; k++) {
            left[k] = k+1;
            right[k] = len - k;
        }
        
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i< len; i++) { // s = [1,2], left = [1, 2, 1, 1]
            while(!s.isEmpty() && arr[s.peek()] > arr[i]) {
                s.pop();
            }
            left[i] = s.isEmpty() ? i + 1 : (i - s.peek()); 
            s.push(i);
        }
        
        s = new Stack<>();
        for(int i = 0; i< len; i++) { // s = [1,2], left = [1, 2, 1, 1]
            while(!s.isEmpty() && arr[s.peek()] > arr[i]) {
                right[s.peek()] = i - s.peek();
                s.pop();
            }
            s.push(i);
        }
        
        long ans = 0;
        long mod = (int)1e9 + 7;
        for(int i = 0; i < len; i++) {
            ans = (ans + (long) arr[i] * left[i] * right[i]) % mod;
        }
    
        return (int)ans;
    }
}