package basicExercise;

import java.util.Arrays;
import java.util.Scanner;
//注意空格输出
public class YHTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		int[][] arr = new int[n][n];
		for(int i = 0;i<n;i++)
		{
			Arrays.fill(arr[i], 1);
		}
		for(int i=2;i<n;i++) {
			for(int j=1;j<i;j++)
			{
				arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}
		}
		for(int i=0;i<n;i++)
		{
			int j = 0;
			for(;j<i;j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println(arr[i][j]);
		}
	}

}
