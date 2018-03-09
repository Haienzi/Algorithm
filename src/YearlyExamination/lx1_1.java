package YearlyExamination;

/**
 * 矩阵翻硬币
 * 1.很容易得出，如果一枚硬币被翻了奇数次，那么它原来的状态肯定是反面朝上，所以，我们要找的就是被翻了奇数次的硬币

2. Q 操作的定义：将所有第 i*x 行，第 j*y 列的硬币进行翻转。正向看可能不好想，那么我们反向看一下，对于一个横坐标为N的硬币，
在翻哪些硬币（横坐标x）的时候会翻到它呢？其实就是这个数N所有的约数，比如横坐标为4的硬币，那么，在翻横坐标为1，2，4的硬币时都会翻到它，
纵坐标的情况是一样的。

3.对于一个硬币，我们必须同时考虑其横坐标x和纵坐标y，假如横坐标被翻了a次，纵坐标被翻了b次，则这个硬币总共被翻了a*b次，
若想要这个硬币被翻奇数次，a和b必须都得是奇数，即x和y都有奇数个约数

4.那么问题来了：哪些数有奇数个约数呢？不管你知不知道，反正现在你知道了，完全平方数有奇数个约数。那么什么又是完全平方数呢，
简单的说就是n^2，n为自然数，也就是0，2，4，9……

5.问题又来了，怎么求完全平方数的个数呢，首先，我们已经知道了这个矩阵式n*m的，而且是从1开始编号的，对于n，我们可以求sqrt（n）
，然后取整，容易想出，在1-n的范围内的完全平方数的个数为（int）（sqrt（n））个，而sqrt（n）*sqrt（m）就是所有的横纵坐标都是完全平方数的硬币的个数。
 */

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class lx1_1 {
	public static void main(String[] args) {
	     Scanner reader = new Scanner(System.in);
	     String n = reader.next();
	     String m = reader.next();
	     
	     BigInteger nSqrt = BigSqrt(n);
	     BigInteger mSqrt = BigSqrt(m);
	     
	     BigInteger ans = nSqrt.multiply(mSqrt);
	     System.out.println(ans);
		
	}
	private static BigInteger BigSqrt(String s)
	{
		int mlen = s.length();//被开方数的长度
		int sqrtlen;//开方后数据的长度
		BigInteger bgSqrtNum = new BigInteger(s);//被开方数
		BigInteger sqrtOfNum;//存储开方后的数
		BigInteger sqrtOfNumMul;//开方数的平方
		String sString;//存储开方的数据转化后的字符串
		if(mlen%2 == 0) {
			sqrtlen = mlen/2;
		}else {
			sqrtlen = mlen/2 + 1;
		}
		
		//存储开方后的数据
		char[] cArray = new char[sqrtlen];
		Arrays.fill(cArray, '0');//填充0
		
		//从最高位开始依次遍历数组，利用牛顿逼近法，求出开方后的每一位上的数字
		for(int i = 0;i< sqrtlen;i++ )
		{
			for(char num = '1';num<='9';num++)
			{
				cArray[i] = num;
				sString = String.valueOf(cArray);
			    sqrtOfNum = new BigInteger(sString);
			    sqrtOfNumMul = sqrtOfNum.multiply(sqrtOfNum);//相乘
			    if(sqrtOfNumMul.compareTo(bgSqrtNum) == 1) {
			    	cArray[i] -= 1;
			    	break;
			    }
			}
		}
		
		return new BigInteger(String.valueOf(cArray));
	}
}
