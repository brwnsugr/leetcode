class Solution {
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
            if(currR + 1 < m) mark(image, currR+1, currC, initColor, newColor);
            if(currC + 1 < n) mark(image, currR, currC+1, initColor, newColor);
            if(currR - 1 >= 0) mark(image, currR-1, currC, initColor, newColor);
            if(currC - 1 >= 0) mark(image, currR, currC-1, initColor, newColor);
        }
        else return;
    }
}