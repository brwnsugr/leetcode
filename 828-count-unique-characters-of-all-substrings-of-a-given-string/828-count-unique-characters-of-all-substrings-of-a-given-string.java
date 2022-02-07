class Solution {
  public int uniqueLetterString(String s) {
    int answer = 0;
    //init substring comb which satisfies adj chars
    // ABBABB ->
    // We count ways of representing of one A that we met before when we meet next A.
    // A, AB, ABB -> from point of previous A, left length * right length would be the ways of Representing A
    // between previous A and Current A.

    //after looping the String, we also count between end of the string and the last position of any Character at least we met before

    // ABBABB -> A's last idx : 4, and A, AB ABB would be the last ways of representing A from the view of Last A. ABB(ABB) in parentheses

    int pre[] = new int[26];
    int cur[] = new int[26];

    Arrays.fill(pre, -1); Arrays.fill(cur, -1);

    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(cur[c-'A'] == -1) cur[c-'A'] = i;
      else {
        answer += (i - cur[c-'A']) * (cur[c-'A']-pre[c-'A']);
        // move on to next step cur array and pre array respectively
        pre[c-'A'] = cur[c-'A'];
        cur[c-'A'] = i;
      }
    }
    int len = s.length();

    //we have to check the ways from last idx of any character to the end of the string
    // BBBBBBA ->  A exists, last idx of A is 6 and len is 7 -> len - last idx of character is also the count we have to add on.

    for(int i = 0; i < 26; i++) {
      if(cur[i] > -1) {
        answer += (len - cur[i]) * (cur[i] - pre[i]);
      }
    }
    return answer;
  }
}