class Solution {
    public String[] reorderLogFiles(String[] logs) {
    
        Arrays.sort(logs, new Comparator<String>(){
           
            @Override
            public int compare(String t1, String t2) {
                
                String[] p1 = t1.split(" ", 2);
                String[] p2 = t2.split(" ", 2);
                boolean p1Digit = Character.isDigit(p1[1].charAt(0));
                boolean p2Digit = Character.isDigit(p2[1].charAt(0));
                
                if(!p1Digit && p2Digit) return -1;
                else if(p1Digit && !p2Digit) return 1;
                else if(!p1Digit && !p2Digit){
                    if(p1[1].equals(p2[1])) {
                        return p1[0].compareTo(p2[0]);
                    }
                    return p1[1].compareTo(p2[1]);
                }
                else {
                    return 0;
                }
            }
        });
        
        return logs;
    }
}