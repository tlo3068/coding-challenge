/*
This problem was asked by Google.
Suppose we represent our file system by a string in the following manner:
The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.
The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. 
subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. 
subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. 
For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", 
and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, 
return the length of the longest absolute path to a file in the abstracted file system. 
If there is no file in the system, return 0.

Note:
The name of a file contains at least a period and an extension.
The name of a directory or sub-directory will not contain a period.
*/


class Node {
    final ArrayList<Node> children = new ArrayList<Node>();
    final String dirname;
    final boolean isFile;
    public Node(String dirname){
        this.depth = depth;
        this.dirname = dirname;
        this.isFile = (dirname.matches("^[a-zA-Z0-9]*\.[a-zA-Z]+$")) ? true: false;
    }
    public void addChild(Node child){
    //     Node child = new Node(this.depth + 1, dirname);
    //     children.add(child);
        children.add(child);
    }

}


public class App {


    public static Node createTree(int depth, String path, Node parent){
        if (path.matches("^[a-zA-Z0-9]+\.?[a-zA-Z0-9]*$")){
            return new Node(path);
        }
        String child_dirname = root.replaceAll("^([A-Za-z0-9]+)(\\.*)","$1");
        String new_path = root.replaceAll("^([A-Za-z0-9]+)\\n(\\t){"+depth+"}(.*)","$2");
        Node child = new Node(child_dirname);
        String[] roots = new_path.split("\\n(\\t){"+depth+"}((?!\\t))*"/);
        for (String root: roots){
            if (root != null && root != ""){
                child.addChild(createTree(depth + 1, new_path, child));
            }
        }
        return child;
    }


    // Iterate through tree and check max length;
    // Recursive BFS with current total and global total

    public static void main(String[] args){
        System.out.println("Starting ...");
        String path = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
    }
}