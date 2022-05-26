class Solution {
    
    private int answer = 0;
    Map<Integer, Integer> treeMap = new HashMap<>();
    public int pathSum(int[] nums) {
        // 1->[ {1: 3}]
        // 2-> [{1:5}, {2:1}]
        for(int num : nums) {
            treeMap.put( num / 10, num % 10);
        }
        
        preOrder(nums[0] / 10, 0);
        return answer;
    }
    
    private void preOrder(int root, int sum) {
        if(!treeMap.containsKey(root)) {
            return;
        }
        
        sum += treeMap.get(root);
        
        int depth = root / 10;
        int pos = root % 10;
        
        int left = (depth + 1) * 10 + (pos * 2 - 1);
        int right = (depth + 1) * 10 + (pos * 2);
        if(!treeMap.containsKey(left) && !treeMap.containsKey(right)) {
            answer += sum;
        }
        else {
            preOrder(left, sum);
            preOrder(right, sum);
        }
    }
}
