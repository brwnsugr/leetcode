class Solution {
  public int myAtoi(String s) {

    /**
     * should Folow the given rule exactly
     *
     * 1st: check the space at front
     * 2nd: check the sign which decide if negative or not
     * 3rd: after that, go through the loop til the digit end
     * ** the important thing is that 1st and 2nd process, even when we wouldn't find
     * the digits right after, we don't have to consider the rest of the string anymore
     *
     */

    int maxValue = Integer.MAX_VALUE; // 3647
    int minValue = Integer.MIN_VALUE; // -3648

    boolean negativeFlag = false;
    int idx = 0;

    /**
     * 1st: check the space at front
     */
    s = s.trim();

    /**
     * 2nd: check the sign which decides whether it's negative or not
     */
    while(idx < s.length() && (s.charAt(idx) == '-' || s.charAt(idx) == '+')){
      negativeFlag = s.charAt(idx) == '-' ? true : false;
      idx++;
      break;
    }

    /**
     * 3rd: check the digit and go through that char array til the digit part ends
     */
    int res = 0;
    while(idx < s.length() && Character.isDigit(s.charAt(idx))) {
      int digit = s.charAt(idx) -'0';
      if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE/10 && (digit > Integer.MAX_VALUE % 10))){
        return negativeFlag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }
      else {
        res = res * 10 + digit;
      }
      idx++;
    }
    return negativeFlag ? -res : res;
  }
}