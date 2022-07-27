class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
            
        }

        ArrayList<ArrayList<String>> dp = new ArrayList<ArrayList<String>>(s.length() + 1);
        for (int i = 0; i < s.length() + 1; ++i) {
            ArrayList<String> emptyList = new ArrayList<String>();
            dp.add(emptyList);
        }
        dp.get(0).add("");

        for (int endIndex = 1; endIndex < s.length() + 1; ++endIndex) {
            ArrayList<String> sublist = new ArrayList<String>();

            // fill up the values in the dp array.
            for (int startIndex = 0; startIndex < endIndex; ++startIndex) {
                String word = s.substring(startIndex, endIndex);
                if (wordSet.contains(word))
                    for (String subsentence : dp.get(startIndex))
                        sublist.add((subsentence + " " + word).strip());
            }
            dp.set(endIndex, sublist);
        }

        return dp.get(s.length());
    }
}