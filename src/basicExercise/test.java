package basicExercise;

import java.sql.Date;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0,b = 0;
		try {
			
			a = Integer.parseInt(args[0]);
			b = Integer.parseInt(args[1]);
		   int m = a +b;
		 
		}catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		System.out.println("请输入两个数");
		System.out.println(a);
		System.out.println(b);
	}

}
