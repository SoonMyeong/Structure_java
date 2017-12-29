package graph;


/* 17.10.17 화요일 
 * DFS, BFS 
 */

public class DFS_BFS_ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdjList G9 = new AdjList();
		
		for(int i=0; i<7; i++)
			G9.insertVertex(i);
		
		G9.insertEdge(0, 2);
		G9.insertEdge(0, 1);
		G9.insertEdge(1, 4);
		G9.insertEdge(1, 3);
		G9.insertEdge(1, 0);
		G9.insertEdge(2, 4);
		G9.insertEdge(2, 0);
		G9.insertEdge(3, 6);
		G9.insertEdge(3, 1);
		G9.insertEdge(4, 6);
		G9.insertEdge(4, 2);
		G9.insertEdge(4, 1);
		G9.insertEdge(5, 6);
		G9.insertEdge(6, 5);
		G9.insertEdge(6, 4);
		G9.insertEdge(6, 3);
		System.out.printf("\n 그래프 G9의 인접리스트 :");
		G9.printAdjList();
		System.out.println();
		
		System.out.printf("\n 깊이우선탐색(DFS) >>");
		G9.DFS(0);
		
		System.out.printf("\n 너비우선탐색(BFS) >>");
		G9.BFS(0);
		

	}

}

class StackNode{
	int data;
	StackNode link;
}

class LinkedStack {
	StackNode top;
	
	public boolean isEmpty() {
		return (top==null);
	}
	
	public void push(int item) {
		StackNode newNode = new StackNode();
		newNode.data = item;
		newNode.link = top;
		top = newNode;
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return 0;
		}
		else {
			int item = top.data;
			top = top.link;
			return item;
		}
		
	}
}

class QNode{
	int data;
	QNode link;
}

class LinkedQueue{
	QNode front;
	QNode rear;
	
	public LinkedQueue() {
		front = null;
		rear = null;
	}
	
	public boolean isEmpty() {
		return (front==null);
	}
	
	public void enQueue(int item) {
		QNode newNode = new QNode();
		newNode.data = item;
		newNode.link = null;
		
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
		} else {
			rear.link = newNode;
			rear = newNode;
		}
	}
	
	public int deQueue() {
		
		if(isEmpty()) {
			System.out.println("큐가 비어 있습니다 ");
			return 0;
		} else {
			int item = front.data;
			front = front.link;
			if(front==null) {
				rear=null;
			}
			return item;
		}
		
	}
}

class GraphNode{
	int vertex;
	GraphNode link;
}
class AdjList{
	GraphNode head[] = new GraphNode[10];
	private int totalV = 0;
	
	public void insertVertex(int v) {
		totalV++;
	}
	
	public void insertEdge(int v1, int v2) {
		
		if(v1>=totalV || v2>=totalV) {
			System.out.println("그래프에 없는 정점입니다.");
		}else {
			GraphNode gNode = new GraphNode();
			gNode.vertex = v2;
			gNode.link = head[v1];
			head[v1]=gNode;
		}
	}
	
	public void printAdjList() {
		GraphNode gNode = new GraphNode();
		for(int i=0; i<totalV; i++) {
			System.out.printf("\n정점 %c의 인접리스트 ",i+65); //숫자를 문자
			gNode = head[i];
			while(gNode !=null) {
				System.out.printf("-> %c",gNode.vertex+65);
				gNode = gNode.link;
			}
		}
	}
	
	public void DFS(int v) {
		GraphNode w = new GraphNode();
		LinkedStack S = new LinkedStack();
		boolean visited[] = new boolean[10];
		S.push(v);
		visited[v] = true;
		System.out.printf(" %c",v+65);
		while(S.top !=null) {
			
		w = head[v];
		while(w !=null) {
			if(visited[w.vertex]==false) {
				S.push(w.vertex);
				visited[w.vertex] = true;
				System.out.printf(" %c",w.vertex+65);
				v =w.vertex;
				w= head[v];
			} else {
				w = w.link;
			}
		}
		v = S.pop();
		}
		
	}
	
	public void BFS(int v) {
		GraphNode w = new GraphNode();
		LinkedQueue Q = new LinkedQueue();
		boolean visited[] = new boolean[10];
		visited[v] = true;
		System.out.printf(" %c",v+65);
		Q.enQueue(v);
		
		while(! Q.isEmpty()) {
			v = Q.deQueue();
			for(w =head[v]; w !=null; w=w.link) {
				if(visited[w.vertex] == false) {
					visited[w.vertex]=true;
					System.out.printf(" %c",w.vertex+65);
					Q.enQueue(w.vertex);
				}
			}
		}
	}
}


