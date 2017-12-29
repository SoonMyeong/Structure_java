package Sort;


/* 17.10.20 금요일 
 *  퀵 정렬 구현 
 */




public class quickSort_ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {69,10,2,8,16,31,32,24};
		QuickSort quick = new QuickSort();
		quick.quickSort(a, 0, a.length-1);
		
		for(int i=0; i<a.length; i++) {
			System.out.printf("%d ",a[i]);
		}

	}

}

class QuickSort{
	int i=0;
	
	public int partition(int a[], int begin, int end) {
		int L,R,pivot,temp;
		L = begin;
		R= end;
		pivot = (begin+end)/2;
		
		while(L<R) {
			
			while((a[L]<a[pivot]) && (L<R)) L++;
			while((a[R]>=a[pivot]) && (L<R)) R--;
			
			if(L<R) {
				temp = a[L];
				a[L] = a[R];
				a[R] = temp;
			}
		}
		temp = a[pivot];
		a[pivot]=a[R];
		a[R] = temp;
		
		return L;
	}
	
	public void quickSort(int a[], int begin, int end) {
		if(begin<end) {
			int q;
			q = partition(a, begin, end);
			quickSort(a,begin,q-1);
			quickSort(a,q+1,end);
		}
	}
}
