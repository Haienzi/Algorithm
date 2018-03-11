package yearlyExamination;

import java.util.Scanner;

public class Lx33_LantonAnt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] direction = new String[] {"U","R","D","L"};
		
		Scanner reader = new Scanner(System.in);
		int m = reader.nextInt();
		int n = reader.nextInt();
		int[][] nArray = new int[m][n];
		for(int i=0;i<m;i++)
		{
			for(int j =0;j<n;j++)
			{
				nArray[i][j] = reader.nextInt();
			}
		}
		int x = reader.nextInt();
		int y = reader.nextInt();
		String s = reader.next();
		int k = reader.nextInt();
		int d = 0;//记录方向在数组中的下标
		for(int i=0;i<4;i++)
		{
			if(direction[i].equals(s))
			{
				d = i;
			}
		}
		//System.out.println("d "+direction[d]);
		Ant ant = new Ant(x,y);
		for(int i=0;i<k;i++)
		{
			//发现规律 如果是白格的话 方向数组下标递减就是旋转后的方向
			//黑格时，方向数组下标递增就是旋转后的方向
			//System.out.println("nArray[x][y]"+nArray[x][y]);
			if(nArray[ant.x][ant.y] == 0)
			{
				nArray[ant.x][ant.y] = 1;
				d = (d-1+4)%4;//得到旋转后的方向下标
				s = direction[d];
				goWalk(ant, s, m, n);//移动
			}else {
				nArray[ant.x][ant.y] = 0;
				d = (d+1)%4;
				s = direction[d];
				goWalk(ant, s, m, n);
			}
			//System.out.println(ant.x + " " + ant.y);
		}
		
	    System.out.println(ant.x+" " +ant.y);
	    
	}
    public static void goWalk(Ant ant,String s,int m,int n) {
    	switch(s)
    	{
    	   case "U":
    		   ant.x = (ant.x-1+m)%m;
    		   break;
    	   case "L":
   		       ant.y= (ant.y-1+n)%n;
   		   break;
    	   case "D":
    		   ant.x = (ant.x+1)%m;
   		   break;
    	   case "R":
    		   ant.y = (ant.y+1)%n;
   		   break;
   		   default:
   			   break;   		   
    	}
   }
}
class Ant{ 
	/**
	 * 蚂蚁坐标类，用于保存蚂蚁移动时的横纵坐标
	 */
	public int x;//横坐标
	public int y;//纵坐标
	public Ant(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
}