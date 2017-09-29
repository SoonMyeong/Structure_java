package matrix;

public class matrix_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][]arr= {{0,1,1},{0,1,0},{0,0,1}};
		int count=1;
		
		SparseMatrix matrix = new SparseMatrix(4);
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(arr[i][j]!=0) {
					matrix.setMatrix(count,i, j,arr[i][j]);
					count++;
				}
			}
		}
		
		matrix.printSparse();

		
	}

}

class SparseMatrix{
	
	private int [][]matrix = new int[5][3];
	
	
	SparseMatrix(int i) {
		this.matrix[0][0]=3;
		this.matrix[0][1]=3;
		this.matrix[0][2]=i;
	}
	
	public void setMatrix(int count,int i, int j, int num) {
		
		this.matrix[count][0]=i;
		this.matrix[count][1]=j;
		this.matrix[count][2]=num;
	}
	
	
	public void printSparse() {
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<3; j++) {
				System.out.printf("%d ",matrix[i][j]);
			}
			System.out.println();
		}
	}
	
}






