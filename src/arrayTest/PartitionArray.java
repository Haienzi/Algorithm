package arrayTest;
/**
 * Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
 *All elements < k are moved to the left
 *All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.
Notice
You should do really partition in array nums instead of just counting the numbers of integers smaller than k.
If all elements in nums are smaller than k, then return nums.length
 * @author mqh
 * 
 * 快速排序的基本思想
 * 1、先从数组中取出一个数作为基数
 * 2、分区过程，将比这个数大的放在它的右边，小的则放在它的左边
 * 3、再对左右区间重复第二步
 * 
 * 挖坑填数 + 分治
 *
 */
public class PartitionArray {
	/**
	 * 对换数组中索引为i和j的值
	 * @param i
	 * @param j
	 * @param arr
	 */
	private void swap(int i,int j,int[] arr)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	/**
	 * 返回数组中第一个小于数据k的索引
	 * @param arr
	 * @param k
	 * @return
	 */
	public int partitionGetIndex(int[] arr,int k)
	{
		int start = 0;
		int end = arr.length-1;
		while (start<=end) {
			while(start<=end && arr[start]<k)//如果左边的数据小于k值 则一直向右递归
			{
				start++;
			}
			while(start<=end && arr[end]>=k)//如果右边的数据大于k值 则一直向左递归
			{
				end--;
			}
			if(start<=end)
			{
				swap(start, end, arr);
				start++;
				end--;
			}
		}
		return start;
	}
	
}
