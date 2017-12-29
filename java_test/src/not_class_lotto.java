import java.util.Arrays;

public class not_class_lotto {
	public static void main(String [] args) {
		
		int m[] = new int[6];
		for(int k=0; k<10; k++) {	
			for(int i=0; i<m.length; i++) {
				int num =(int)(Math.random()*45)+1;
				m[i]=num;
				for(int j=0; j<i; j++) {
					if(m[i]==m[j]) {
						i--;
					}
				}
			}
			Arrays.sort(m);
			for(int a: m)
				System.out.printf("%d ",a);
			System.out.println();

		}
	}
}
