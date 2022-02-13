class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        /*
        "m", "mo", ... , "mouse"
        in every prefix, we try to find the prefix of word equals in the products which is sorted lexicographically.
        
        M : searchWord length, N: products length
        TC: O(NlogN + MlogM) SC: O(M)
        */
        
        /*
        getSorted String array
        */
        Arrays.sort(products);
        
        String prefix = "";
        
        List<List<String>> answerSet = new ArrayList<>();
        int bsStart = 0;
        
        for(char c : searchWord.toCharArray()) {
            prefix += c;
            
            int start = getStartIdxOfPrefix(bsStart, prefix, products);
            List<String> temp = new ArrayList<>();
            
            
            for(int i = start; i < Math.min(start + 3, products.length); i++) {
                if(products[i].startsWith(prefix)) {
                    temp.add(products[i]);
                } else break;
            }
            answerSet.add(temp);
            bsStart = start;
        }
        return answerSet;
        
    }
    
    
    public int getStartIdxOfPrefix(int bsStart, String prefix, String[] products){
        int i = bsStart;
        int j = products.length;
        while(i < j) {
            int mid = (i + j) / 2;
            System.out.println("mid is " + mid);
            if(products[mid].compareTo(prefix) >= 0) {
                j = mid;
            }
            else {
                i = mid + 1;
            }
        }
        return i;
    }
}