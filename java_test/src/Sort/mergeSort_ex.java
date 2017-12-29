package Sort;

/* 17.10.30 월요일 
 *  병합정렬 예제 // 재귀함수를 이용하는 퀵소트와 유사함 시간복잡도는 퀵소트와 같게 nlog_2n
 */

public class mergeSort_ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {69,10,30,2,16,8,31,22};
		int size=a.length;
		mergeSort S = new mergeSort();
		System.out.printf("\n 정렬할 원소 :");
		for(int i=0; i<size; i++)
			System.out.printf("%3d ",a[i]);
		System.out.println();
		S.mergesort(a, 0, size-1);

	}

}

class mergeSort{
	
	private int sorted[] = new int[30];
	
	public void merge(int a[], int m, int middle, int n) {
		
		int size = a.length;
		int i,j,k,t;
		
		i = m;
		j = middle+1;
		k = m;
		
		while(i<=middle && j<=n) {
			if(a[i]<=a[j]) {
				sorted[k] = a[i++];
			} else {
				sorted[k] = a[j++];
			}
			k++;
		}
		
		if(i>middle) {
			for(t=j; t<=n; t++,k++)
				sorted[k] = a[t];
		} else {
			for(t=i; t<=middle; t++,k++)
				sorted[k] = a[t];
		}
		
		for(t=m; t<=n; t++)
			a[t] = sorted[t];
		
		System.out.printf("\n 병합정렬 >>");
		for(t=0; t<size; t++)
			System.out.printf("%3d ",a[t]);
		
	}
	public void mergesort(int a[], int m, int n) {
		int middle;
		if(m<n) {
			middle = (m+n) /2;
			mergesort(a,m,middle);
			mergesort(a,middle+1,n);
			merge(a,m,middle,n);
		}
	}
	
	
	
}
