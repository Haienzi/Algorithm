package niuke;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * 约数的个数
 * 
 * @author mqh 2018年8月31日
 *
 */
public class ApproximateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext())
		{
			int n = scanner.nextInt();
			for(int i=0;i<n;i++)
			{
				int approximateCount = 0;
				int number = scanner.nextInt();
				
				if(number == 1)
				{
					approximateCount = 1;
					break;
				}else {
					approximateCount = 2;
				}
				
				for (int j = 2; j*j<number; j++) {
					//If divisibility can be divided, the number of integers plus two,
					//one is less than sqrt(number), and the other is greater than sqrt(number)
					if(number%j == 0)
					{
						approximateCount += 2;
					}
				}
				
				System.out.println(approximateCount);
			}
		}
	
		
		
	}

}
