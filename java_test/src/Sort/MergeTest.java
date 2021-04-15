package Sort;

public class MergeTest {

    private static void mergeSort(int [] arr){
        int [] tmp = new int[arr.length];
        mergeSort(arr,tmp,0,arr.length-1);
    }
    private static void mergeSort(int [] arr, int [] tmp, int start, int end){
        if(start<end){
            int mid = (start+end) /2;
            mergeSort(arr,tmp,start,mid);
            mergeSort(arr,tmp,mid+1,end);
            merge(arr,tmp,start,mid,end);
        }
    }

    private static void merge(int [] arr, int [] tmp, int start ,int mid, int end){
        for(int i=start; i<=end; i++) {
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid +1;
        int index = start;

        while(part1<=mid && part2<=end){
            if(tmp[part1]<=tmp[part2]){
                arr[index++] = tmp[part1++];
            }else{
                arr[index++] = tmp[part2++];
            }
        }
        for(int i= 0; i<=mid-part1; i++){
            arr[index +i] = tmp[part1 + i];
        }
    }

    public static void main(String[] args) {
        int [] arr = {69,10,30,2,16,8,31,22};
        System.out.print("\n 정렬할 원소 :");
        for (int k : arr) System.out.printf("%3d ", k);
        mergeSort(arr);
        System.out.print("\n 병합정렬 >>");
        for (int j : arr) System.out.printf("%3d ", j);
    }
}
