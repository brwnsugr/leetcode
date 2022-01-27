class Solution {
    public int reverse(int x) {
            int ret = 0;
    while(x != 0) {
      int r = x % 10;
      x /= 10;
      if(ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && r > 7)) return 0; 
      if(ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && r < -8)) return 0;
      ret = ret * 10 + r;
    }
    return ret;
        
    }
}