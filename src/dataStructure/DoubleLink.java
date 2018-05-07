package dataStructure;
/**
 * 双链表
 * @author Root_Qiu
 *
 */
public class DoubleLink<T> {
	//表头
	private DNode<T> mHead;
	//节点个数
	private int mCount;
	
	public DoubleLink(){
		//创造表头
		mHead = new DNode(null, null, null);
		mHead.prev = mHead.next = mHead;
		mCount = 0;
	}
	//返回节点数目
	public int getSize()
	{
		return mCount;
	}
	//判断是否为空表
	public boolean isEmpty()
	{
		return mCount == 0;
	}
	//获取Index位置上的节点(index可以为0)
	public DNode getNode(int index)
	{
		if(index<0 || index >= mCount)
		{
			throw new IndexOutOfBoundsException();
		}
		//index位置较小的时候正向查找
		if(index <= mCount/2) {
			DNode node = mHead.next;
			for(int i=0;i<index;i++)
			{
				node = node.next;
			}
			return node;
		}
		
		DNode rNode = mHead.prev;
		int rindex = mCount-1-index;
		for(int i=0;i<rindex;i++)
		{
			rNode = rNode.prev;
		}
		return rNode;
	}
	//获取Index位置上的节点的值
	public T getValue(int index)
	{
		return (T) getNode(index).value;
	}
	//获取第一个节点的值
	public T getFirstValue()
	{
		return (T)getNode(0).value;
	}
	//获取最后一个位置上的节点
	public T getLast() {
		return (T)getNode(mCount-1).value;
	}
	 // 将节点插入到第index位置之前
    public void insert(int index, T t) {
        if (index==0) {
            DNode<T> node = new DNode<T>(t, mHead, mHead.next);
            mHead.next.prev = node;
            mHead.next = node;
            mCount++;
            return ;
        }

        DNode<T> inode = getNode(index);
        DNode<T> tnode = new DNode<T>(t, inode.prev, inode);
        inode.prev.next = tnode;
        inode.prev = tnode;
        mCount++;
        return ;
    }
}
class DNode<T>{
	public DNode prev;//前驱
	public DNode next;//后继结点
	public T value;//结点数据
	
    public DNode(T value,DNode prev,DNode next) {
		// TODO Auto-generated constructor stub
    	this.value = value;
    	this.prev = prev;
    	this.next = next;
	}
}