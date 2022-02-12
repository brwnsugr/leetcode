import java.util.*;

class Solution {
    
    private static int[][] DIRECTIONS = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    
    public int cutOffTree(List<List<Integer>> forest) {
        
        /*
        We Sort all the trees by height and starting from the 0,0 I trying to get steps to reach each tree of height
        In eachd we find the tree we aimed, the new start point would be the aimed tree
        */

        
        /*
        Basic implementation that I've come up with is 
        1. sort the height and store in the linkedlist with its position
        2. get steps in each starting point (0, 0)
        
        and each starting to reaching to the aim point,
        I would use BFS to get steps because it's about to get the shortest possible distance between start and aim
        N = Rows * Cols
        TC: O(N) + O(NlogN) + O(N*N) = O(N*N), SC: O(3N) = O(N)
        */
        
        List<int[]> trees = getTrees(forest);
        Collections.sort(trees, new Comparator<int[]>(){
           @Override
           public int compare(int[] t1, int[] t2) {
                return t1[2] - t2[2];
           }
        });
        
        int totalSteps = 0;
        int startY = 0; int startX = 0;
        
        while(!trees.isEmpty()) {
            int[] curr = trees.remove(0);
            int aimY = curr[0]; int aimX = curr[1];
            int steps = getSteps(forest, startY, startX, aimY, aimX);
            if(steps == -1) return steps;
            else totalSteps += steps;
            startY = aimY;
            startX = aimX;
        }
        return totalSteps;
    }
    
    private int getSteps(List<List<Integer>> forest, int startY, int startX, int aimY, int aimX) {
        int steps = 0;
        int rows = forest.size();
        int cols = forest.get(0).size();
        boolean[][] visited = new boolean[rows][cols];
        visited[startY][startX] = true;
        boolean reachedAim = false;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startY, startX});
        
        while(!q.isEmpty()) {
            int qSize = q.size();
            for(int i = 0; i < qSize; i++) {
                int[] curr = q.poll();
                if(curr[0] == aimY && curr[1] == aimX) {
                    reachedAim = true;
                    break;
                }
                
                for(int[] direction : DIRECTIONS) {
                    int nextY = curr[0] + direction[0];
                    int nextX = curr[1] + direction[1];
                    if(nextY >= 0 && nextY < rows 
                       && nextX >= 0 && nextX < cols
                       && forest.get(nextY).get(nextX) > 0
                       && !visited[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        q.add(new int[]{nextY, nextX});
                    }
                }
            }
            if(reachedAim) return steps;
            steps++;
        }
        return -1;
    }
    
    
    
    List<int[]> getTrees(List<List<Integer>> forest){
        List<int[]> res = new LinkedList<>();
        for(int i = 0; i < forest.size(); i++) {
            for(int j = 0; j < forest.get(0).size(); j++) {
                if(forest.get(i).get(j) > 1) {
                    res.add(new int[]{i,j,forest.get(i).get(j)});
                }
            }
        }
        return res;
    }
}