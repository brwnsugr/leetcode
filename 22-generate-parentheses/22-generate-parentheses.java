class Solution {
  private List<String> res = new ArrayList<>();
  public List<String> generateParenthesis(int n) {
    Stack<Character> s = new Stack<>();
    Map<Character, Integer> m = new HashMap<>();
    m.put('(', 1);
    m.put(')', 0);
    s.add('(');
    dfs(m, "(", s, n);
    return res;
  }

  private void dfs(Map<Character, Integer> m,  String paren, Stack<Character> s, int n) {
    if(s.isEmpty() && m.get('(') == n && m.get(')') == n) {
      res.add(String.copyValueOf(paren.toCharArray()));
      return;
    } else {
      if(s.isEmpty()) {
        s.add('(');
        m.put('(', m.get('(')+1);
        dfs(m, paren + "(", s,n);
        s.pop();
        m.put('(', m.get('(')-1);
      }
      if(!s.isEmpty() && s.peek() == '(' && m.get(')') < n) {
        s.pop();
        m.put(')', m.get(')')+1);
        dfs(m, paren + ")", s, n);
        m.put(')', m.get(')')-1);
        s.add('(');
      }
      if(!s.isEmpty() && s.peek() == '(' && m.get('(') < n) {
        s.add('(');
        m.put('(', m.get('(')+1);
        dfs(m, paren + "(", s, n);
        m.put('(', m.get('(')-1);
        s.pop();
      }
    }
    return;
  }
}