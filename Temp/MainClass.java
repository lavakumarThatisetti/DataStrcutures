package Temp;

import java.io.IOException;

public class MainClass {
    public static char readInput(){
        char c = '\u0000';
        int input = 0;
        try{
            input = System.in.read();
            if(input!=-1){
                c=(char)input;
                System.out.println(c);
            }
        }catch (IOException e){
            System.out.println("Exception");
        }
        return c;
    }

    public static void main(String[] args) {
        char c =MainClass.readInput();
        System.out.println(c);
    }
}
