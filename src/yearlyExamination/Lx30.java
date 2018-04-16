package yearlyExamination;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.text.GapContent;

public class Lx30 {

	static int N = 1010;
	static int M = 100000007;
	static int g = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n,s,a,b;
        int[][] c = new int[2][N*N];
		Scanner  reader = new Scanner(System.in);
		n = reader.nextLong();
		s = reader.nextLong();
		a = reader.nextLong();
		b = reader.nextLong();
		int cnt = 0;
		long i,j;
		for(i = 0;i<=n*(n-1)/2;i++)
		{
			j = s-i*a+(n*(n-1)/2 - i)*b;
			if(j%n == 0)
			{
				cnt = (cnt+c[g][(int) i])%M;
			}
		}
		System.out.println(cnt);
	}
	public static void dp(int[][] c)
	{
		int i,j;
		Arrays.fill(c, 0);
		c[g][0] = 1;
		for(i = 1;i<N;i++)
		{
			g = 1-g;
			for(j = 0;j<i*(i+1)/2;j++)
			{
				if(i>j) {
					c[g][i] = c[1-g][j-1];
				}else {
					c[g][i] = (c[1-g][j]+c[1-g][j-1])%M;
				}
			}
		}
		
	}

}
