package basicExercise;

import java.util.Scanner;

//查找整数
public class T2_FindInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		
		int n = reader.nextInt();
		int[] nArrays = new int[n];
		for(int i=0;i<n;i++)
		{
			nArrays[i] = reader.nextInt();
		}
		int a = reader.nextInt();
		
		for(int i=0;i<n;i++)
		{
			if(nArrays[i] == a)
			{
				System.out.println(i+1);
				break;
			}
			if(i == n-1)
			{
				System.out.println(-1);
			}
		}
	}

}
