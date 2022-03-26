class Solution {
    public int numberOfSteps(int num) {
        String binaryString = Integer.toBinaryString(num);
        int steps = 0;
        for(char bit : binaryString.toCharArray()) {
            if(bit == '1') {
                steps += 2;
            }
            else {
                steps += 1;
            }
        }
        return steps - 1;
    }
}