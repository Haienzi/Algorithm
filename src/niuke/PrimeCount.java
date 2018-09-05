package niuke;

import java.util.Scanner;
/**
 * 质因数的个数
 * @author mqh 2018年8月31日
 *
 */
public class PrimeCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext())
        {

            long number = scanner.nextInt();
        	long count = 0;
        	//sqrt is the key
        	for(int i=2;i<Math.sqrt(number);i++) {
        		//Cycle elimination operation without judging prim numbers
        		while (number % i==0) {
					number = number /i;
					count++;
				}
        		if(number<=1) {
        			break;
        		}
        	}
        	if(number >1) {
        		count++;
        	}
        	System.out.println(count);
        }
	}

}
