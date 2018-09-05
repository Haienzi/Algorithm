package treeExercise;

import java.util.ArrayDeque;

import javax.swing.RootPaneContainer;

import org.omg.CORBA.PUBLIC_MEMBER;

import startTraining.Test;

/**
 * 树的深度、广度优先遍历
 * @author mqh 2018年9月5日
 *
 */
public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	static class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int value) {
			this.value = value;
		}
	}
	
	TreeNode mRoot;//根结点
	
	public BinaryTree(int[] array) {
		mRoot = makeBinaryTreeByArray(array, 1);
	}
	
	/**
	 * 采用递归的方式创建一颗二叉树
	 * 传入的是二叉树的数组表示法
	 * 构造后是二叉树的二叉链表表示法
	 * @param array
	 * @param index
	 * @return
	 */
	public static TreeNode makeBinaryTreeByArray(int[] array,int index) {
		if(index<array.length) {
			int value = array[index];
			if(value != 0) {
				TreeNode treeNode = new TreeNode(value);
				array[index] = 0;
				treeNode.left = makeBinaryTreeByArray(array, index*2);
				treeNode.right = makeBinaryTreeByArray(array, index*2+1);
				System.out.println(treeNode.value);;
				return treeNode;
			}
		}
		return null;
	}
    
	/**
	 * 深度优先遍历，相当于先根遍历
	 * 采用非递归实现
	 * 辅助数据结构：栈 先进后出
	 */
	public void depthOrderTraversal() {
		if(mRoot == null) {
			System.out.println("empty tree");
			return;
		}
		ArrayDeque<TreeNode> stack = new ArrayDeque<>();
		stack.push(mRoot);
		
		while(stack.isEmpty() == false) {
			TreeNode node = stack.pop();
			System.out.println(node.value + " ");
			if(node.right != null) {
				stack.push(node.right);
			}
			if(node.left != null) {
				stack.push(node.left);
			}
		}
		System.out.println();
	}
	/**
	 * 广度优先遍历 层次遍历
	 * 采用非递归实现
	 * 需要辅助数据结构 队列
	 */
	public void levelOrderTraversal() {
		if(mRoot == null) {
			System.out.println("empty tree");
			return;
		}
		ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		queue.add(mRoot);
		
	    while(queue.isEmpty() == false) {
	    	TreeNode node = queue.remove();
	    	System.out.println(node.value + " ");
	    	if(node.left != null) {
	    		queue.add(node.left);
	    	}
	    	if(node.right != null) {
	    		queue.add(node.right);
	    	}
	    }
	    System.out.println();
	}
}


























