package Algorithms;

import org.junit.Test;

import java.math.BigInteger;
import java.util.HashSet;

/**
 * @author lianxing
 * @description
 * @create 2021-09-24 8:33
 */
public class Math_Problem {
    private static MathSolution mathSolution = new MathSolution(2);

    @Test
    public void testMath(){
//        MathSolution mathSolution = new MathSolution(3);
        mathSolution.isHappy2(2);
        mathSolution.trailingZeroes(30);

        char a = "a".charAt(0);
        System.out.println((int)a);

        mathSolution.myPow3(2,-2147483648);

    }
}


class MathSolution {
    private static int a;

    public MathSolution(int a) {
        this.a = a;
    }

    public MathSolution() {

    }
    //题目1：快乐数

    //方法1：遍历+哈希表，每一次遍历将所有不快乐的数放进哈希监狱，如果下一个数有前科的话那就太不快乐了
    public boolean isHappy(int n) {
        HashSet hashPrison = new HashSet();
        while (!hashPrison.contains(n)) {
            int sum = 0;
            hashPrison.add(n);
            while (n % 10 != 0 || n / 10 != 0) {
                int i = n % 10;
                sum = sum + i * i;
                n = n / 10;
            }
            if ( sum != 1 ) {
                n = sum;
            } else {
                return true;
            }
        }
        return false;
    }

    //-方法2：快慢指针判断循环结构
    public int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int i = n % 10;
            sum = sum + i * i;
            n = n / 10;
        }
        return sum;

    }

    public boolean isHappy2(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;

    }

    //问题2：阶乘后的零
    //https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xwehi5/

    //方法1：直接计算阶乘以后的结果然后数0的个数，如果结果使用long型存储会超出存储范围
    public int trailingZeroes(int n) {
        long result = 1;
        for (int i = 1; i < n + 1; i++) {
            result = result * i;
        }

        int zeroNum = 0;
        while (result > 0) {
            if ( (result % 10) == 0 ) {
                zeroNum += 1;
                result = result / 10;
            } else {
                break;
            }

        }
        return zeroNum;
    }

    //使用BigInteger,好吧会超时
    public int trailingZeroes2(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i < n + 1; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        int zeroNum = 0;
        while (result.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            result = result.divide(BigInteger.TEN);
            zeroNum += 1;
        }
        return zeroNum;
    }

    //方法2：计算所有因子中5的个数，因为一个2*5就代表结尾一个0，而2的因子数量远远大于5所以只需要统计5的
    public int trailingZeroes3(int n) {
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            int num = i;
            while (num % 5 == 0) {
                count += 1;
                num /= 5;
            }
        }

        return count;
    }

    //方法2改进，计算n里面有多少个5然后加上n里面有多少个25加上n里面有多少个125依次类推
    public int trailingZeroes4(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }


    //问题3：Excel表列序号
    //https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xweb76/
    //这种题一个方法就够了，直接从后开始往前进行遍历计算即可
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        int power = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int count = columnTitle.charAt(i) - 'A' + 1;
            sum = sum + count * power;
            power = power * 26;

        }
        return sum;

    }


    //问题4：Pow(x,n)
    //https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xwo102/

    //方法1：暴力解法，超时
    public double myPow(double x, int n) {
        if ( n == 0 ) {
            return 1;
        }
        long times = Math.abs((long) n);
        int sign = 1;
        if ( n < 0 ) {
            sign = -1;
        }
        double result = 1.0;
        for (int i = 0; i < times; i++) {
            result = result * x;
        }

        return sign == 1 ? result : 1 / result;

    }


    //方法2：快速幂+递归调用
    public double myPowHelp(double x, int n) {
        if ( n == 0 ) {
            return 1.0;
        }
        double temp = myPowHelp(x, n / 2);
        return n % 2 == 0 ? temp * temp : temp * temp * x;
    }

    public double myPow2(double x, int n) {
        long times = (long) n;
        return times>0?myPowHelp(x,n):1/myPowHelp(x,-n);
    }

    //方法3：快速幂+迭代
    public double myPow3(double x, int n) {
        long N = n;
        return n>0?quickMul(x,n):1/quickMul(x,-n);
    }
    public double quickMul(double x,long N){
        double ans = 1;
        double contribute = x;
        while(N>0){
            if ( N%2==1 ){
                ans = ans*contribute;
            }
            contribute = contribute*contribute;
            N = N>>1;
        }
        return ans;



    }





}