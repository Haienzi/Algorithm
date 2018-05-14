package basicExercise;
/***
* 特殊的回文串
* @author mqh
*
*/
import java.util.Scanner;

public class T2_PalindromeS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		
		//先计算5位数
	    for (int i = 10000; i < 100000; i++)  
	    {  
	        int a = i / 10000;  
	        int b = (i % 10000) / 1000;  
	        int c = (i % 1000) / 100;  
	        int d = (i % 100) / 10;  
	        int e = i % 10;  
	        if (a == e && b == d && a+b+c+d+e == n)  
	        	System.out.println(i); 
	    }  
	    //然后计算6位数的
	    for (int i = 100000; i < 1000000; i++)  
	    {  
	        int a = i / 100000;  
	        int b = (i % 100000) / 10000;  
	        int c = (i % 10000) / 1000;  
	        int d = (i % 1000) / 100;  
	        int e = (i % 100) / 10;  
	        int f = i % 10;  
	        if (a == f && b == e && c == d && a+b+c+d+e+f == n)  
	        	System.out.println(i);
	    } 
	}

}
