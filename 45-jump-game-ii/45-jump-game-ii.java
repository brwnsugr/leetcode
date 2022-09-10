class Solution {
    public int jump(int[] nums) {
        int steps = 0;
        int l = 0;
        int r = 0;
        int further = 0;
        
        while(r < nums.length - 1) {
            further = 0;
            for(int i = l; i <= r; i++) further = Math.max(further, i + nums[i]);
            l = r + 1;
            r = further;
            steps++;
        }
        
        return steps;
    }
}