class Solution {
    public int minMovesToMakePalindrome(String s) {
        int answer = 0;
        // abba
        int left = 0;
        int right = s.length() - 1;
        char[] charArr = s.toCharArray();
        while(left < right) {
            int l = left; 
            int r = right;
            if(charArr[l] != charArr[r]) {
                while(charArr[l] != charArr[r]) {
                    r--;
                }
                if(l==r) { // element odd
                    swap(r, r+1, charArr);
                    answer++;
                    continue;
                }
                else {
                    while(r < right) {
                        swap(r, r+1, charArr);
                        answer++;
                        r++;
                    }
                }
            }
            
            left++;
            right--;
        }
        
        return answer;
    }
    
    private void swap(int i, int j, char[] arr) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}