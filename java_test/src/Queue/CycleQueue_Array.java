package Queue;

/* 17.10.08 일요일 
 * 배열을 이용한 원형 큐 구현 
 */

public class CycleQueue_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int queueSize = 4;
		ArrayCQueue cQ = new ArrayCQueue(queueSize);
		
		cQ.enQueue('A');
		cQ.printQueue();
		
		cQ.enQueue('B');
		cQ.printQueue();
		
		cQ.deQueue();
		cQ.printQueue();
		
		cQ.enQueue('C');
		cQ.printQueue();
		
		cQ.enQueue('D');
		cQ.printQueue();
		
		cQ.enQueue('E');
		cQ.printQueue();
	}

}

interface Queue {
	boolean isEmpty();
	boolean isFull();
	void enQueue(char item);
	char deQueue();
	void delete();
	char peek();
}

class ArrayCQueue implements Queue{

	private int front;
	private int rear;
	private int queueSize;
	private char itemArray[];
	
	ArrayCQueue(int QueueSize){
		front =0;
		rear =0;
		this.queueSize = QueueSize;
		itemArray = new char[this.queueSize];
	}
	
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(front==rear) return true;
		else return false; 
	}
	
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		//rear+1을 큐사이즈로 나눈 나머지가 프론트와 같으면 큐는 현재 꽉 찬 상태이다.
		//포화상태를 쉽게 확인하기 위해 프론트자리를 항상 비워둔다. 즉 배열 한자리가 비어있는 상태
		if((rear+1)%this.queueSize ==front) return true;
		else return false;
	}

	@Override
	public void enQueue(char item) {
		// TODO Auto-generated method stub
		if(isFull()) System.out.println("큐가 꽉 찼습니다.");
		else {
			rear = (rear+1)%this.queueSize;
			itemArray[rear] = item;
		}
	}

	@Override
	public char deQueue() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.println("큐가 비어 있습니다.");
			return 0;
		}
		else {
			front = (front+1)%this.queueSize;
			return itemArray[front];
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.println("큐가 비어 있습니다.");
		} else {
			front = (front+1)%this.queueSize;
		}
		
	}

	@Override
	public char peek() {
		// TODO Auto-generated method stub
		return itemArray[(front+1)%this.queueSize];
	}
	
	public void printQueue() {
		if(isEmpty()) {
			System.out.println("출력할 큐가 현재 비어 있습니다.");
		} else {
			for(int i=(front+1)%this.queueSize; 
					i!=(rear+1)%this.queueSize; 
					i=++i%this.queueSize) {
				System.out.print(itemArray[i]);
			}
			System.out.println();
		}
	}
	
}
