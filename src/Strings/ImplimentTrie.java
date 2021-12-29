package Strings;

public class ImplimentTrie {
    /**
     * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and
     * retrieve keys in a dataset of strings. There are various applications of this data structure,
     * such as autocomplete and spellchecker.
     *
     * Implement the Trie class:
     * Trie() Initializes the trie object.
     * void insert(String word) Inserts the string word into the trie.
     * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before),
     * and false otherwise.
     * boolean startsWith(String prefix) Returns true if there is a previously inserted string word
     * that has the prefix prefix, and false otherwise.
     */
    class Trie {
        public TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            this.root = new TrieNode('p');
        }
        class TrieNode{
            public char c;
            public TrieNode[] next;
            public boolean endOfWord;

            public TrieNode(char character){
                c = character;
                next = new TrieNode[26];
                endOfWord = false;
            }
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(curr.next[c - 'a'] == null)curr.next[c - 'a'] = new TrieNode(c);

                curr = curr.next[c - 'a'];
            }
            curr.endOfWord = true;


        }
        public TrieNode getNode(String word){
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(curr.next[c - 'a'] == null) return null;
                curr = curr.next[c - 'a'];
            }
            return curr;

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(curr.next[c - 'a'] == null){
                    return false;
                }
                curr = curr.next[c - 'a'];
            }
            if(curr.endOfWord){
                return true;
            }
            return false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix){
            TrieNode curr = root;
            for(int i = 0; i < prefix.length(); i++){
                char c = prefix.charAt(i);
                if (curr.next[c - 'a'] == null){
                    return false;
                }
                curr = curr.next[c - 'a'];
            }
            return true;
        }


    }


}
