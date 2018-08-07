package dynamicPrograming;

/**
 * 寻求子序列
 * @author mqh
 *
 */
public class DistinctSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "rabbbit";
		String t = "rabbit";
		numDistincts(s, t);
		System.out.println(numDistincts(s, t));

	}
    public static int numDistincts(String S,String T)
    {
    	int[][] table = new int[S.length()+1][T.length()+1];
    	
    	for(int i=0;i<S.length();i++)
    	{
    		table[i][0] = 1;
    	}
    	for(int i=1;i<=S.length();i++)
    	{
    		for(int j=1;j<=T.length();j++)
    		{
    			if(S.charAt(i-1) == T.charAt(j-1)){
    				table[i][j] += table[i-1][j-1]+table[i-1][j];
    			}else {
					table[i][j] += table[i-1][j];
				}
    		}
    	}
    	 return table[S.length()][T.length()];
    	
    }
}
