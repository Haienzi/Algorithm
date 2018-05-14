package basicExercise;

/**
 * 字母图形
 * @author mqh
 *
 */
import java.util.Scanner;

public class T2_Alphabetic_graphics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		int m = reader.nextInt();
		char[] alpahs = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
				'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		for(int i = 1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				char s = alpahs[(Math.abs(i-j))%26];
				System.out.print(s);
			}
			System.out.println();
		}
	}

}
