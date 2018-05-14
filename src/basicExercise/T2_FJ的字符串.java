package basic_exercise;

import java.util.Scanner;

public class T2_FJ的字符串 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		System.out.println(fun(n));
	}
    public static String fun(int n)
    {
    	if(n == 1)
    	{
    		return "A";
    	}else {
    		return fun(n-1)+String.valueOf((char)('A'+n-1))+fun(n-1);
    	}
    }
}
