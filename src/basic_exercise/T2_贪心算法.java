/**
 * 完美的代价
 * @ author mqh
 */
package basic_exercise;

import java.util.Scanner;

public class T2_贪心算法 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		char[] sArray = new char[n];
		sArray= reader.next().toCharArray();
		
		int sum = palindrome(sArray, n);
		if(sum == -1)
		{
			System.out.println("Impossible");
		}else {
			System.out.println(sum);
		}
		
	
	}
	public static int palindrome(char[] cArray,int n) {
		int sum = 0;//记录变换的次数 -1表示不能转化为回文串
		int c = -1;//记录cArray[i]是否是唯一无法匹配的字符
		int len = n-1;
		for(int i=0; i<n;i++)//从左向右依次判断
		{
			for(int j = len;j>=i;j--)//从右向左依次查找
			{
				if(j == i) //如果没有找到相匹配的字符
				{
					if(n%2 == 0 || c !=-1) //如果字符串长度为偶数，或cArray[i]是唯一无法匹配的字符
					{
						sum = -1; //说明该字符串无法转换为回文串
						break;
					}
					c = 1;//否则 n为奇数 cArray[i]为第一个无法匹配的字符串
					sum += n/2 - i;//移动到中间所需次数
					break;
				}
				if(cArray[j] == cArray[i])
				{
					for(int k = j; k<len;k++) //注意此步 将字符向后移动到对称位置
					{
						cArray[k] = cArray[k+1];
					}
					sum += len - j;
					len--; //下次查找从已经排好的下一位开始遍历
					break;
				}
			}
			if(sum == -1)
			{
				break;
			}
		}
		return sum;
		
	}

}
