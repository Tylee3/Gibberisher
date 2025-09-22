//Project 3
//By Tyler Hoffman
//CSCI 1913

public class Trie<T>{
    private final TrieNode<T> root;

    /**
     * Constructs an empty Trie with a new root node.
     */
    public Trie(){
        root = new TrieNode<>();
    }

    /**
     * Traverses the Trie following the characters of the given key. Calls getChild() from TrieNode, which creates intermediate nodes for valid letters. If any character is not a lowercase letter, returns null.
     * @param key
     * @return
     */
    private TrieNode<T> getNode(String key){
        TrieNode<T> node = root;
        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            node = node.getChild(c);
            if(node == null){
                return null;
            }
        }

        return node;
    }

    /**
     * Returns the value associated with the given key.
     * @param key
     * @return
     */
    public T get(String key){
        TrieNode<T> node = getNode(key);
        if(node == null){
            return null;
        }

        return node.getData();
    }

    /**
     * Updates the value for the given key. Creates any missing nodes along the path for valid lowercase letters.
     * @param key
     * @param value
     * @return
     */
    public T put(String key, T value){
        TrieNode<T> node = root;
        for(int i = 0; i < key.length(); i++){
            node = node.getChild(key.charAt(i));
        }

        T old = node.getData();
        node.setData(value);
        return old;
    }

}