package Sort;


/* 17.10.30 월요
 *  버블정렬의 예제 
 */

public class bubleSort_ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {69,10,30,2,16,8,31,22};
		Sortbuble S = new Sortbuble();
		System.out.printf("\n 정렬할 원소 :");
		for(int i=0; i<a.length; i++)
			System.out.printf(" %d",a[i]);
		System.out.println();
		S.bubleSort(a);

	}

}

class Sortbuble {
	
	public void bubleSort(int a[]) {
		int i, j, temp, size;
		size = a.length;
		
		for(i=size-1; i>0; i--) {
			System.out.printf("\n 버블 %d 단계 ",size-i);
			for(j=0; j<i; j++) {
				if(a[j]>a[j+1]) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
				System.out.println();
				for(int k=0; k<size; k++)
					System.out.printf("%3d ",a[k]);
			}

			
		}
		
	}
}
