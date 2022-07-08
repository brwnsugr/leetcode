/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    private char[] buf4 = new char[4];
    private int n4 = 0;
    private int i4 = 0;
    
    public int read(char[] buf, int n) {
        
        int i = 0;
        
        while(i < n) {
            if(i4 >= n4) {
                i4 = 0;
                n4 = read4(buf4);
                if(n4 == 0) break;
            }
            buf[i++] = buf4[i4++];
        }
        
        
        return i;
    }
    
    
}