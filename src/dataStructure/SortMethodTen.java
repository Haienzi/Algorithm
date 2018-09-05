package dataStructure;
/**
 * 
 * @author mqh
 * 冒泡排序思想：
 * (1)依次比较相邻的元素（从开始一对到最后一对），如果第一个比第二个大，就交换。
 * (2)完整的一趟比较（n-1）次之后，最后一个是最大的
 * (3)重复操作(1)，不用比较最后一个。
 * 比较次数：第一次n-1
 *        第二次n-2
 *          ...
 * 最差情况o(n)=n2;
 *
 */

import java.util.Arrays;
import java.util.function.IntPredicate;

import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

public class SortMethodTen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {15,12,48,23,57,41,12,10,19,27,25,29};
		System.out.print("排序前：");
        for (int i : nums) {
			System.out.print(i+" ");
		}
	    System.out.println(); 
	    System.out.print("排序后：");
        qSort(nums,0,nums.length-1);
        for (int i : nums) {
			System.out.print(i+" ");
		}
        
	}
	//冒泡排序
	public void bubbleSort(int[] a,int n)
	{
		boolean flag = true;
		for(int i=0;i<n-1&&flag;i++)
		{
			//用flag作为标记，标记数组是否已经排序完成
			flag = false;
			for(int j= 0;j<n-1-i;j++)
			{
				if(a[j]>a[j+1]) //每次将最大值放在后面
				{
					swap(a, j, j+1);
					flag = true;
				}
			}
		}
	}
	//交换两个元素 如果交换前a[i]>a[j]交换后结果a[i]<a[j] 
	private static void swap(int[] a,int i,int j)
	{
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
	//选择排序
	/**
	 * 表现最稳定的排序算法
	 * 无论什么数据进去都是o(n2)的时间复杂度
	 * 原理：首先在未排序序列中找到最小元素，存放到排序序列的起始位置，然后从剩余位置继续找最小的元素
	 * @param array
	 */
	public void selectionSort(int[] array)
	{
		 long start = System.nanoTime();  
		    int len = array.length;  
		    int minIndex = 0;  
		    for(int i = 0; i < len - 1 ; i++) {  
		        minIndex = i;  
		        for(int j = i + 1; j < len; j++) {  
		            if(array[j] < array[minIndex]) {  
		                minIndex = j;  
		            }  
		        }  
		        int tmp = array[minIndex];  
		        array[minIndex] = array[i];  
		        array[i] = tmp;  
		    }  
		    long end = System.nanoTime();  
		    System.out.println((end - start)/1000.0 + "ms");
	}
    
    //插入排序
	public static void insertSort(int[] array) {
	   int current;
	   for(int i=0;i<array.length-1;i++)
	   {
		   //取出下一个元素作为待排序的数据
		   current = array[i+1];
		   //保存已经排好序的最后一个数据的索引
		   int preIndex = i;
		   //遍历已经排好序的数据 如果新的数据小于已经排好序中的数据 则将数据向后移动直到没有小于新的数据
		   while (preIndex>=0&&current<array[preIndex]) {
			array[preIndex+1] = array[preIndex]; 
			preIndex--;
		   }
		   //将新数据插入到合适的位置
		   array[preIndex+1] = current;
	   }
	}
	//希尔排序 每组数据插入排序
	public static int[] shellSort(int[] array) {
		int  len = array.length;
		int temp,gap = len/2;//初始化增量序列初值
		
		//增量值大于0则一直循环
		while(gap>0)
		{
			//按增量序列个数k进行k趟排序
			for(int i=gap;i<len;i++)
			{
				temp = array[i];
				int preIndex = i -gap;
				while(preIndex>=0&&array[preIndex]>temp) {
					array[preIndex+gap] = array[preIndex];
					preIndex -= gap;
				}
				array[preIndex+gap] = temp;
			}
			gap /=2;
		}
		return array;
	}
	
	//归并排序
	public static int[] mergeSort(int[] array) {
		//跳出递归的条件
		if(array.length<2) return array;
		int mid = array.length/2;
		int[] left = Arrays.copyOfRange(array, 0, mid);
		int[] right = Arrays.copyOfRange(array, mid, array.length);
		
		return merge(mergeSort(left), mergeSort(right));
	}
	/**
	 * 归并排序 将两段排好序的数组结合成一个有序数组
	 * @param left
	 * @param right
	 * @return
	 */
	public static int[] merge(int[] left,int[] right) {
		int[] result = new int[left.length+right.length];
		for(int index = 0,i=0,j=0;index<result.length;index++)
		{
			if(i>=left.length){
				result[index] = right[j++];
			}else if(j>=right.length) {
				result[index] = left[i++];
			}else if(left[i] > right[j]) {
				result[index] = right[j++]; //j++ 先使用后加一
			}else {
				result[index] = left[i++];
			}
		}
		return result;
	}
	
	//快速排序
	
	 public static void qSort(int[] A,int left,int right){
        //枢轴
        int pivot;
        //跳出递归
        if(left>=right){
          return;
        }      
        pivot = partition(A,left,right);
        qSort(A,left,pivot-1);
        qSort(A,pivot+1,right);

    }

    //优化选取一个枢轴，想尽办法把它放到一个位置，使它左边的值都比它小，右边的值都比它大
    public static int partition(int[] A,int left,int right){

        //优化选取枢轴，采用三数取中的方法
        int pivotKey = median3(A,left,right);
    
        //从表的俩边交替向中间扫描
        //枢轴用pivotKey给备份了
        while(left<right){
           while(left<right&&A[right]>=pivotKey){
               right--;
           }
            //用替换方式，因为枢轴给备份了，多出一个存储空间
            A[left]=A[right];
           while(left<right&&A[left]<=pivotKey){
               left++;
           }
           A[right]=A[left];

        }

        //把枢轴放到它真正的地方
        A[right]=pivotKey;
        return right;
    }
    //三数取中
    public static int median3(int[] A,int left,int right){

        int mid= left+(right-left)/2;
        if(A[mid]>A[right]){
            swap(A[mid],A[right]);
        }
        if(A[left]>A[right]){
            swap(A[left],A[right]);
        }
        if(A[mid]>A[left]){
            swap(A[mid],A[left]);
        }
        return A[left];
    }
	
	public static void swap(int a,int b) {
		int temp = a;
		a = b;
		b = temp;
	}
}
