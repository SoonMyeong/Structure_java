package LinkedList_exam;

public class LinkedList_exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList list = new LinkedList();
		list.InsertLastNode("월");
		list.InsertLastNode("화");
		list.InsertLastNode("수");
		list.InsertLastNode("금");
		list.PrintLinkedList();

		System.out.println("수요일과 금요일 사이에 목요일 넣기");
		ListNode pre = list.SearchNode("수");
		
		if(pre == null) {
			System.out.println("값이 존재하지 않습니다.");
		} else {
			list.InsertMiddleNode("목", pre);
			list.PrintLinkedList();
		}
		
		System.out.println("역순으로 출력하기");
		list.ReverseLinkedList();
		list.PrintLinkedList();
		
		System.out.println("마지막 노드값 삭제하기");
		list.DeleteLastNode();
		list.PrintLinkedList();

	}

}

class LinkedList{

	private ListNode head;
	
	public LinkedList() {
		head = null;
	}
	
	public void InsertMiddleNode(String data, ListNode pre) {
		ListNode NewNode = new ListNode(data);
		
		NewNode.link = pre.link;
		pre.link = NewNode;
		
	}
	
	public void InsertLastNode(String data) {
		ListNode NewNode = new ListNode(data);
		ListNode temp = head; // 연결리스트를 비교하기 위한 복사 
		
		if(head ==null) {
			this.head = NewNode; //연결리스트가 공백리스트일 경우 처음삽입 
		}
		else {
			while(temp.link != null) {
				temp = temp.link;
			}
		
			temp.link = NewNode;
		}
	}
	
	public void DeleteLastNode() {
		ListNode pre;
		ListNode temp = head;
		
		if(head == null) 
			return; //공백리스트라면 삭제할 값이 없으므로 리턴 처리 
		if(head.link == null) {
			head = null;
		}
		else {
			
			pre = head;
			temp = temp.link;

			while(temp.link !=null) {
				pre = temp;
				temp = temp.link;
			}
			pre.link =null;
		}
		
		
	}
	
	public void ReverseLinkedList() {
		ListNode next = head;
		ListNode current =null;
		ListNode pre = null;
		
		while(next !=null) {
			pre = current; //이전 노드는 거꾸로바꿀 노드로 초기화 
			current =next; // 거꾸로 바꿀 노드는 next 값으로 초기화 
			next = next.link; // next값은 널일때까지 계속 링크가르키기 
			current.link =pre; //거꾸로 바꿀 노드니까 계속 이전 노드인 pre 가르키기 
		}
		head = current;
		
	}
	
	public ListNode SearchNode(String data) {
		ListNode temp =head;
		
		while(temp.link !=null) {
			if(temp.getNode() ==data){
				return temp;
			}
			else {
				temp= temp.link;
			}
		}
		return temp;
	}
	
	public void PrintLinkedList() {
		ListNode temp = this.head;
		
		System.out.printf("List =");
		
		while(temp !=null) {
			System.out.printf(temp.getNode());
			temp = temp.link;
			
			if(temp !=null) {
				System.out.printf(",");
			}
		}
		System.out.println();
	}

}

class ListNode{
	
	private String data;
	public ListNode link;
	
	public ListNode() {
		this.data = null;
		this.link = null;
	}
	
	public ListNode(String data) {
		this.data = data;
		this.link = null;
	}
	
	public ListNode(String data, ListNode link) {
		this.data = data;
		this.link = link;
	
	}
	public String getNode() {
		return this.data;
	}
	
}

