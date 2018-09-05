package treeExercise;

import javax.security.auth.x500.X500Principal;

public class BSTree<T extends Comparable<T>>{
	public BSTNode<T> mRoot;//根结点
	
	/**
	 * 先序遍历二叉树 访问结点顺序 根左右
	 * @param tree
	 */
	public void preOrder(BSTNode<T> tree) {
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
	public void inOrder(BSTNode<T> tree) {
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
	public void postOrder(BSTNode<T> tree) {
		if(tree != null)
		{
			preOrder(tree.left);
			preOrder(tree.right);
			System.out.print(tree.key+" ");
		}
	}
	
	/**
	 * 使用递归实现查找二叉树中键值为key的结点
	 * @param rTree
	 * @param key
	 * @return
	 */
	public BSTNode<T> findKey(BSTNode<T> rTree,T key)
	{
		if(rTree == null)
		{
			return rTree;
		}
		
		int cmp = key.compareTo(rTree.key);
		if(cmp<0)
		{
			return findKey(rTree.left, key);
		}else if(cmp>0)
		{
			return findKey(rTree.right, key);
		}else {
			return rTree;
		}
	}
	/**
	 * 使用非递归实现查找二叉树中键值为key的结点
	 * @param rNode
	 * @param key
	 * @return
	 */
	public BSTNode<T> findValue(BSTNode<T> rNode,T key)
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
     public BSTNode<T> maximum(BSTNode<T> tree)
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
     public T maximum() {
    	 BSTNode<T> p = maximum(mRoot);
    	 if(p != null) {
    		 return p.key;
    	 }
    	 return null;
     }
     
     public BSTNode<T> minimum(BSTNode<T> tree){
    	 if(tree == null) {
    		 return null;
    	 }
    	 while(tree.left != null) {
    		 tree = tree.left;
    	 }
    	 return tree;
     }
     public T minimum() {
    	 BSTNode<T> s = minimum(mRoot);
    	 if(s != null)
    	 {
    		 return s.key;
    	 }
    	 return null;
     }
     /**
      * 结点的前驱指的是该节点左子树中的最大节点
      * 结点的后继结点是指该节点右子树中的最小节点
      */
     public BSTNode<T> predecessor(BSTNode<T> tree){
    	 //如果存在左孩子 则左孩子为根的子树的最大结点就是其前驱结点
    	 if(tree.left != null) {
    		 return maximum(tree.left);
    	 }
    	  // 如果x没有左孩子。则x有以下两种可能：
    	    // (01) x是"一个右孩子"，则"x的前驱结点"为 "它的父结点"。
    	    // (02) x是"一个左孩子"，则查找"x的最低的父结点，并且该父结点要具有右孩子"，找到的这个"最低的父结点"就是"x的前驱结点"。
    	 BSTNode<T> xBstNode = tree.parent;
    	 while((xBstNode != null) && (tree == xBstNode.left)) {
    		 tree = xBstNode;
    		 xBstNode = tree.parent;
    	 }
    	 return xBstNode;
     }
     /* 
      * 找结点(x)的后继结点。即，查找"二叉树中数据值大于该结点"的"最小结点"。
      */
     public BSTNode<T> successor(BSTNode<T> x) {
         // 如果x存在右孩子，则"x的后继结点"为 "以其右孩子为根的子树的最小结点"。
         if (x.right != null)
             return minimum(x.right);

         // 如果x没有右孩子。则x有以下两种可能：
         // (01) x是"一个左孩子"，则"x的后继结点"为 "它的父结点"。
         // (02) x是"一个右孩子"，则查找"x的最低的父结点，并且该父结点要具有左孩子"，找到的这个"最低的父结点"就是"x的后继结点"。
         BSTNode<T> y = x.parent;
         while ((y!=null) && (x==y.right)) {//满足条件，不断往上追溯，直到找到右祖先结点
             x = y;
             y = y.parent;
         }

         return y;
     }
     /**
      * 打印二叉查找树
      * @param direction 0 表示该节点是根节点
      *                 -1 表示该节点是它的父结点的左孩子
      *                  1 表示该节点是它的父节点的右孩子
      */
     public void print(BSTNode<T> tree,T key,int direction) {
    	 if(tree != null) {
    		 if(direction == 0) {
    			 System.out.printf("%2d is root\n",tree.key);
    		 }else {
    			 System.out.printf("%2d is %2d's %6s child\n", tree.key,
    					 key,direction==1?"right":"left");
    		 }
    		 print(tree.left, tree.key, -1);
    		 print(tree.right, tree.key, 1);
    	 }
     }
     public void print() {
    	 if(mRoot != null) {
    		 print(mRoot,mRoot.key,0);
    	 }
     }
     
}












