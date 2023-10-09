package SearchEngine;

import java.util.*;

public class Trie {

    static int MAX_ALPHABET_SIZE  = 26;

    private final TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    static class TrieNode {
        private final HashMap<Character, TrieNode> children;
        private String content;
        private boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            children = new HashMap<>();
        }

        public HashMap<Character, TrieNode> getChildren() {
            return children;
        }
        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public void setEndOfWord(boolean word) {
            isEndOfWord = word;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

     public void insert(String word){
        TrieNode current = root;
        for(char c:word.toCharArray()){
            current = current.getChildren().computeIfAbsent(c,ch->new TrieNode());
        }
        current.setEndOfWord(true);
    }

    public boolean search(String word){
        TrieNode current = root;
        for(char c:word.toCharArray()){
            if(current.getChildren().get(c)!=null){
                current = current.getChildren().get(c);
            }else{
                return false;
            }
        }
        return current.isEndOfWord;
    }

    public List<String> getPrefixWords(String word){
        List<String> list = new ArrayList<>();
        TrieNode current = root;
        for(char c: word.toCharArray()){
            if(current.getChildren().get(c)!=null){
                current = current.getChildren().get(c);

            }else{
                return new ArrayList<>();
            }
        }

        HashMap<Character, TrieNode> children = current.getChildren();
        for (Map.Entry<Character, TrieNode> entry : children.entrySet()) {
            TrieNode trieNode = entry.getValue();
            StringBuilder str = new StringBuilder();
        }

        return list;
    }

    public void delete(String word) {
        deleteHelper(root, word,0);
    }
    private boolean deleteHelper(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = deleteHelper(node, word, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("programming");
        trie.insert("is");
        trie.insert("way");
        trie.insert("problem");

        trie.getPrefixWords("pro");

        System.out.println(trie.search("programming"));
        System.out.println(trie.search("isHello"));
        System.out.println(trie.search("program"));



        trie.delete("is");
    }
}
