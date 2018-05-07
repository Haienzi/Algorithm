package sort;

import java.util.Scanner;
/**
 * 二叉树遍历
 * @author hppc
 *
 */
public class A {

	private static char[] midChars,lateChars,beforeChars;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		midChars = reader.nextLine().toCharArray();
	    lateChars = reader.nextLine().toCharArray();
		beforeChars = new char[midChars.length];
		getBefore(0, midChars.length-1, lateChars.length-1, 0);
		beforeChars.toString();
		System.out.println(beforeChars);
		
	}
	/**
	 * 获取先序排列
	 * @param midStart 中序起始位置
	 * @param midEnd  中序终止位置
	 * @param lateIndex 后序根节点位置
	 * @param beforeIndex 填充的先序位置
	 */
	private static void getBefore(int midStart, int midEnd, int lateIndex, int beforeIndex) {
		if (midStart > midEnd) return;//左子树或右子树遍历完
		for (int i = midStart; i <= midEnd; i++) {
			if (midChars[i] == lateChars[lateIndex]) {//找到根节点
				beforeChars[beforeIndex] = midChars[i];
			    //(midEnd - i + 1) 找到根节点后 中序右子树结点最后一个的索引  
				//lateIndex - (midEnd - i + 1) 找到后序中左结点的位置
				//beforeIndex + (i - midStart + 1) 左子树结点的个数
				getBefore(midStart, i - 1, lateIndex - (midEnd - i + 1), beforeIndex + 1);//寻找左子树的根结点
				getBefore(i + 1, midEnd, lateIndex - 1, beforeIndex + (i - midStart + 1));//寻找右子树的结点
				return;
			}
		}
	}


}
