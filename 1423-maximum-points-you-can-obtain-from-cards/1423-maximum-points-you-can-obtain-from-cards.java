class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int answer = Integer.MIN_VALUE;
        int totalPts = 0;
        for(int point : cardPoints) totalPts += point;
               
        if(k >= cardPoints.length) return totalPts;
        
        int l = 0;
        int r = cardPoints.length - k;
        int partialSum = 0;
        
        for(int i = l; i < r; i++) partialSum += cardPoints[i];
        
        while(r < cardPoints.length) {
            
            answer = Math.max(answer, totalPts - partialSum);
            
            partialSum += cardPoints[r];
            partialSum -= cardPoints[l];
            
            r++;
            l++;
        }
        answer = Math.max(answer, totalPts - partialSum);
        
        // 1(l),2,3(r) k = 1 -> , partial Sum = 5.   3
        
        return answer;
    }
}