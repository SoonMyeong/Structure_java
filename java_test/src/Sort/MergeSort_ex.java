package Sort;

/* 17.10.30 월요일 
 *  병합정렬 예제 // 재귀함수를 이용하는 퀵소트와 유사함 시간복잡도는 퀵소트와 같게 n log n
 */

/**
 * 21.04.15
 * 병합정렬 다시 구현하면서 주석 추가
 * 다시 보니.. 17년 시절 자바 문법공부 제대로 안해서 코딩 스타일이 C 언어 하던 스타일이네.. -> 수정
 */

public class MergeSort_ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {69,10,30,2,16,8,31,22};
		int size=a.length;
		MergeSort s = new MergeSort();
		System.out.print("\n 정렬할 원소 :");
		for (int k : a) System.out.printf("%3d ", k);

		System.out.println();

		s.mergeSort(a, 0, size-1);

		System.out.print("\n 병합정렬 >>");
		for (int j : a) System.out.printf("%3d ", j);

	}
}

class MergeSort{
	// 정렬을 위해 임시로 값을 저장할 저장소
	private final int[] sorted = new int[10];
	
	public void merge(int []a, int start, int middle, int end) {

		int i,j,idx;

		i = start; //partition 1의 인덱스 시작 값 (배열을 2개로 나눴을때의 파티션을 뜻함)
		j = middle+1; //partition 2의 인덱스 시작 값
		idx = start; //임시 저장소 시작 인덱스는 시작 인덱스와 동잃 하게 설정

		while(i<=middle && j<=end) {
			if(a[i]<=a[j]) {
				sorted[idx++] = a[i++];
			} else {
				sorted[idx++] = a[j++];
			}
		}

		if(i>middle) {
			for(int t=j; t<=end; t++,idx++)
				sorted[idx] = a[t];
		} else {
			for(int t=i; t<=middle; t++,idx++)
				sorted[idx] = a[t];
		}

		for(int t=start; t<=end; t++)
			a[t] = sorted[t];
	}

	//중간 값(middle) 을 기준으로 start 값이 end 값 보다 커질 때 까지 원소를 나눈 후 merge 하는 메소드
	public void mergeSort(int []a, int start, int end) {
		int middle;
		if(start<end) {
			middle = (start+end) /2;
			mergeSort(a,start,middle);
			mergeSort(a,middle+1,end);
			merge(a,start,middle,end);
		}
	}
	
	
	
}
