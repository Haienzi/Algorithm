package dataStructure;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.management.Attribute;

public class GraphExc {
    
	private ArrayList<Object> vertexList;//顶点集合
	private int[][] edges;//邻接矩阵 存储边
	private int numOfEdges;//边的数目
	
    public GraphExc(int n) {
    	edges = new int[n][n];
    	vertexList = new ArrayList<>();
    	numOfEdges = 0;
    }
    //得到结点的个数
    public int getNumofVertex() {
    	return vertexList.size();
    }
    //得到边的数目
    public int getNumofEdges() {
    	return numOfEdges;
    }
    //返回结点i的数据
    public Object getValueByIndex(int i) {
    	return vertexList.get(i);
    }
    //返回v1,v2的权值
    public int getWeight(int v1,int v2) {
    	return edges[v1][v2];
    }
    //插入结点
    public void insertVertex(Object vertex) {
    	vertexList.add(vertex);
    }
    //插入边
    public void insertEdge(int v1,int v2,int weight) {
    	edges[v1][v2] = weight;
    	numOfEdges++;
    }
    //删除边
    public void deleteEdge(int v1,int v2) {
    	edges[v1][v2] = 0;
    	numOfEdges--;
    }
    //得到第一个邻接结点的下标
    public int getFirstNeighbor(int index) {
    	for(int j=0;j<vertexList.size();j++) {
    		if(edges[index][j] > 0) { //如果权值大于0说明有边
    			return j;
    		}
    	}
    	return -1;
    }
    //根据前一个邻接点的下标来取得下一个邻接点的坐标
    public int getNextNeighbor(int v1,int v2) {
    	for(int j=v2+1;j<vertexList.size();j++) {
    		if(edges[v1][j]>0) {
    			return j;
    		}
    	}
    	return -1;
    }
    /**
     * 深度优先遍历
     * 从初始节点开始访问，而初始节点与多个节点相连。首先访问第一个邻接结点，然后再以这个被访问的邻接结点作为初始结点
     * 访问它的第一个邻接结点。
     * 每次都在访问当前结点后首先访问当前结点的第一个邻接结点
     * @param isVisited 标记是该节点是否被访问过的数组
     * @param i 结点索引
     */
    private void depthFirstSearch(boolean[] isVisited,int i) {
    	//首先访问该结点 在控制台打印出来
    	System.out.print(getValueByIndex(i)+" ");
    	//置该结点为已访问
    	isVisited[i] = true;
    	//获取第一个邻接点
    	int w = getFirstNeighbor(i);
    	while (w != -1) {
    		//如果该结点没有被访问过
			if(!isVisited[w]) {
				//访问该节点的第一个邻接结点
				depthFirstSearch(isVisited, w);
			}
			//访问下一个邻接结点
			w = getNextNeighbor(i, w);
		}
    }
    //对外公开的函数，深度优先遍历
    public void depthFirstSearch() {
    	boolean[] isVisited = new boolean[vertexList.size()];
    	for(int i=0;i<getNumofVertex();i++) {
    		//对于非连通图来说，并不是通过一个结点就一定可以遍历所有结点
    		if(!isVisited[i]) {
    			depthFirstSearch(isVisited,i);
    		}
    	}
    }
    /**
     * 广度优先搜索
     * 需要使用一个队列来保持访问过的结点的顺序，以便按照这个顺序来访问这些结点的邻接结点
     * 访问初始结点后，依次访问该结点的其它邻接结点
     * @param isVisited
     * @param i
     */
    private void broadFirstSearch(boolean[] isVisited,int i) {
    	int u,w;
    	LinkedList<Object> queue = new LinkedList<>();
    	
    	//访问结点i
    	System.out.print(getValueByIndex(i)+" ");
    	//置节点为访问过
    	isVisited[i] = true;
    	//将结点加入队列
    	queue.addLast(i);
        while (!queue.isEmpty()) {
        	//取出队列中的第一个结点
			u = ((Integer)queue.removeFirst()).intValue();
			//取出该结点的邻接结点
			w = getFirstNeighbor(u);
			while (w != -1) {
				if(!isVisited[w]) {
			       System.out.print(getValueByIndex(w)+" ");
			       isVisited[w] = true;
			       queue.addLast(w);
				}
				//寻找下一个邻接结点；
				w = getNextNeighbor(u,w);
			}
		}  	
    }
    //对外公开 广度优先遍历
    public void broadFirstSearch() {
    	boolean[] isVisited = new boolean[getNumofVertex()];
		for(int i=0;i<getNumofVertex();i++) {
			if(!isVisited[i]) {
				broadFirstSearch(isVisited,i);
			}
		}
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int n=8,e=9;//分别代表结点个数和边的数目
         String labels[]={"1","2","3","4","5","6","7","8"};//结点的标识
         GraphExc graph=new GraphExc(n);
         for(String label:labels) {
            graph.insertVertex(label);//插入结点
         }
         //插入九条边
         graph.insertEdge(0, 1, 1);
         graph.insertEdge(0, 2, 1);
         graph.insertEdge(1, 3, 1);
         graph.insertEdge(1, 4, 1);
         graph.insertEdge(3, 7, 1);
         graph.insertEdge(4, 7, 1);
         graph.insertEdge(2, 5, 1);
         graph.insertEdge(2, 6, 1);
         graph.insertEdge(5, 6, 1);
         graph.insertEdge(1, 0, 1);
         graph.insertEdge(2, 0, 1);
         graph.insertEdge(3, 1, 1);
         graph.insertEdge(4, 1, 1);
         graph.insertEdge(7, 3, 1);
         graph.insertEdge(7, 4, 1);
         graph.insertEdge(6, 2, 1);
         graph.insertEdge(5, 2, 1);
         graph.insertEdge(6, 5, 1);

         System.out.println("深度优先搜索序列为：");
         graph.depthFirstSearch();
         System.out.println();
         System.out.println("广度优先搜索序列为：");
         graph.broadFirstSearch();
	}

	
	
	
	
	
	
	
	
	
	
	
}
