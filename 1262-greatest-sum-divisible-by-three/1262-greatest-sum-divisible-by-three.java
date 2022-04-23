class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        List<Integer> oneList = new ArrayList<>();
        List<Integer> twoList = new ArrayList<>();
        
        for(int num : nums) {
            if(num % 3 == 1) oneList.add(num);
            else if(num % 3 == 2) twoList.add(num);
            sum += num;
        }
        
        if(sum % 3 == 0) {
            return sum;
        }
        
        else {
            Collections.sort(oneList);
            Collections.sort(twoList);
            int minSubtract = Integer.MAX_VALUE;
            if(sum % 3 == 1) {
                if(oneList.size() < 1 && twoList.size() < 2) return 0;
                if(twoList.size() >= 2) minSubtract = Math.min(minSubtract, twoList.get(0) + twoList.get(1));
                if(oneList.size() >= 1) minSubtract = Math.min(minSubtract, oneList.get(0));
            }
            else if(sum % 3 == 2) {
                if(oneList.size() < 2 && twoList.size() < 1) return 0;
                if(twoList.size() >= 1) minSubtract = Math.min(minSubtract, twoList.get(0));
                if(oneList.size() >= 2) minSubtract = Math.min(minSubtract, oneList.get(0) + oneList.get(1));
            }
            sum -= minSubtract;
        }
        return sum;
    }
}