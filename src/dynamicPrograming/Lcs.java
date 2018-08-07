package dynamicPrograming;

import sort.A;

/**
 * 求最长公共子序列的长度
 * @author hppc
 * 
 * 求『最长』类的题目往往与动态规划有点关系，这里是两个字符串，故应为双序列动态规划。
这道题的状态很容易找，不妨先试试以f[i][j]表示字符串 A 的前 i 位和字符串 B 的前 j 位的最长公共子序列数目，
那么接下来试试寻找其状态转移方程。
从实际例子ABCD和EDCA出发，首先初始化f的长度为字符串长度加1，
那么有f[0][0] = 0, f[0][*] = 0, f[*][0] = 0, 最后应该返回f[lenA][lenB].
 即 f 中索引与字符串索引对应(字符串索引从1开始算起)，那么在A 的第一个字符与 B 的第一个字符相等时，
 f[1][1] = 1 + f[0][0], 否则f[1][1] = max(f[0][1], f[1][0])。
推而广之，也就意味着若A[i] == B[j], 则分别去掉这两个字符后，原 LCS 数目减一，
那为什么一定是1而不是0或者2呢？因为不管公共子序列是以哪个字符结尾，在A[i] == B[j]时 LCS 最多只能增加1.
 而在A[i] != B[j]时，由于A[i] 或者 B[j] 不可能同时出现在最终的 LCS 中，故这个问题可进一步缩小，
 f[i][j] = max(f[i - 1][j], f[i][j - 1]). 需要注意的是这种状态转移方程只依赖最终的 LCS 数目，
 而不依赖于公共子序列到底是以第几个索引结束。
 *
 */
public class Lcs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String aString = "ACBDEHGF";
		String bString = "BCAEF";
	    System.out.println(longestCommonSubsequence(aString, bString));
	}
	public static int longestCommonSubsequence(String a,String b)
	{
		if(a == null || a.length()==0)return 0;
		if(b == null || b.length() == 0) return 0;
		int lenA = a.length();
		int lenB = b.length();
		int[][] lcs = new int[1+lenA][1+lenB];
		
		for(int i=1;i<1+lenA;i++)
		{
			for(int j=1;j<1+lenB;j++)
			{
				if(a.charAt(i-1) == b.charAt(j-1))
				{
					lcs[i][j] = 1 + lcs[i-1][j-1];
				}else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		
		return lcs[lenA][lenB];
	}

}
