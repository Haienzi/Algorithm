package sort;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner reader = new Scanner(System.in);
        String str = reader.nextLine();
        int start = reader.nextInt();
        int step = reader.nextInt();
        for(int i=start;i<str.length();)
        {
        	 System.out.print(str.charAt(i));
        	 i = i+step;
        }
       System.out.println();
	}


}
