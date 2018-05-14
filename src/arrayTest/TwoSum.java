package arrayTest;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * @author mqh
 *
 */
public class TwoSum {
     public int[] getTwoSum(int target,int[] nums)
     {
    	 //存放 （key）目标值减去当前值  value 当前值的索引
    	 HashMap<Integer, Integer> subMap = new HashMap<>();
  
    	 for(int i=0;i<nums.length;i++)
    	 {
    		if(subMap.get(nums[i])!= null)
    		{
    			int[] result = {subMap.get(nums[i]),i};
    			return result;
    		}
    		subMap.put(target-nums[i], i);
 
    	 }
    	 int[] resultEmpty = {};
    	 return resultEmpty;
     }
}
