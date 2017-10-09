package Queue;


/* 17.10.8 일요일
 * 덱 예제 구현
 */
public class Deque_example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DQueue DQ = new DQueue();
		
		DQ.insertFront('A');
		DQ.printDQ();
		
		DQ.insertFront('B');
		DQ.printDQ();
		
		DQ.insertRear('C');
		DQ.printDQ();
		
		DQ.deleteFront();
		DQ.printDQ();
		
		DQ.deleteRear();
		DQ.printDQ();
		
		DQ.deleteFront();
		DQ.printDQ();
		


	}

}
interface deque{
	void insertFront(char item);
	void insertRear(char item);
	char deleteFront();
	char deleteRear();
	void removeFront();
	void removeRear();
	char peekFront();
	char peekRear();
}

class DQNode {
	char data;
	DQNode llink;
	DQNode rlink;
}

class DQueue implements deque{
	DQNode front;
	DQNode rear;
	
	DQueue(){
		front =null;
		rear =null;
	}
	
	public boolean isEmpty() {
		if(front == null) {
			return true;
		} else return false;
	}

	@Override
	public void insertFront(char item) {
		// TODO Auto-generated method stub
		DQNode newNode = new DQNode();
		newNode.data = item;
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
			newNode.rlink =null;
			newNode.llink =null;
		} else {
			//프론트의 왼쪽에 newNode를 넣고 프론트의 위치를 newNode로 변
			front.llink = newNode;
			newNode.rlink = front;
			newNode.llink = null;
			front = newNode;
		}
		
	}

	@Override
	public void insertRear(char item) {
		// TODO Auto-generated method stub
		DQNode newNode = new DQNode();
		newNode.data = item;
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
			newNode.rlink =null;
			newNode.llink=null;
		} else {
			rear.rlink = newNode;
			newNode.rlink= null;
			newNode.llink= rear;
			rear = newNode;
		}
		
	}

	@Override
	public char deleteFront() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			System.out.println("덱이 비어 있습니다.");
			return 0;
		} else {
			char item =front.data;
			if(front.rlink==null) {
				front=null;
				rear=null;
			} else{
				front= front.rlink;
				front.llink =null;
				
			}

			return item;
		}
		
	}

	@Override
	public char deleteRear() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.println("덱이 비어 있습니다.");
			return 0;
		} else {
			char item = rear.data;
			if(rear.llink ==null) {
				rear = null;
				front =null;
			} else {
				rear= rear.llink;
				rear.rlink=null;
			}
			return item;
		}
		
	}

	@Override
	public void removeFront() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.println("삭제할 데이터가 없습니다.");
		}else {
			if(front.rlink ==null) {
				front =null;
				rear =null;
			} else {
				front= front.rlink;
				front.llink=null;
			}
		}
		
	}

	@Override
	public void removeRear() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.println("삭제할 덱이 없습니다.");
		} else {
			if(rear.llink==null) {
				rear=null;
				front=null;
			} else {
				rear= rear.llink;
				rear.rlink=null;
			}
			
		}
		
	}

	@Override
	public char peekFront() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.println("선택한값이 없습니다.");
		}
		
		return front.data;
	}

	@Override
	public char peekRear() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.println("선택한 값이 없습니다.");
		}
		return rear.data;
	}
	
	public void printDQ() {
		if(isEmpty()) {
			System.out.println("출력할 값이 없습니다.");
		} else {
			DQNode temp = front;
			
			while(temp !=null) {
				System.out.printf("%c ",temp.data);
				temp = temp.rlink; //출력은 프론트점에서 오른쪽으로 이동하면서 출
			}
			System.out.println();
		}
		
	}


	
}
