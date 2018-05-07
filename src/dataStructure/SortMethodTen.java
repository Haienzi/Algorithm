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
public class SortMethodTen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//冒泡排序
	public void bubbleSort(int[] a,int n)
	{
		boolean flag = true;
		for(int i=0;i<n-1&&flag;i++)
		{
			//用flag作为标记，标记数组是否已经排序完成
			flag = false;
			for(int j= 0;j<n-i-1;j++)
			{
				if(a[j]>a[j+1]) //每次都将大值放在后面
				{
					swap(a, j, j+1);
					flag = true;
				}
			}
		}
	}
	//交换两个元素 如果交换前a[i]>a[j]交换后结果a[i]<a[j] 
	private void swap(int[] a,int i,int j)
	{
		int temp = a[j];
		a[j] = a[i];
		a[i] = a[j];
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
    
}
