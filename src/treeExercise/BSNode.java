package treeExercise;

public class BSNode<T extends Comparable<T>>{
	 T key;//关键字
	 BSNode<T> left;
	 BSNode<T> right;
	 @SuppressWarnings("rawtypes")
	BSNode parent;//父节点
	 
	 public BSNode(T key,BSNode<T> left,BSNode<T> right,BSNode<T> parent) {
		 this.key = key;
		 this.left = left;
		 this.right = right;
		 this.parent = parent;
		 
	 }
}