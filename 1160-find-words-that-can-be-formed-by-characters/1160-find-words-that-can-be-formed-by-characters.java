class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] wordDict = new int[26];
        for(char c : chars.toCharArray()) wordDict[c-'a']++;
        int count = 0;
        for(String word : words) {
            int[] currDict = new int[26];
            boolean isGood = true;
            for(char c : word.toCharArray()) {
                currDict[c-'a']++;
            }
            for(int i = 0; i< 26; i++) {
                if(currDict[i] > wordDict[i]) {
                    isGood= false;
                    break;
                }
            }
            if(isGood) {
                count += word.length();
            }
        }
        return count;
    }
}