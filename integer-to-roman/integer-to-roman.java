class Solution {
  private static List<Pair> WORD_DICT = Arrays.asList(
      new Pair(1, "I"),
      new Pair(4, "IV"),
      new Pair(5, "V"),
      new Pair(9, "IX"),
      new Pair(10, "X"),
      new Pair(40, "XL"),
      new Pair(50, "L"),
      new Pair(90, "XC"),
      new Pair(100, "C"),
      new Pair(400, "CD"),
      new Pair(500, "D"),
      new Pair(900, "CM"),
      new Pair(1000, "M")
  );



  public String intToRoman(int num) {
    /**
     * input num -> divide into the unit of each symbol
     * big number symbol first, and smaller one after that
     * try to make a division by bigger unit as big as I can make it.
     *
     * 1200 -> M (1,000) , 200 -> CC , remain is zero -> MCC
     *
     * 3 -> 1,1,1
     *
     * 58 -> 50, 5, 3
     *
     * 1994 -> 1000, 900, 90, 4
     *
     */

    String ans = "";

    for(int i = WORD_DICT.size()-1; i >= 0; i--) {
      while(num - WORD_DICT.get(i).val >= 0) {
        num -= WORD_DICT.get(i).val;
        ans += WORD_DICT.get(i).word;
      }
    }
    return ans;
  }

  static class Pair {
    int val;
    String word;

    public Pair(int val, String word) {
      this.val = val;
      this.word = word;
    }
  }
}