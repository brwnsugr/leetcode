class Solution {
    public static List<int[]> DIRECTIONS = Arrays.asList(
        new int[]{1,0},
        new int[]{0,1},
        new int[]{-1, 0},
        new int[]{0,-1}
    );
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initColor = image[sr][sc];
        if(initColor == newColor) return image;
        mark(image, sr, sc, initColor, newColor);
        return image;
    }
    
    private void mark(int[][] image, int currR, int currC, int initColor, int newColor) {
        int m = image.length;
        int n = image[0].length;
        if(image[currR][currC] == initColor) {
            image[currR][currC] = newColor;
            for(int[] direction : DIRECTIONS) {
            int nextR = currR + direction[0];
            int nextC = currC + direction[1];
            if(nextR >= 0 && nextR < m
              && nextC >= 0 && nextC < n) {
                mark(image, nextR, nextC, initColor, newColor);
                }
            }
        }
        else return;
    }
}