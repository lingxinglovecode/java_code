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
        System.out.println(solution.numberToWords(12345678));
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



    String[] numStr_small = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine",
            "Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] numStr_medium = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] numStr_large = {"","Billion","Million","Thousand",""};

    String num2Str(int x){
        String result = "";
        if ( x>=100 ){
            int num = x/100;
            result = result+numStr_small[num]+" Hundred ";
            x %= 100;
        }
        if ( x>=20 ){
            int num2 = x/10;
            result = result+numStr_medium[num2]+" ";
            x %= 10;
        }
        if ( x>0){
            result = result+numStr_small[x]+" ";
        }
        return result;

    }
    public String numberToWords(int num) {
        if ( num==0 ) return "Zero";
        StringBuilder sb = new StringBuilder();

        for (int i = 1,j= (int) 1e9; i <= 4; i++,j /= 1000) {
            if ( num<j ) continue;
            int temp = num/j;
            sb.append(num2Str(temp));
            sb.append(numStr_large[i]+" ");
            num %= j;
        }

        return  sb.toString().trim();



    }
}