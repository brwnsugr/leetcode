public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs.size() == 0) return Character.toString((char) 258);
        
        String d = Character.toString((char) 257);
        
        StringBuilder strBuilder = new StringBuilder();
        for(String s : strs) {
            strBuilder.append(s);
            strBuilder.append(d);
        }
        
        strBuilder.deleteCharAt(strBuilder.length() -1);
        return strBuilder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String d = Character.toString((char) 258);
        if(s.equals(d)) return new ArrayList<>();
        
        d = Character.toString((char) 257);
        return Arrays.asList(s.split(d, -1));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));