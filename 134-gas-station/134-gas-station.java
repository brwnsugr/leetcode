class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        int totalBalance = 0;
        int balance = 0;
        int res = 0;
        for(int i = 0; i < len; i++) {
            balance += gas[i] - cost[i];
            totalBalance += gas[i] - cost[i];
            if(balance < 0) {
                res = i + 1;
                balance = 0;
            }
        }
        return totalBalance >= 0 ? res : -1;
    }
}