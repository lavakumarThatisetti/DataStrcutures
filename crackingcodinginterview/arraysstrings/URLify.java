package crackingcodinginterview.arraysstrings;

import java.util.Scanner;

public class URLify {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        str=str.trim();
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                stringBuilder.append("%20");
            } else if (str.charAt(i) != ' ') {
                stringBuilder.append(str.charAt(i));
            }
        }
        System.out.println(stringBuilder.toString());
        char[] cstr=replaceSpaces(str.toCharArray());
        for(int i=0;i<cstr.length;i++)
          System.out.print(cstr[i]);
        //In Place replacement

    }
    static char[] replaceSpaces(char[] str){
        int spaceCount=0,i=0;
        for(i=0;i<str.length;i++){
            if(str[i]==' ')
                spaceCount++;
        }
        while(str[i - 1] == ' ') {
            spaceCount--;
            i--;
        }
        int new_length=i+spaceCount*2;
        int index=new_length-1;
        char[] newStr=str;
        str=new char[new_length];
        for(int j=i-1;j>=0;j--){
            if(newStr[j]==' '){
                str[index]='0';
                str[index-1]='2';
                str[index-2]='%';
                index=index-3;
            }else{
                str[index]=newStr[j];
                index--;
            }
        }
        return str;
    }
}
