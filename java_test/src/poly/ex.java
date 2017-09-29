package poly;

import org.omg.PortableServer.POA;


public class ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float a[] = new float[] {1,1};
		float b[] = new float[] {1,1};
		
		Polynomial A = new Polynomial(1,a);
		Polynomial B = new Polynomial(1,b);
		OperatePoly optPoly = new OperatePoly();
		Polynomial C = optPoly.multPoly(A, B);
		System.out.print("A(x)="); A.printPoly();
		System.out.print("B(x)="); B.printPoly();
		System.out.print("C(x)="); C.printPoly();


	}

}

class Polynomial {
	private int degree;
	private float coef[]= new float[20];
	
	Polynomial(int degree, float coef[]) {
		this.degree = degree;
		this.coef = coef;
	}
	Polynomial(int degree){
		this.degree= degree;
		for(int i=0; i<=this.degree; i++) {
			this.coef[i]=0;
		}
	}
	public int getDegree() {
		return this.degree;
	}
	public float getCoef(int i) {
		return this.coef[i];
	}
	public float setCoef(int i, float coef) {
		return this.coef[i]+=coef;
	}

	public void printPoly() {
		int temp = this.degree;
		for(int i=0; i<=this.degree; i++) {
			System.out.printf("%3.0fx^%d",this.coef[i],temp--);
		}
		System.out.println();
	}
	
}

class OperatePoly {
	
	private int	degree_A=0, degree_B=0, degree_C=0;
	
	public Polynomial multPoly(Polynomial A, Polynomial B) {
		
		degree_A = A.getDegree();
		degree_B = B.getDegree();
		degree_C = degree_A + degree_B;
		
		Polynomial C = new Polynomial(degree_C);
		
		for(int i=0; i<=degree_A; i++) {
			for(int j=0; j<=degree_B; j++) {
				for(int k=0; k<=degree_C; k++) {
					if(i+j==k) {
						C.setCoef(k, A.getCoef(i)*B.getCoef(j));
					}
				}
			}
		}
		
		return C;
		
	}
			
}


