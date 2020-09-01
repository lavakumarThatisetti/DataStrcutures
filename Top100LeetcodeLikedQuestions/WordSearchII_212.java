package Top100LeetcodeLikedQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchII_212 {
    private class TrieNode {
        Map<Character, TrieNode> children;
        String word;
        TrieNode() {
            children = new HashMap<>();
        }
    }
    private final TrieNode root;
    WordSearchII_212() {
        root=new TrieNode();
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res=new ArrayList<>();
        ConstructTrie(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board, i, j,root,res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode current, List<String> res) {
        char c = board[i][j];
        if (c == '#' || current.children.get(c) == null) return;
        current = current.children.get(c);
        if (current.word != null) {
            res.add(current.word);
            current.word = null;
        }
        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,current, res);
        if (j > 0) dfs(board, i, j - 1, current, res);
        if (i < board.length - 1) dfs(board, i + 1, j, current, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, current, res);
        board[i][j] = c;
    }

    private void ConstructTrie(String[] words){
        for(String str:words){
            TrieNode current=root;
            for(char ch:str.toCharArray()){
                TrieNode node=current.children.get(ch);
                if (node == null) {
                    node = new TrieNode();
                    current.children.put(ch, node);
                }
                current=node;
            }
            current.word=str;
        }
    }
}
