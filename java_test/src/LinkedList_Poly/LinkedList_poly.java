package LinkedList_poly_add;




/* 17.10.06 연결리스트를 이용한 다항식의 덧셈과 곱셈
 * 
 */

class LinkedList_Poly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Polynomial A = new Polynomial();
		A.appendTerm(1, 1);
		A.appendTerm(3, 0);
		A.PrintPoly();
		
		Polynomial B = new Polynomial();
		B.appendTerm(1, 1);
		B.appendTerm(3, 0);
		B.PrintPoly();

		Polynomial C = new Polynomial();
		C=C.AddPoly(A, B);
		C.PrintPoly();
		
		C=C.MultiPoly(A, B);
		C.PrintPoly();
		
	}

}

class ListNode {
	int coef;
	int expo;
	ListNode link;
	
	ListNode() {
		link=null;
	}
	
	ListNode(int coef, int expo){
		this.coef = coef;
		this.expo = expo;
		this.link = null;
	}
	ListNode(int coef, int expo, ListNode link){
		this.coef = coef;
		this.expo = expo;
		this.link = link;
	}

	public int getCoef() {
		return this.coef;
	}
	public int getExpo() {
		return this.expo;
	}

}

class Polynomial {
	
	ListNode head;
	
	Polynomial() {
		head =null;
	}
	
	public void appendTerm(int coef, int expo) {
		ListNode NewNode = new ListNode(coef,expo);

		if(head==null) {
			head = NewNode;
		} else {
			ListNode last = head;
			while(last.link !=null) {
				last=last.link;
			}
			last.link=NewNode;
		}
		
	}

	

	public Polynomial AddPoly(Polynomial A,Polynomial B) {
		
		ListNode p =A.head;
		ListNode q =B.head;
		Polynomial C = new Polynomial();
		
		
		while(p != null && q != null) {
			
			if(p.expo > q.expo) {
				C.appendTerm(p.coef,p.expo);
				p = p.link;
			}
			else if(p.expo == q.expo) {
				int sum = p.coef + q.coef;
				if(sum != 0) {
					C.appendTerm(sum, p.expo);
					p = p.link;
					q = q.link;
				}
			} else {
				C.appendTerm(q.coef, q.expo);
				q = q.link;
			}
			
		}
		while(p != null) {
			C.appendTerm(p.coef, p.expo);
			p = p.link;
		}
		while(q != null) {
			C.appendTerm(q.coef, q.expo);
			q = q.link;
		} 
		
		return C;
	}
	
	public Polynomial MultiPoly(Polynomial A, Polynomial B) {
		
		Polynomial C = new Polynomial();
		Polynomial result = new Polynomial();
		ListNode p = A.head;
		ListNode q = B.head;

		while(q!=null) {
			p = A.head;
			result.head=null;
			while(p!=null) {
				result.appendTerm(p.coef*q.coef, p.expo+q.expo);
				p=p.link;
			}
			C = AddPoly(C, result);
			q=q.link;
		}
		return C;
		
	}
	
	public void PrintPoly() {
		ListNode temp = head;
		
		while(temp !=null) {
			System.out.printf(temp.coef + "x^" + temp.expo);
			temp = temp.link;
			if(temp !=null)
				System.out.print(" + ");
		}
		System.out.println();
	}
	
}



