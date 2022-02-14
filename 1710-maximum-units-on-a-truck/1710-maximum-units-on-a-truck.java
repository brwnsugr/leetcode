class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,new Comparator<int[]>(){
            @Override
            public int compare(int[] t1, int[] t2) {
                return t2[1] - t1[1];
            }
        });
        int answer = 0;
        for(int i = 0; i < boxTypes.length; i++) {
            if(truckSize == 0) break;
            int[] box = boxTypes[i];
            if(box[0] <= truckSize) {
                truckSize -= box[0];
                answer += (box[0] * box[1]);
            }
            else {
                answer += (truckSize * box[1]);
                truckSize = 0;
            }
            
            
        }
        
        return answer;
    }
}