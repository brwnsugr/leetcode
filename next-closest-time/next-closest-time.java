class Solution {
        private List<Integer> currList;
    private List<Integer> answerList;
    private int currMinutes;
    
    public String nextClosestTime(String time) {
        currList = makeTimeList(time); 
        currMinutes = getMinutes(currList);
        dfs(new ArrayList(), 0);
        
        StringBuilder strBuilder = new StringBuilder();
        for(int i = 0; i < 4; i++) {
            strBuilder.append(String.valueOf(answerList.get(i)));
            if(i == 1) strBuilder.append(':');
        }
        
        return new String(strBuilder);
    }
    
    
    private void dfs(List<Integer> tempList, int idx) {
        if(tempList.size() == currList.size()) {
            int tempMinutes = getMinutes(tempList);
            int prevDiff = answerList == null ? 24*60 + 1 : getPositiveDiff(currMinutes, getMinutes(answerList)); 
            if (answerList == null || isValid(tempList) && currMinutes != tempMinutes
               && getPositiveDiff(currMinutes, tempMinutes) < prevDiff) {
                answerList = new ArrayList<>(tempList);
            }
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            if(i != 0 && currList.get(i) == currList.get(i-1)) continue;
            tempList.add(currList.get(i));
            dfs(tempList, idx+1);
            tempList.remove(tempList.size() -1);
        }
    }
    
    private int getPositiveDiff(int currMinutes, int varMinutes) {
        return varMinutes >= currMinutes ? (varMinutes - currMinutes) : varMinutes + (24*60) - currMinutes;
    }
    
    private List<Integer> makeTimeList(String time) {
        List<Integer> res = new ArrayList<>();
        for(char timeCh : time.toCharArray()) {
            if(timeCh == ':') continue;
            res.add((int) timeCh - '0');
        }
        return res;
    }
    
    private int getMinutes(List<Integer> timeList) {
        int hours = timeList.get(0) * 10 + timeList.get(1);
        int minutes = timeList.get(2) * 10 + timeList.get(3);
        return hours * 60 + minutes;
    }
    
    private boolean isValid(List<Integer> timeList) {
        int hours = timeList.get(0) * 10 + timeList.get(1);
        int minutes = timeList.get(2) * 10 + timeList.get(3);
        return hours < 24 && minutes < 60;
    }
}