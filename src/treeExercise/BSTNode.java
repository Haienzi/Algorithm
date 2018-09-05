package treeExercise;

public class BSTNode<T extends Comparable<T>>{
	 T key;//关键字
	 BSTNode<T> left;//左结点
	 BSTNode<T> right;//右结点
	 BSTNode<T> parent;//父节点
	 
	 public BSTNode(T key,BSTNode<T> left,BSTNode<T> right,BSTNode<T> parent) {
		 this.key = key;
		 this.left = left;
		 this.right = right;
		 this.parent = parent;
		 
	 }
}