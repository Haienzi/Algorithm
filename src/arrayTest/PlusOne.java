package arrayTest;
/**
 * 给一个包含非负整数的数组，其中每个值代表该位数的值，对这个数加1。
 * @author mqh
 *
 */
public class PlusOne {
	public int[] getPlusOneArr(int[] nums)
	{
		int len = nums.length;
		int[] ansArr = new int[len+1];
	    
		int sum = 0;
		int c = 1 ;//存储进位值
		for(int i=len-1;i>=0;i--)
		{
			sum = nums[i] + c;
			if(sum%10 != 0)
			{
				c = sum / 10;
				ansArr[i] = sum%10;
			}else {
				ansArr[i+1] = nums[i];//最后一位直接
			}
		}
		if(c != 0)
		{
			ansArr[0] = c;
		}
		return ansArr;
	}
}
