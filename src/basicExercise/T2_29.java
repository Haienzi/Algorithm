/***
 * 高精度加法
 */
package basicExercise;

import java.util.Scanner;

public class T2_29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		String a = reader.nextLine();
		String b = reader.nextLine();
		
		int[] aArray = new int[101];
		int[] bArray = new int[101];
		
		//将字符串转化为整数 -48减去字符‘0’的ASCII
		for (int i = 0; i < a.length(); i++) 
			aArray[i]=(int)a.charAt(a.length()-1-i)-48;  
        for (int i = 0; i < b.length(); i++) 
        	bArray[i]=(int)b.charAt(b.length()-1-i)-48;
		
		int len = a.length() > b.length() ? a.length():b.length();
		int[] rArray = new int[len+1];//存储相加的结果 长度比最大值加1 非常重要 因为原最高位相加可能产生进位
		int c = 0;//暂存进位
		for(int i=0;i<=len;i++)
		{
			rArray[i] = (aArray[i] + bArray[i] + c);
			c = rArray[i]/10;
			rArray[i] = rArray[i]%10;
		}
		if(rArray[len] != 0)
		{
			System.out.print(rArray[len]);
		}
		for(int i=len-1;i>=0;i--)
		{
			System.out.print(rArray[i]);
		}
		System.out.println();
	
	}

}
