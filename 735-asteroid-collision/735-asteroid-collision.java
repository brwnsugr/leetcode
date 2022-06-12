class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for(int asteroid : asteroids) {
            st.add(asteroid);
            
            while(st.size() > 1) {
                int currAsteroid = st.pop();
                if(st.peek() > 0 && currAsteroid < 0) {
                    if(Math.abs(currAsteroid) == st.peek()) {
                        st.pop();
                    }
                    else if(Math.abs(currAsteroid) > st.peek()) {
                        st.pop();
                        st.add(currAsteroid);
                    }
                    else {
                        break;
                    }
                }
                else {
                    st.add(currAsteroid);
                    break;
                }
            }
            
        }
        if(st.size() == 0) return new int[0];
        int[] ans = new int[st.size()];
        
        for(int i = ans.length -1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        
        return ans;
    }
}