class Solution {
    public boolean rotateString(String s, String goal) {
        if(goal.length() < s.length()) return false;
        String concatStr = s.concat(s);
        return concatStr.contains(goal);
    }
}