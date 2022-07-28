class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        return rowOverlap(rec1, rec2) && colOverlap(rec1, rec2);        
    }
    
    
    private boolean rowOverlap(int[] rec1, int[] rec2) {
        int y1Start = rec1[1];
        int y1End = rec1[3];
        
        int y2Start = rec2[1];
        int y2End = rec2[3];
        
        if(y2End > y1Start && y2Start < y1End) return true;
        if(y1End > y2Start && y1Start < y2End) return true;
        
        return false;
    }
    
    private boolean colOverlap(int[] rec1, int[] rec2) {
        int x1Start = rec1[0];
        int x1End = rec1[2];
        
        int x2Start = rec2[0];
        int x2End = rec2[2];
        
        if(x2End > x1Start && x2Start < x1End) return true;
        if(x1End > x2Start && x1Start < x2End) return true;
        
        return false;
    }
}