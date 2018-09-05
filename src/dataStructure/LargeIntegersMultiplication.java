package dataStructure;

import java.util.Scanner;
import java.util.function.IntPredicate;

/**
 * 大整数相乘基本数据类型无法保存 利用String保存数据
 * 分治算法
 * 计算每一位相乘的结果
 * A1A2 * B1B2 = A1B1 (A1B2+A2B1) A2B2
 * @author mqh 2018年9月4日
 *
 */
public class LargeIntegersMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String num1 = scanner.next();
			String num2 = scanner.next();
			String resultStr = multiply(num1, num2);
			System.out.println(resultStr);
			
		}

	}
	public static String multiply(String num1,String num2) {
		//把字符串反转后转化为char数组 方便处理为0前缀或者后缀
		char[] numArr1 = new StringBuffer(num1).reverse().toString().toCharArray();
		char[] numArr2 = new StringBuffer(num2).reverse().toString().toCharArray();
		
		//声明存放结果和两个乘数的容器
		int[] result = new int[numArr1.length + numArr2.length];
		int[] n1 = new int[numArr1.length];
		int[] n2 = new int[numArr2.length];
		
		//把char数组转换为int数组 减去‘0’得到的就是实际的数字
		for(int i=0;i<numArr1.length;i++)
		{
			n1[i] = numArr1[i] - '0';
		}
		for(int j=0;j<numArr2.length;j++) {
			n2[j] = numArr2[j] - '0';
		}
		//逐位相乘并保存
		for(int i=0;i<n1.length;i++)
		{
			for(int j=0;j<n2.length;j++)
			{
				result[i+j] += n1[i]*n2[j];
			}
		}
		
		//处理进位
		for(int i=0;i<result.length-1;i++) {
			result[i+1] += result[i]/10;
			result[i] = result[i]%10;
		}
		
		StringBuilder resultStr = new StringBuilder();
		for(int i=result.length-1;i>=0;i--)
		{
			if(result[i]!= 0)
			{
				resultStr.append(result[i]);
			}
		}
		return resultStr.toString();
		
	}

}
