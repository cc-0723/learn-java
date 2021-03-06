public class Solution {
    public int numDistinct(String S, String T) {
        int sLen = S.length();
        int tLen = T.length();
        int[] numDis = new int[tLen + 1];
        numDis[0]= 1;
        for(int i = 1; i <= tLen; ++i){
            numDis[i] = 0;
       }
        for(int i = 1; i <= sLen; ++i){
            for(int j = tLen; j > 0; --j){
                if(S.charAt(i - 1) == T.charAt(j - 1)){
                    numDis[j] = numDis[j] + numDis[j - 1];
               }
           }
       }
        return numDis[tLen];
   }
}