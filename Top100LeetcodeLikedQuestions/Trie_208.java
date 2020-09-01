package Top100LeetcodeLikedQuestions;


import sun.text.normalizer.Trie;

import java.util.HashMap;
import java.util.Map;

public class Trie_208 {
        private class TrieNode {
            Map<Character, TrieNode> children;
            boolean endOfWord;
            TrieNode() {
                children = new HashMap<>();
                endOfWord = false;
            }
        }
        private final TrieNode root;
        Trie_208() {
            root=new TrieNode();
        }
        private void insert(String word) {
            TrieNode current=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                TrieNode node=current.children.get(ch);
                if(node==null){
                    node= new TrieNode();
                    current.children.put(ch,node);
                }
                current=node;
            }
            current.endOfWord=true;
        }

        private boolean search(String word) {
            TrieNode current=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                TrieNode node=current.children.get(ch);
                if(node==null){
                    return false;
                }
                current=node;
            }
            return current.endOfWord;
        }
        private boolean startsWith(String prefix) {
            TrieNode current=root;
            for(int i=0;i<prefix.length();i++){
                char ch=prefix.charAt(i);
                TrieNode node=current.children.get(ch);
                if(node==null){
                    return false;
                }
                current=node;
            }
            return true;
        }
        private boolean delete(String word){
            return deleteRecursive(root,word,0);
        }
        private boolean deleteRecursive(TrieNode current,String word, int index){
            if(index==word.length()){
                if(!current.endOfWord)
                    return false;
                current.endOfWord=false;
                return current.children.size()==0;
            }
            char ch=word.charAt(index);
            TrieNode node=current.children.get(ch);
            if(node==null)
                return false;

            boolean shouldDeleteCurrentNode=deleteRecursive(node,word,index+1);
            if(shouldDeleteCurrentNode){
                    current.children.remove(ch);
                    return current.children.size()==0;
            }
            return false;
        }
        public static void main(String[] args) {
            Trie_208 obj = new Trie_208();
            String[] word={"lavakumar","NTR"};
            for(String str:word) obj.insert(str);
            boolean param_2 = obj.search(word[0]);
            System.out.println(param_2);
            boolean param_3 = obj.startsWith("lava");
            System.out.println(param_3);
            boolean delete=obj.delete(word[1]);
            System.out.println(delete);
        }
}
