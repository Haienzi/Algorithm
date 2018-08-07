package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 拓扑排序
 * @author mqh
 *
 */
public class ListDG {
	
	String oo;
   /**
    * 
    * @author mqh
    * 邻接表中表的的顶点
    *
    */
	private class VNode{
		char data; //顶点所包含的数据
		ENode firstEdge; //指向第一条依附该顶点的弧
		
	}
	/**
	 * 
	 * @author mqh
	 * 邻接表顶点所包含的链表的节点所对应的结构体
	 */
	private class ENode{
		int ivex;//节点所对应的顶点在顶点数组中的索引
		ENode nextEdge;//指向下一条狐的指针
		
	}
	
	private VNode[] mVexs; //顶点数组
	
	/**
	 * 拓扑排序
	 * @return 1 --失败（内存不足等原因）
	 * 		   0 --成功排序
	 *        -1 --失败，有向图是有环的
	 */
	public int topoLogicalSort()
	{
		int length = mVexs.length;
		int[] ins = new int[length];//入度数组
		char[] top = new char[length];//拓扑排序结果数组
		Queue<Integer> queue = new LinkedList<Integer>();//辅助队列
		
		//统计每个顶点的入度数
		for(int i=0;i<length;i++) {
			
			ENode node = mVexs[i].firstEdge;
			while (node != null) {
				ins[node.ivex]++;
				node = node.nextEdge;				
			}
		}
		
		//将所有入度为0的顶点加入队列
		for(int i=0;i<length;i++)
		{
			if(ins[i] == 0)
			{
				queue.add(i);
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
