package dataStructure;

import java.lang.reflect.Array;
/**
 * 使用数组实现栈，能存储任意数据类型的数据
 * @author mqh 2018年9月1日
 * 
 * @param <T>
 */

public class StackJava<T>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static final int DEFAULT_SIZE = 12;//默认大小
	private T[] mArray;
	private int count;//栈的大小
    
	public StackJava(Class<T> type) {
		this(type, DEFAULT_SIZE);
	}
	public StackJava(Class<T> type,int size){
		mArray = (T[])Array.newInstance(type, size);
		count = 0;
	}

	public void push(T val) {
		mArray[count++] = val;
	}
	
	//返回栈顶元素
	public T peek() {
		return mArray[count-1];
	}
	
	//返回栈顶元素并删除栈顶元素
	public T pop()
	{
		T ret = mArray[count-1];
		count--;
		return ret;
	}
	//返回栈的大小
	public int size() {
		return count;
	}
	//判断栈是否为空
	public boolean isEmpty() {
		return size() == 0;
	}
	//打印栈
	public void printArrayStack() {
		if(isEmpty()) {
			System.out.println("stack is empty");
		}
		System.out.printf("stack size()=%d\n",size());
		int i = size()-1;
		while(i>=0) {
			System.out.println(mArray[i]);
			i--;
			
		}
	}
	
	
}
