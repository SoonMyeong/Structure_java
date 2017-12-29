package Sort;


/* 17.10.30 월요일 
 *  삽입정렬 예제 
 */

public class insertionSort_ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[]= {69,10,30,2,16,8,31,22};
		
		insertionSort S = new insertionSort();
		System.out.printf("\n정렬할 원소들 :");
		for(int i=0; i<a.length; i++)
			System.out.printf(" %d",a[i]);
	
		System.out.println();
		S.insertsort(a);
	}
	

}

class insertionSort{
	
	public void insertsort(int a[]) {
		int i,j,t,temp;
		
		for(i=1; i<a.length; i++) {
			temp = a[i];
			j =i;
			
			while(j>0 && a[j-1]>temp) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = temp; //j 는 와일문 안에서 감소된 형태로 나옴 
			System.out.printf("\n 삽입정렬 %d 단계 ",i);
			for(t=0; t<a.length; t++) {
				System.out.printf("%3d ",a[t]);
			}
		}
		System.out.println();
	}
}
