class Solution {
    Map<Integer, Integer> visitedMap = new HashMap<>();
    public int[] prisonAfterNDays(int[] cells, int n) {
        
        int cycle = 0;
        int startIdx = 0;
        for(int i = 0; i <= n; i++) {
            int val = covertToBinary(cells);
            if(!visitedMap.containsKey(val)) {
                // System.out.println("cells is " + cells[0] +cells[1] +cells[2]+cells[3]+cells[4]+cells[5]+cells[6]+cells[7] + " and i " + i);
                visitedMap.put(val, i);
            }
            else {
                cycle = i - visitedMap.get(val);
                startIdx = visitedMap.get(val);
                break;
            }
            cells = convert(cells).clone();
            
        }
        if(cycle != 0) n = startIdx + (n-startIdx) % cycle;
        
        for (Map.Entry<Integer, Integer> m : visitedMap.entrySet()){
            if(m.getValue() == n) {
                return binaryToCells(m.getKey());
            }
        } 
        return null;
    }
    
    private int[] convert(int[] cells) {
        int[] convertedCell = new int[8];
        for(int i = 1; i < 7; i++) {
            if(cells[i-1] == cells[i+1]) convertedCell[i] = 1;
        }
        return convertedCell;
    }
    
    private int covertToBinary(int[] convertedCell) {
        int ret = 0;
        for(int i = convertedCell.length-1; i >= 0; i--) {
            int temp = convertedCell[i] == 1 ? (int) Math.pow(2, 7-i) : 0;
            ret += temp;
        }
        return ret;
    }
    
    private int[] binaryToCells(int num) {
        int start = 7;
        int[] ret = new int[8];
        while(start >= 0) {
            int digitNum =(int) Math.pow(2, start);
            if(num >= digitNum && num != 0) {
                num -= digitNum;
                ret[7-start] = 1;
            }
            start--;
        }
        return ret;
    }
    
    
}