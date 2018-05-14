
package basic_exercise;

import java.awt.image.SinglePixelPackedSampleModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/***
 * 特殊的回文串
 * @author mqh
 *
 */
public class T2_PalindromeString {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		ArrayList<Integer> aIntegers = new ArrayList<>();
		
		for(int i=0;i<10;i++)
		{
			for(int j = 0;j<10;j++)
			{
				for(int k = 0;k<10;k++)
				{
					if(2*i+2*j+k == n)
					{
						aIntegers.add(i*10000+j*1000+k*100+j*10+i);
					}
					if(2*i+2*j+2*k == n)
					{
						aIntegers.add(i*100000+j*10000+k*1000+k*100+j*10+i);
					}
				}
			}
		}
		Collections.sort(aIntegers);
		for(int i=0;i<aIntegers.size();i++)
		{
			System.out.println(aIntegers.get(i));
		}
	}
	
}
