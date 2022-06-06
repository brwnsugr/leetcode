class Solution {
    public int minMovesToMakePalindrome(String s) {
        int moves = 0;
        
        char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length -1;
        
        while(l < r) {
            int currPointer = r;
            
            if(arr[l] == arr[r]) {
                l++;
                r--;
            }
            else {
                while(arr[l] != arr[currPointer]) {
                   currPointer--; 
                }
                
                if(currPointer == l) {
                    swap(arr, l, l+1);
                    moves++;
                }
                
                else {
                    while(currPointer < r) {
                        swap(arr, currPointer, currPointer+1);
                        moves++;
                        currPointer++;
                    }
                }
            }
        }
        
        
        return moves;
    }
    
    private void swap(char[] arr, int start, int end){
        char tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }
}