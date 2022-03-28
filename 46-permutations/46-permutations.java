class Solution {
    
    List<List<Integer>> answers = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        // int[] arr = new int[]
        perm(0, nums.length, nums);
        return answers;
    }
    
    private void perm(int start, int size, int[] nums) {
        if(start == size - 1) {
            List<Integer> listToAdd = new ArrayList<>();
            for(int num : nums) listToAdd.add(num);
            answers.add(listToAdd);
            return;
        }
        
        for(int idxSwap = start; idxSwap < size; idxSwap++) {
            int temp = nums[idxSwap];
            nums[idxSwap] = nums[start];
            nums[start] = temp;
            perm(start + 1, size, nums);
            temp = nums[idxSwap];
            nums[idxSwap] = nums[start];
            nums[start] = temp;
        }
    }
}