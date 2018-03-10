package startTraining;

import java.util.Scanner;

public class T1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner reader = new Scanner(System.in);
		n = reader.nextInt();
		int f1 = 1,f2 = 1,f3 = 1;
		if(n >= 1 && n <= 1000000 ) {
			for(int i = 3;i<=n;i++)
			{
				f3 = (f1%10007+f2%10007)%10007;
				f1 = f2;
				f2 = f3;
			}
			System.out.println(f3);
		}
	}

}
