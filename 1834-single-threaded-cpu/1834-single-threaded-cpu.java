class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] newTasks = new int[tasks.length][3];
        int[] answer = new int[tasks.length];
        
        for(int i = 0; i < tasks.length; i++) {
            newTasks[i][0] = tasks[i][0];
            newTasks[i][1] = tasks[i][1];
            newTasks[i][2] = i;
        }
        
        Arrays.sort(newTasks, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> minQ = new PriorityQueue<>((a,b) -> a[1] != b[1] ? a[1]-b[1] : a[2]-b[2]);
        
        int currTime = 0;
        int taskIdx = 0;
        int ansIdx = 0;
        
        while(taskIdx < newTasks.length || !minQ.isEmpty()) {
            if(minQ.isEmpty() && currTime < newTasks[taskIdx][0]) {
                currTime = newTasks[taskIdx][0];
            }
            
            while(taskIdx < newTasks.length && newTasks[taskIdx][0] <= currTime) {
                minQ.add(newTasks[taskIdx]);
                taskIdx++;
            }
            
            int processTime = minQ.peek()[1];
            int index = minQ.peek()[2];
            minQ.remove();
            
            currTime += processTime;
            answer[ansIdx++] = index;
        }
        
        return answer;
        
}
}