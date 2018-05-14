package treeExercise;

import javax.xml.bind.ValidationEvent;

public class BSTree<T extends Comparable<T>>{
	
	/**
	 * 使用递归实现查找二叉树中键值为key的结点
	 * @param rNode
	 * @param key
	 * @return
	 */
	public BSNode<T> findKey(BSNode<T> rNode,T key)
	{
		if(rNode == null)
		{
			return rNode;
		}
		
		int cmp = key.compareTo(rNode.key);
		if(cmp<0)
		{
			return findKey(rNode.left, key);
		}else if(cmp>0)
		{
			return findKey(rNode.right, key);
		}else {
			return rNode;
		}
	}
	/**
	 * 使用非递归实现查找二叉树中键值为key的结点
	 * @param rNode
	 * @param key
	 * @return
	 */
	public BSNode<T> findValue(BSNode<T> rNode,T key)
	{
		while (rNode != null) {
			int cmp = key.compareTo(rNode.key);
			if(cmp<0)
			{
				rNode = rNode.left;
			}else if(cmp > 0) {
				rNode = rNode.right;
			}else {
				return rNode;
			}
			
		}
		return rNode;
	}

}
