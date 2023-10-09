package Karat;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/text-justification/
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        int left = 0;
        while(left < words.length){
            int right = findRight(left, words, maxWidth);
            res.add(justify(left, right, words,maxWidth));
            left = right + 1;
        }
        return res;
    }

    public int findRight(int left, String[] words, int maxWidth){

        int right = left;
        int len = 0;
        while(right< words.length && len +  words[right].length() <= maxWidth) {
            len += words[right].length()+1;
            right++;
        }
        return right-1;
    }

    public String justify(int left, int right, String[] words, int maxWidth){
        if(right-left == 0) return padResult(words[left],maxWidth);

        boolean isLastLine = right == words.length - 1;
        int numSpaces = right - left;
        int totalSpace = maxWidth - wordsLength(left, right, words);

        // Space is the string with right num of spaces that should be attached to each word (numWordsToPad)
        String space = isLastLine ? " " : addBlank(totalSpace / numSpaces);

        // remainderSpaceCount is the number of extra space that need to be attached to words (from left)(justification)
        int remainderSpaceCount = isLastLine ? 0 : totalSpace % numSpaces;

        StringBuilder result = new StringBuilder();
        for (int i = left; i <= right; i++)
            // notice we also end up attaching to the last word, we will trim it later
            result.append(words[i]).append(space).append(remainderSpaceCount-- > 0 ? " " : "");

        // Here in the above for loop it might chances of exceeding space so we need to trim and then
        // We re add spaced to result till maxWidth by calling padResult function
        return padResult(result.toString().trim(), maxWidth);

    }
    private int wordsLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++) wordsLength += words[i].length();
        return wordsLength;
    }


    public String padResult(String result, int maxWidth){
        return result + addBlank(maxWidth - result.length());
    }

    public String addBlank(int length){
        return new String(new char[length]).replace('\0',' ');
    }
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        TextJustification wordWrap = new TextJustification();
        System.out.println(wordWrap.fullJustify(words,maxWidth));
    }
}
