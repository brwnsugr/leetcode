class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
    String res = "";

    long weight = 1;
    for(int i = 0; i < k-1; i++) weight = (weight * power) % modulo;

    long hash = 0;
    int r = s.length() -1;
    for(int i = s.length()-1; i>=0; i--) {
      int val = s.charAt(i) - 'a' + 1;
        
      hash = ((hash * power % modulo) + val) % modulo;
        
      if(r - i + 1 == k) {
        if(hash == hashValue) {
          res = s.substring(i, r + 1);
        }
        hash = (hash + modulo - (s.charAt(r) - 'a' + 1)*weight%modulo)%modulo;
        r--;
      }
    }
    return res;
    }
}