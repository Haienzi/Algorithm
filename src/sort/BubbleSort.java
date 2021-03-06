package sort;
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
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void bubbleSort(int[] a,int n)
	{
		boolean flag = true;
		for(int i=0;i<n-1&&flag;i++)
		{
			//用flag作为标记，标记数组是否已经排序完成
			flag = false;
			for(int j= 0;j<n-i-1;j++)
			{
				if(a[j]>a[j+1])
				{
					swap(a, i, j);
					flag = true;
				}
			}
		}
	}
	
	private void swap(int[] a,int i,int j)
	{
		int temp = a[j];
		a[j] = a[i];
		a[i] = a[j];
	}
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
