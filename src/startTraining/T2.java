package startTraining;

import java.text.DecimalFormat;
import java.util.Scanner;

public class T2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double p = 3.14159265358979323;
		int n;
		double result;
		Scanner reader = new Scanner(System.in);
		n = reader.nextInt();
		
		if(n >= 1 && n <= 10000)
		{
			result = n * n * p;
			DecimalFormat dFormat = new DecimalFormat("###.0000000");
			System.out.println(dFormat.format(result));
		}
		
		
	}

}
