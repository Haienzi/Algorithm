package sort;

import java.util.Arrays;
import java.util.Scanner;

public class G {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		int m = reader.nextInt();//m组数据
	
		for(int i=0;i<m;i++)
		{
			int n = reader.nextInt();//n个小朋友
		
			JiMu[] jiMu = new JiMu[n];
			for(int j=0;j<n;j++)
			{
				int need = reader.nextInt();
				int have = reader.nextInt();
				jiMu[j] = new JiMu(need,have);
			}
		
			System.out.println(bank(jiMu));
			
		}
		
	}
	private static String bank(JiMu[] jiMus) {
		Arrays.sort(jiMus);
		int currentNeed = 0;
		for (int i = 0; i < jiMus.length; i++) {
			
				if (jiMus[i].need <= 0) {
					currentNeed += jiMus[i].have;
				} else { // childs[i].need > 0
					if (currentNeed >= jiMus[i].need) {
						currentNeed += jiMus[i].have;
					} else {
						return "NO";
					}
				}
			
		}
		return "YES";
	}
 
}
class JiMu implements Comparable<JiMu>{
	int have;
	int need;
	int total;
	public JiMu(int need,int have)
	{
		this.need = need;
		this.have = have;
		this.total = need+have;
	}
	@Override
	public int compareTo(JiMu o) {
		// TODO Auto-generated method stub
		return need - o.need;
	}
}
