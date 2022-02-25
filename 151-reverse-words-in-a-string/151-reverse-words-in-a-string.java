class Solution {
    public String reverseWords(String s) {
        
        if(s.length() == 1) return s;
        
        
        s = s.trim();
        
        //1. 먼저 양끝 공백 제거 
        
        //2. 띄어쓰기 기준으로 split 을 해서 string 배열로 만든다음에 -> 역순으로 넣어주자
        char[] arr = s.toCharArray();

        // 공백이 나오면 날려줌
        String[] aa = s.split("\\s+");

        // 공백이 제거된 스트링을 역순으로 돌면서 String 배열에 넣어주면 
    
        StringBuilder strBuilder = new StringBuilder();

        for(int i = aa.length-1; i>=0 ; i--) {
            strBuilder.append(aa[i]);
            if(i != 0) strBuilder.append(' ');
        }
        
        

        return strBuilder.toString();
    }
}