class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        //
        // ABi
        // A: 2, B;1, n = 1
        // f_max = 3
        // (3 - 1) * 
        // A
        // 
        int[] freq = new int[28];
        
        for(char task : tasks) freq[task-'A']++;
        
        Arrays.sort(freq);
        int maxFreq = freq[27];
        int idleSlots = (maxFreq - 1) * n;
        for(int i = 26; i >= 0; i--) {
            idleSlots -= Math.min(maxFreq-1, freq[i]);
            if(idleSlots < 0 || freq[i] == 0) break;
        }
        idleSlots = Math.max(0, idleSlots);
        return tasks.length + idleSlots;
    }
}