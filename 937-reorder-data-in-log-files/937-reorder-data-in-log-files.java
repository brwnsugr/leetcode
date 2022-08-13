class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        
        Arrays.sort(logs, new Comparator<String>(){
            @Override
            public int compare(String p1, String p2) {
                String[] p1Str = p1.split(" ", 2);
                String[] p2Str = p2.split(" ", 2);
                
                boolean p1Digit = Character.isDigit(p1Str[1].charAt(0));
                boolean p2Digit = Character.isDigit(p2Str[1].charAt(0));
                
                if(!p1Digit && p2Digit) return -1;
                else if(p1Digit && !p2Digit) return 1;
                else if(!p1Digit && !p2Digit) {
                    if(p1Str[1].equals(p2Str[1])) {
                        return p1Str[0].compareTo(p2Str[0]);
                    } 
                    else return p1Str[1].compareTo(p2Str[1]);
                }
                else return 0;
            }
        });
        
        return logs;
    }
}