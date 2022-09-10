class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0; 
        int totalCost = 0;
        int len = gas.length;
        for(int i = 0; i < len; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        
        if(totalCost > totalGas) return -1;
        
        int balance = 0;
        int res = 0;
        for(int i = 0; i < len; i++) {
            balance += gas[i] - cost[i];
            if(balance < 0) {
                res = i + 1;
                balance = 0;
            }
        }
        return res;
    }
}