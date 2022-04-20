class Solution {
    
    private int[] arr;
    private int answer;
    
    public int findKthLargest(int[] nums, int k) {
        //Optimal Solution: Quick Select(using pivot)
        // 3,2,1,5,6,4
        // step1: set left, right pointer (init with first and end)
        // step2: set random pivot
        // step3: within (right - left) range, move elements less than pivot to left,
        // else -> move to right
        // step4: get pivot Idx by partitioning
        // smallest kth idx is less than pivot idx -> find left, 
        // smallest kth idx is bigger than pivot -> find right
        arr = nums;
        int size = nums.length;
        if(size == 1) return nums[0];
        quickSelect(0, size - 1, size - k);
        return answer;
    }
    
    
    private void quickSelect(int left, int right, int kthsmallestIdx){
        Random random = new Random();
        if(left == right) {
            answer = arr[left];
            return;
        }
        int pivotIdx = left + random.nextInt(right - left);
        
        int partitionIdx = getPartition(left, right, pivotIdx);
        
        if(partitionIdx == kthsmallestIdx) {
            answer = arr[partitionIdx];
            return;
        }
        
        else if(partitionIdx < kthsmallestIdx) {
            //find right
            quickSelect(partitionIdx+1, right, kthsmallestIdx);
        }
        
        else {
            quickSelect(left, partitionIdx, kthsmallestIdx);
        }
        
        
    }
    
    private int getPartition(int left, int right, int pivotIdx) {
        int pivot = arr[pivotIdx];
        swapArr(pivotIdx, right);
        
        int storeIdx = left;
        
        for(int i = left; i <= right; i++) {
            if(arr[i] < pivot){
                swapArr(i, storeIdx);
                storeIdx++;
            }
        }
        
        swapArr(storeIdx, right);
        return storeIdx;
    }
    
    private void swapArr(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    

}