/***
 * 阶乘练习
 * 1、1000的阶乘的结果有多少位
 * 1*2*3*4*5*....*1000的位数 = log1 + log2 + log3 +....+log1000
 * 有2568位 确定数组的长度大概是
 */
package basic_exercise;

import java.util.Arrays;
import java.util.Scanner;


public class T2_30_Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		int[] nArray = new int[3000];
		Arrays.fill(nArray, 0);
		nArray[0] = 1;
		int r;//保存进位值
		int re = 0;//保存当前位的结果
	    for(int i=2;i<=n;i++)
	    {
	    	r = 0;
	    	for(int j = 0;j<nArray.length;j++)
	    	{
	    		re = (nArray[j]*i+r);
	    		nArray[j] = re%10;
	    		r = re/10;
	    	}
	    	
	    }
	    int rSign =0;//前置0和结果之间的界限
	    for(int i = nArray.length-1;i>=0;i--)
	    {
	    	if(nArray[i]!=0)
	    	{
	    		rSign = i;
	    		break;
	    	}
	    }
	    for(int i= rSign;i>=0;i--)
	    {
	    	System.out.print(nArray[i]);
	    }
	    System.out.println();
	}

}
