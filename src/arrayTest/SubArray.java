package arrayTest;
/**
 * 
 * @author mqh
 * Given an integer array, find a subarray where the sum of numbers is zero. 
 * Your code should return the index of the first number and the index of the last number.
   Example
   Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
   给定一个整数数组，找到和为零的子数组。你的代码应该返回满足要求的子数组的起始位置和结束位置
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntPredicate;

public class SubArray {
	/**
	 * 记录每一个位置的sum存入HashMap中，如果某一个sum已经出现过，说明中间的subArray的sum为0
	 * 时间复杂度O(n) 控件复杂度O(n)
	 */
	/**
	 * A list of integers
	 * @param nums 
	 * @return A list of integers includes the index of the first number and the last number
	 */
	public ArrayList<Integer> subArraySum(int[] nums)
	{
		int len = nums.length;
		ArrayList<Integer> indexSubArr = new ArrayList<>();
		HashMap< Integer, Integer> sumMap = new HashMap<>();
		
		sumMap.put(0, -1);//save the sum 0 first 为了和下面的加一相一致
		
		int sum = 0;
		for(int i=0;i<len;i++)
		{
			sum += nums[i];
			
			if(sumMap.containsKey(sum))
			{
				indexSubArr.add(sumMap.get(sum)+1);//注意这里要加一 因为是从上一个sum的数据之后的一个开始
				indexSubArr.add(i);
				return indexSubArr;
			}
			sumMap.put(sum, i);
		
		}
		return null;
	}
}
