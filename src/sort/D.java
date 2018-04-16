package sort;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner reader = new Scanner(System.in);
        long n = reader.nextLong();
        System.out.println(getFn(n, 1)%99999999);
        System.out.println(getFn(n, 2)%99999999);
	}
    public static long getFn(long n,int k)
    {
    	if((n == 1 && k == 1))
    	{
    		return 2;
    	}else if(n ==1 && k ==2) {
    		return 3;
    	}else if(n ==2 && k==1)
    	{
    		return 1;
    	}else if(n == 2 && k==2)
    	{
    		return 4;
    	}else if(n==3 && k==1)
    	{
    		return 6;
    	}else if(n==3 && k ==2)
    	{
    		return 5;
    	}else if(k == 1)
    	{
    		return (getFn(n-1, 2)%99999999+2*getFn(n-3, 1)%99999999+5);
    	}else
    	{
    		return (getFn(n-1, 1)%99999999+3*getFn(n-3, 1)%99999999+2*getFn(n-3, 2)%99999999+3);
    	}
    }
    
}
