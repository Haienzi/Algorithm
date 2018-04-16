package basic_exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Huffuman树
 * @author hppc
 *
 */
public class T2_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] nArray = new int[n];
		
		for(int i=0;i<n;i++) {
			nArray[i] = scanner.nextInt();
		}
		Arrays.sort(nArray);
		int s = 0;//费用
		int sum = nArray[0] + nArray[1];
		nArray[1] = sum;//暂存每次两个最小值的和
		s += sum;
		for(int i = 1;i<n-1;i++)
		{
			Arrays.sort(nArray,i,n); //对数组nArray起始下标i开始，到n-1的数据进行排序
			sum = nArray[i]+nArray[i+1];
			s+=sum;
			nArray[i+1] = sum;
		}
		System.out.println(s);	
	}

}
