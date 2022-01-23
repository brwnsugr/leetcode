class Solution {
    public int maximumGood(int[][] statements) {
    int n = statements.length;
    int ans = Integer.MIN_VALUE;

    for(int i = 1 << n; i < 1 <<(n+1); i++) {
      String permutation = Integer.toBinaryString(i).substring(1);
      boolean currCombValid = true;
      for(int j = 0; j < permutation.length(); j++) {
        char curr = permutation.charAt(j);
        if(curr == '0') continue;
        for(int k = 0; k < permutation.length(); k++) {
          if((statements[j][k] == 1 && permutation.charAt(k) == '0')
              || (statements[j][k] == 0 && permutation.charAt(k) == '1')) {
            currCombValid = false;
            break;
          }
        }
        if(!currCombValid) break;
      }
      if(currCombValid) {
        int tempAns = 0;
        for(int l = 0; l < permutation.length(); l++) {
          if(permutation.charAt(l) == '1') tempAns++;
        }
        ans = Math.max(tempAns, ans);
      }
    }
    return ans;
        
    }
}