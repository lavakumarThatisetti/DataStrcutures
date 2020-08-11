package problemsolving;

public class longestCommonsubsequence {
    public static String lcs(String str1,String str2,int index1,int index2,String[][] memo){
              if(str1.length()==index1||str2.length()==index2)
                       return "";

              if(str1.charAt(index1)==str2.charAt(index2)){
                  memo[index1][index2]= str1.charAt(index1)+lcs(str1,str2,index1+1,index2+1,memo);
                  return memo[index1][index2];
              }else{
                  String resA=lcs(str1,str2,index1,index2+1,memo);
                  String resB=lcs(str1,str2,index1+1,index2,memo);
                  if(resA.length()>resB.length()){
                      memo[index1][index2]=resA;
                      return memo[index1][index2];
                  }else{
                      memo[index1][index2]=resB;
                      return memo[index1][index2];
                  }
              }
    }

    public static void main(String[] args) {

        String str1="hey hows arse you is okk";
        String str2="hey how are you is ok";
        String memo[][]=new String[str1.length()][str2.length()];
       String lc= lcs(str1,str2,0,0,memo);
        System.out.println(lc);

    }
}
