/**
 * 数列特性
 */
package basic_exercise;

import java.util.Arrays;
import java.util.Scanner;

public class T2_NumberOfFeatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		
		int n = reader.nextInt();
		int[] nArrays = new int[n];
		for(int i=0;i<n;i++)
		{
			nArrays[i] = reader.nextInt();
		}
		reader.close();//关闭输入流
		Arrays.sort(nArrays);
		int sum = 0;
		for(int i=0;i<n;i++)
		{
			sum += nArrays[i];
		}
		System.out.println(nArrays[n-1]);
		System.out.println(nArrays[0]);
		System.out.println(sum);
	}

}
