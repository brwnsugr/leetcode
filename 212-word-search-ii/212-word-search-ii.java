class Solution {
  private List<String> res = new ArrayList<>();
  public static int[][] DIRECTIONS = {{1,0}, {0,1}, {-1,0}, {0,-1}};

  public List<String> findWords(char[][] board, String[] words) {

    TrieNode root = new TrieNode();

    for(String word : words) {
      TrieNode node = root;
      char[] chars = word.toCharArray();
      for(char letter : chars) {
        if(node.children.containsKey(letter)) {
          node = node.children.get(letter);
        }
        else {
          node.children.put(letter, new TrieNode());
          node = node.children.get(letter);
        }
      }
      node.word = word;
    }

    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[0].length; j++) {
        if(root.children.containsKey(board[i][j])) {
          backTrack(board, i, j, root);
        }
      }
    }
    return res;
  }


  private void backTrack(char[][] board, int currY, int currX, TrieNode parentNode) {
    char currLetter = board[currY][currX];
    TrieNode currNode = parentNode.children.get(currLetter);
    if(currNode.word != null) {
      res.add(currNode.word);
      currNode.word = null;
    }
    int cols = board.length;
    int rows = board[0].length;
    board[currY][currX] = '#';
    for(int[] direction : DIRECTIONS) {
      int nextY = currY + direction[0];
      int nextX = currX + direction[1];

      if(nextY >= 0 && nextY < cols
        && nextX >= 0 && nextX < rows) {
        if(currNode.children.containsKey(board[nextY][nextX])) {
          backTrack(board, nextY, nextX, currNode);
        }
      }
    }
    board[currY][currX] = currLetter;

    if(currNode.children.isEmpty()) {
      parentNode.children.remove(currLetter);
    }
  }
}
public class TrieNode {
  String word;
  HashMap<Character, TrieNode> children = new HashMap<>();
  public TrieNode() {}
}