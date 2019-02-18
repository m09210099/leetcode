/*leetcode #208 trie
**字典树
*/
class Node{
    char val;
    boolean isEnd;
    Node[] children = new Node[26];
    Node(){
        
    }
    Node(char c){
        val = c;
    }
}

class Trie {
    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
        root.val = ' ';
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.children[c-'a'] == null){
                node.children[c-'a'] = new Node(c);
            }
            node = node.children[c-'a'];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.children[c-'a'] == null){
                return false;
            }else{
                node = node.children[c-'a'];
            }
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(node.children[c-'a'] == null){
                return false;
            }else{
                node = node.children[c-'a'];
            }
        }
        return true;
    }
}