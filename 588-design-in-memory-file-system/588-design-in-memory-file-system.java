class FileSystem {
    
    Dir root;

    public FileSystem() {
        root = new Dir();
    }
    
    public List<String> ls(String path) {
        Dir curr = root;
        List<String> files = new ArrayList<>();
        if(!path.equals("/")) {
            String[] paths = path.split("/");
            int idx = 0;
            for(int i = 1; i < paths.length - 1; i++){
                curr = curr.dirs.get(paths[i]);
            }
            
            if(curr.files.containsKey(paths[paths.length -1])) {
                files.add(paths[paths.length -1]);
                return files;
            } else {
                curr = curr.dirs.get(paths[paths.length - 1]);
            }
        }
        
        
        files.addAll(new ArrayList<>(curr.dirs.keySet()));
        files.addAll(new ArrayList<>(curr.files.keySet()));
        Collections.sort(files);
        return files;
    }
    
    public void mkdir(String path) {
        Dir curr = root;
        String[] paths = path.split("/");
        for(int i = 1; i < paths.length; i++) {
            if(!curr.dirs.containsKey(paths[i])) {
                curr.dirs.put(paths[i], new Dir());
            }
            curr = curr.dirs.get(paths[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        Dir curr = root;
        String[] paths = filePath.split("/");
        
        for(int i = 1; i < paths.length - 1; i++) {
            curr = curr.dirs.get(paths[i]);
        }
        String fileName = paths[paths.length - 1];
        curr.files.put(fileName, curr.files.getOrDefault(fileName, "") + content);
    }
    
    public String readContentFromFile(String filePath) {
        Dir curr = root;
        String[] paths = filePath.split("/");
        for(int i = 1; i < paths.length - 1; i++) {
            curr = curr.dirs.get(paths[i]);
        }
        return curr.files.get(paths[paths.length - 1]);
    }
}

class Dir{
    Map<String, String> files;
    Map<String, Dir> dirs;
    
    public Dir(){
        files = new HashMap<>();
        dirs = new HashMap<>();
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */