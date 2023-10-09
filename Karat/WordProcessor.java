package Karat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
We are building a word processor and we would like to implement a "reflow" functionality that also applies full justification to the text.
Given an array containing lines of text and a new maximum width, re-flow the text to fit the new width.
Each line should have the exact specified width.
If any line is too short, insert '-' (as stand-ins for spaces) between words as equally as possible until it fits.
Note: we are using '-' instead of spaces between words to make testing and visual verification of the results easier.


lines = [ "The day began as still as the",
          "night abruptly lighted with",
          "brilliant flame" ]

reflowAndJustify(lines, 24) ... "reflow lines and justify to length 24" =>

        [ "The--day--began-as-still",
          "as--the--night--abruptly",
          "lighted--with--brilliant",
          "flame" ] // <--- a single word on a line is not padded with spaces

reflowAndJustify(lines, 25) ... "reflow lines and justify to length 25" =>

        [ "The-day-began-as-still-as"
          "the-----night----abruptly"
          "lighted---with--brilliant"
          "flame" ]

reflowAndJustify(lines, 26) ... "reflow lines and justify to length 26" =>

        [ "The--day-began-as-still-as",
          "the-night-abruptly-lighted",
          "with----brilliant----flame" ]

reflowAndJustify(lines, 40) ... "reflow lines and justify to length 40" =>

        [ "The--day--began--as--still--as-the-night",
          "abruptly--lighted--with--brilliant-flame" ]

*/
public class WordProcessor {

    public List<String> reflowAndJustify(String[] lines, int maxWidth){

        List<String> words = new ArrayList<>();
        for (String line : lines) {
            Collections.addAll(words, line.split(" "));
        }

        int left = 0;
        List<String> res = new ArrayList<>();
        while(left< words.size()){
            int right = findRight(left, words, maxWidth);
            res.add(justifyWithDashes(left, right, words, maxWidth));
            left = right+1;
        }
        return res;
    }

    public int findRight(int left, List<String> words, int maxWidth){
        int right = left;
        int len = 0;
        while(right < words.size() && len + words.get(right).length() <= maxWidth){
            len +=words.get(right).length()+1;
            right++;
        }
        return right-1;
    }

    public String justifyWithDashes(int left, int right, List<String> words, int maxWidth){
        if(right - left ==0) return words.get(left);

        int numOfDashes = right-left;
        int totalDashes = maxWidth - getWordsLength(left,right,words);

        String dashesStr = addBlank(totalDashes/numOfDashes);
        int extraDashesToAdd =  totalDashes%numOfDashes;

        StringBuilder str = new StringBuilder();
        for(int i=left;i<right;i++){
            str.append(words.get(i)).append(dashesStr).append(extraDashesToAdd-->0?"-":"");
        }
        str.append(words.get(right)).append(extraDashesToAdd-->0?"-":"");

        return padDashes(str.toString(), maxWidth);
    }

    public String padDashes(String str, int maxWidth){
        return str + addBlank(maxWidth - str.length());
    }

    public String addBlank(int length){
        return new String(new char[length]).replace('\0','-');
    }

    public int getWordsLength(int left, int right, List<String> words){
        int len = 0;
        for(int i=left;i<=right;i++){
            len+= words.get(i).length();
        }
        return len;
    }


    public static void main(String[] args) {
        String[] lines = {"The day began as still as the", "night abruptly lighted with", "brilliant flame"};
        int maxWidth = 16;
        WordProcessor wordProcessor = new WordProcessor();
        System.out.println(wordProcessor.reflowAndJustify(lines,24));
        System.out.println(wordProcessor.reflowAndJustify(lines,25));
        System.out.println(wordProcessor.reflowAndJustify(lines,26));
        System.out.println(wordProcessor.reflowAndJustify(lines,40));
    }
}
