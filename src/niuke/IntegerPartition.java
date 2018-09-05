package niuke;

import java.util.Scanner;

/**
 * 整数拆分
 * @author mqh 2018年9月2日
 * 题目描述
一个整数总可以拆分为2的幂的和，例如： 7=1+2+4 7=1+2+2+2 7=1+1+1+4 7=1+1+1+2+2 7=1+1+1+1+1+2
 7=1+1+1+1+1+1+1 总共有六种不同的拆分方式。 再比如：4可以拆分成：4 = 4，4 = 1 + 1 + 1 + 1，4 = 2 + 2
 ，4=1+1+2。
 用f(n)表示n的不同拆分的种数，例如f(7)=6. 要求编写程序，读入n(不超过1000000)，输出f(n)%1000000000。
 
 f(2m+1) = f(2m);
 f(2m) = f(2m-1)+f(m);
 如果n是偶数，f(n)= f(n-1)+f(n/2)
如果n是奇数，f(n) = f(n-1)
 *
 */
public class IntegerPartition {

	static int[] integerSplitArr = new int[1000005];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		setIntegerPartion(integerSplitArr);
        while (scanner.hasNext()) {
			int n = scanner.nextInt();
			System.out.println(integerSplitArr[n]);
			
		}		
	}
    
	public static void setIntegerPartion(int[] arr) {
		arr[1]=1;
		for(int i=2;i<arr.length;i++)
		{
			if(i%2 == 0) //n是偶数
			{
				arr[i] = (arr[i-1]+arr[i/2])%1000000000;
			}else {//n是奇数
				arr[i] = arr[i-1]%1000000000;
			}
		}
	}
}
