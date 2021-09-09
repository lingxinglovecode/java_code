/**
 * @author lianxing
 * @create 2021-09-04 14:38
 */
public class Algorithm_String {
    public static void main(String[] args) {
//        String myString = " 31 3 ";
        String myString = "abcdefg";
        Soulution solution = new Soulution();
        System.out.println(solution.trimMethod(myString));
        String B = solution.trimMethod(myString);
        String A = myString.trim();
        System.out.println(myString.trim());
        System.out.println(solution.reverseString(myString,2,4));

        String s1 = "abk";
        String s2 = "abkkcadkabkebfkabkskab";
        System.out.println(solution.countString(s2,s1));


    }







}

class Soulution{
    //1.模拟一个trim方法，去除字符串两端的空格。
    public String trimMethod(String string){
        int start = 0;
        int end = 0;
        boolean end_flag = false;
        for (int i = 0; i < string.length() ; i++) {
            if (string.charAt(i) == ' ') {
                continue;
            }
            start = i;
            break;
        }
        for (int i = string.length()-1; i > 0 ; i--) {
            if (string.charAt(i) == ' ') {
                continue;
            }
            end = i;
            break;
        }
        String result = string.substring(start,end+1);
        if(result.charAt(start) == ' '){
            return "";
        }
        return result;

    }

    //2.将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
    public String reverseString(String string,int start,int num){

        char[] result = string.toCharArray();
        char temp;
        int end = start + num-1;
        while(start<end){
            temp = result[start];
            result[start] = result[end];
            result[end] = temp;
            start++;
            end--;
        }


        return new String(result);




    }

    //3.获取一个字符串在另一个字符串中出现的次数
    public int countString(String string1,String string2){
        char[] s1 = string1.toCharArray();
        char[] s2 = string2.toCharArray();
        int count = 0;
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] == s2[0]){
                for (int j = 0; j < s2.length; j++) {
                    if ( i+j>=s1.length || s1[i+j] != s2[j]){
                        break;
                    }else if (j == s2.length-1){
                        count++;
                    }
                }


            }
        }
        return count;


    }

    //4.获取两个字符串中最大相同子串。

}

