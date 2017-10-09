package Queue;

/* 17.10.08 일요일 
 * 연결리스트를 이용한 큐 구현 
 */


public class CycleQueue_Linked {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedQueue LQ = new LinkedQueue();
		LQ.enQueue('A');
		LQ.printQueue();
		
		LQ.enQueue('B');
		LQ.printQueue();
		
		LQ.deQueue();
		LQ.printQueue();
		
		LQ.enQueue('C');
		LQ.printQueue();

	}
}

interface Queue_Linked {
	void enQueue(char item);
	char deQueue();
	void delete();
	char peek();
}

class QNode{
	char data;
	QNode link;
}

class LinkedQueue implements Queue_Linked {

	QNode front;
	QNode rear;
	
	LinkedQueue(){
		front =null;
		rear =null;
	}
	
	public boolean isEmpty() {
		if(front==null)
			return true;
		else return false;
	}
	
	@Override
	public void enQueue(char item) {
		// TODO Auto-generated method stub
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

	@Override
	public char deQueue() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return 0;
		} else {
			char item = front.data;
			front = front.link;
			if(front ==null) {
				rear =null;
			}
			return item;
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.println("삭제할 노드가 없습니다.");
		} else {
			
			front = front.link;
			if(front ==null)
				rear=null;
		}
		
	}

	@Override
	public char peek() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.println("검색 실패! 현재 큐가 비어있습니다.");
			return 0;
		}else {
			return front.data;
		}
	}
	
	public void printQueue() {
		if(isEmpty()) {
			System.out.println("현재 큐가 비어있습니다.");
		} else {
			QNode temp = front;
			while(temp!=null) {
				System.out.print(temp.data);
				temp = temp.link;
			}
			System.out.println();
		}
	}
	
}
