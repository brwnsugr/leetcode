class Solution {
    public String largestNumber(int[] nums) {
        //
        //10, 2 -> 210 
        //10, 11 -> 1110
        // 20, 2, -> 220
        // 30, 2, 31
        // sol: 30 
        //
        // 1. 1 digit and high
        // 2. 2 digit first digit highest
        // 3. ..... 
        
        //  200. 21 -> 20021 < 21200
        // 21, 200 
        
        String s = String.valueOf(1);
    
        String[] stringNums = new String[nums.length];
        int idx = 0;
        for(int num : nums) {
            stringNums[idx] = String.valueOf(num);
            idx++;
        }
        
        Arrays.sort(stringNums, new Comparator<String>(){
           @Override
            public int compare(String s1, String s2) {
                String concat1 = s1 + s2;
                String concat2 = s2 + s1;
                return concat2.compareTo(concat1);
            }
        });
        
        if(stringNums[0].equals("0")) return "0";
        StringBuilder strBuilder = new StringBuilder();
        for(String numString : stringNums) {
            strBuilder.append(numString);
        }
        

        return new String(strBuilder);
    }
}