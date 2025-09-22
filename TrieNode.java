//Project 3
//By Tyler Hoffman
//CSCI 1913

public class TrieNode<T>{
    private T data; 
    private final TrieNode<T>[] children;
    
    /**
     * Constructs an empty TrieNode with no data and no children.
     */
    public TrieNode(){
        data = null;
        children = (TrieNode<T>[]) new TrieNode[26];
    }

    /**
     * Returns the data stored at this node.
     * @return
     */
    public T getData(){
        return data;
    }

    /**
     * Stores a data value at this node.
     * @param data
     */
    public void setData(T data){
        this.data = data;
    }

    /**
     * Returns the child node corresponding to the given lowercase letter. If the child doesn't exist, it is created and stored in this node. If the character is not between 'a' and 'z', returns null.
     * @param letter
     * @return
     */
    public TrieNode<T> getChild(char letter){
        if(letter < 'a' || letter > 'z'){
            return null;
        }

        int index = letter - 'a';
        if(children[index] == null){
            children[index] = new TrieNode<>();
        }

        return children[index];
    }

    /**
     * Counts the total number of nodes in the subtree rooted at this node.
     * @return
     */
    public int getTreeSize(){
        int count = 1;
        for(TrieNode<T> child : children){
            if(child != null){
                count += child.getTreeSize();
            }
        }

        return count;
    }
}