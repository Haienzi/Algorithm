package arrayTest;

import java.util.ArrayList;

public class TestArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] arr = new int[]{5,2,9,8,7,12,14,11,4};
       PartitionArray partitionArray = new PartitionArray();
       int index = partitionArray.partitionGetIndex(arr, 7);
       System.out.println("获取快速排序中第一个小于7的Index: "+index);
       
       int[] arr1 = new int[]{-3,1,2,-3,4};
       SubArray subArray = new SubArray();
       ArrayList<Integer> arrayList = subArray.subArraySum(arr1);
       System.out.println("获取数组中和为0的子数组: "+"["+arrayList.get(0)+","+arrayList.get(arrayList.size()-1)+"]");
	}
    
}