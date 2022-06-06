class Solution {
    public long appealSum(String s) {
        int[] arr = new int[26];
        
        Arrays.fill(arr, -1);
        
        long currAppeals = 0;
        long appealSum = 0;
        char[] charArr = s.toCharArray();
        
        for(int i = 0; i < charArr.length; i++){
            if(arr[charArr[i]-'a'] == -1) {
                currAppeals = currAppeals + i + 1;
            }
            else{
                currAppeals = currAppeals + (i - arr[charArr[i]-'a']);
            }
            arr[charArr[i]-'a'] = i;
            appealSum += currAppeals;
        }
        
        return appealSum;
    }
}