package tree_heap;



// 17.10.15 일요일
// 최대힙과 최소힙의 삽입 삭제 구현 

public class heap_ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n, item;
		Heap h = new Heap();
		Heap hm = new Heap();
		
		h.insertMaxHeap(13);
		h.insertMaxHeap(8);
		h.insertMaxHeap(10);
		h.insertMaxHeap(15);
		h.insertMaxHeap(20);
		h.insertMaxHeap(19);
		
		h.printHeap();
		
		n = h.getHeapSize();
		for(int i=1; i<=n; i++) {
			item = h.deleteMaxHeap();
			System.out.printf("\n delete Item : [%d]",item);
		}
		
		System.out.println();
		System.out.println();
		
		hm.insertMaxHeap(13);
		hm.insertMinHeap(8);
		hm.insertMinHeap(10);
		hm.insertMinHeap(15);
		hm.insertMinHeap(20);
		hm.insertMinHeap(19);
		
		hm.printHeap();
		
		n = hm.getHeapSize();
		for(int i=1; i<=n; i++) {
			item = hm.deleteMinHeap();
			System.out.printf("\n delete Item : [%d]",item);
		}
		



	}

}

class Heap {
	private int heapSize;
	private int itemHeap[];
	
	public Heap() {
		heapSize =0;
		itemHeap = new int[50];
	}
	
	public void insertMaxHeap(int item) {
		int i= ++heapSize;
		while((i!=1) && (item > itemHeap[i/2])){
			itemHeap[i] = itemHeap[i/2];
			i/=2;
		}
		itemHeap[i]=item;
	}
	public void insertMinHeap(int item) {
		int i= ++heapSize;
		while((i!=1) && (item < itemHeap[i/2])){
			itemHeap[i] = itemHeap[i/2];
			i/=2;
		}
		itemHeap[i]=item;
	}
	
	public int getHeapSize() {
		return this.heapSize;
	}
	
	public int deleteMaxHeap() {
		int parent,child;
		int item, temp;
		item = itemHeap[1];
		temp = itemHeap[heapSize--];
		parent =1; child=2;
		
		while(child<=heapSize) {
			if((child<heapSize) && (itemHeap[child]<itemHeap[child+1])) {
				child++;
			}
			if(temp>= itemHeap[child]) break;
			
			itemHeap[parent] = itemHeap[child];
			parent =child;
			child *= 2;
		}
		itemHeap[parent] = temp;
		return item;
	}
	
	public int deleteMinHeap() {
		int parent, child;
		int item, temp;
		item = itemHeap[1];
		temp = itemHeap[heapSize--];
		parent = 1; child = 2;
		
		while(child<=heapSize) {
			if((child<heapSize) && (itemHeap[child]>itemHeap[child+1])){
				child++;
			}
			if(temp<=itemHeap[child]) break;
			
			itemHeap[parent] = itemHeap[child];
			parent = child;
			child *=2;
		}
		itemHeap[parent]= temp;
		return item;
	}
	
	public void printHeap() {
		System.out.printf("\nHeap >>>");
		for(int i=1; i<=heapSize; i++) {
			System.out.printf("[%d] ",itemHeap[i]);
		}
	}
	
	
}