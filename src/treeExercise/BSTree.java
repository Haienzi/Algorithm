package treeExercise;


public class BSTree<T extends Comparable<T>>{
	
	/**
	 * 先序遍历二叉树 访问结点顺序 根左右
	 * @param tree
	 */
	public void preOrder(BSNode<T> tree) {
		if(tree != null)
		{
			System.out.print(tree.key+" ");
			preOrder(tree.left);
			preOrder(tree.right);
		}
	}
	/**
	 * 中序遍历二叉树 访问结点顺序 左根右
	 * @param tree
	 */
	public void inOrder(BSNode<T> tree) {
		if(tree != null)
		{
			preOrder(tree.left);
			System.out.print(tree.key+" ");
			preOrder(tree.right);
		}
	}
	
	
	/**
	 * 后序遍历二叉树 访问结点顺序 左右根
	 * @param tree
	 */
	public void postOrder(BSNode<T> tree) {
		if(tree != null)
		{
			preOrder(tree.left);
			preOrder(tree.right);
			System.out.print(tree.key+" ");
		}
	}
	
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
	/**
	 * 二叉树中最大结点就是最右边的结点
	 * 最小结点是最左边的结点
	 */
     public BSNode<T> maximum(BSNode<T> tree)
     {
    	 if(tree == null)
    	 {
    		 return null;
    	 }
    	 
    	 while(tree.right != null)
    	 {
    		 tree = tree.right;
    	 }
    	 return tree;
     }
     
     /**
      * 结点的前驱指的是该节点左子树中的最大节点
      * 结点的后继结点是指该节点右子树中的最小节点
      */
     
}
