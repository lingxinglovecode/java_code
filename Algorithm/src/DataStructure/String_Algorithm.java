package DataStructure;

import org.junit.Test;

/**
 * @author lianxing
 * @description
 * @create 2021-09-25 12:09
 */
public class String_Algorithm {
    private static StringSolution solution= new StringSolution();

    @Test
    public void test1(){
        System.out.println(solution.minDistance("intention","execution"));

    }

}

class StringSolution {
    public int minDistance(String word1, String word2) {
        if ( word1.length()>word2.length() ){
            String temp =  word1;
            word1 = word2;
            word2 = temp;
        }
        int max = 0;
        int index = -1;
        for (int i = 0; i < word1.length(); i++) {

            if(word2.contains(word1.substring(i,i+1))){
                for (int j = index+1; j < word2.length(); j++) {
                    if ( word2.charAt(j)==word1.charAt(i) ){
                        index = j;
                        max += 1;
                        break;
                    }
                }

            }

        }

        return word1.length()+word2.length()-2*max;



    }
}