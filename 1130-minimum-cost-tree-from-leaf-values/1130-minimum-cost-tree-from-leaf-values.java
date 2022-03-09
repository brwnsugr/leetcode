class Solution {
    public int mctFromLeafValues(int[] arr) {
        //L-N-R
        // we pick adjcent pair of element where its product value is minimum
        // everytime we get minimium product value, add to the answer; 
        // after picking that pair, remove the smaller element. (as we calculate the max roof node value with its maximum )
        //arr size = N, N + (N-1) + N-2 + .... + 1 => TC: O(N^2), SC: O(N)
        
        
        List<Integer> leafList = new ArrayList<>();
        for(int num : arr) leafList.add(num);
        
        int answer = 0;
        
        while(leafList.size() != 1) {
            int l = 0;
            int r = 0;
            int productVal = 0;
            int minProductVal = Integer.MAX_VALUE;
            for(int i = 0; i < leafList.size() - 1; i++) {
                productVal = leafList.get(i) * leafList.get(i+1);
                if(productVal < minProductVal) {
                    minProductVal = productVal;
                    l = i;
                    r = i+1;
                }
            }
            answer += minProductVal;
            if(leafList.get(l) > leafList.get(r)) leafList.remove(r);
            else leafList.remove(l);
        }
        return answer;
    }
}