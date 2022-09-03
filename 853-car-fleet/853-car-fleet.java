class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int len = position.length;
        if(len == 1) return 1;
        Stack<Double> st = new Stack<>();
        
        int[][] positionSpeeds = new int[len][2];
        
        for(int i = 0; i < len; i++) {
            positionSpeeds[i][0] = position[i];
            positionSpeeds[i][1] = speed[i];
        }
        
        Arrays.sort(positionSpeeds, (a,b) -> a[0] - b[0]);
        
        double lastPosTimeToDest = (double) (target - positionSpeeds[len-1][0]) / positionSpeeds[len-1][1];
        
        st.add(lastPosTimeToDest);
        
        for(int i = len - 2; i >= 0; i--) {
            double currentTimeToDest = (double) (target - positionSpeeds[i][0]) / positionSpeeds[i][1];
            if(currentTimeToDest > st.peek()) st.add(currentTimeToDest);
        }
        
        
        return st.size();
    }
}