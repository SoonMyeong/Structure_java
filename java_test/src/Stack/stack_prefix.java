package Stack_Prefix;

/* 17.10.07 토요일
 * 스택을 이용한 중위표기식을
 * 전위표기식, 후위표기식으로 변환 
 * 
 */



public class stack_prefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OptExp opt = new OptExp();
		String exp = "(3*5)-(6/2)";
		char prefix[];
		char postfix[];
		System.out.println(exp);
		if(opt.testPair(exp)) {
			System.out.println("괄호문제없음 ");
		}else {
			System.out.println("괄호 틀림 ");
		}
		
		System.out.println("전위표기식으로 변환");
		prefix = opt.toPrefix(exp);
		System.out.println(prefix);
		System.out.println("후위표기식으로 변환");
		postfix = opt.toPostfix(exp);
		System.out.println(postfix);
		

	}

}


interface Stack {
	boolean isEmpty();
	void push(char item);
	char pop();
	void delete();
	char peek();
}

class StackNode{
	char data;
	StackNode link;
}

class LinkedStack implements Stack {
	
	private StackNode top;

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (top ==null);
	}

	@Override
	public void push(char item) {
		// TODO Auto-generated method stub
		StackNode newNode = new StackNode();
		newNode.data = item;
		newNode.link = top;
		top = newNode;
	}

	@Override
	public char pop() {
		// TODO Auto-generated method stub
		
		if(isEmpty()) {
			System.out.print("스택이 비어있습니다.");
			return 0;
			
		} else {
			char item = top.data;
			top = top.link;
			return item;
			
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.print("스택이 비어 있습니다.");
		} else {
			top = top.link;
		}
		
	}

	@Override
	public char peek() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.printf("선택할 스택이 없습니다.");
			return 0;
		} else {
			return top.data;
		}
	}
	
	public void printStack() {
		StackNode temp = top;
		
		System.out.println("Linked Stack =");
		while(temp != null) {
			System.out.println(temp.data);
			temp =temp.link;
		}
	}
	
}
class OptExp {
	
	private String exp;
	private int expSize;
	private char testCh, openPair;
	
	public boolean testPair(String exp) { //괄호 잘 맞는지 검사 하는 함수
		this.exp = exp;
		LinkedStack S = new LinkedStack();
		expSize = this.exp.length();
		
		for(int i=0; i<expSize; i++) {
			
			testCh = this.exp.charAt(i);
			
			switch(testCh) {
			case '[':
			case '{':
			case '(':
				S.push(testCh); break;
			case ')':
			case '}':
			case ']':
				if(S.isEmpty()) break;
				else {
					openPair = S.pop();
					if(openPair =='(' && testCh !=')'
							|| openPair=='{' && testCh!='}' 
							||openPair=='[' && testCh !=']') {
						return false;
					}
					else break;
						
				}
			}
				
			}
			if(S.isEmpty()) {
				return true;
			}
			else return false;
		
	}
	
	public char[] toPrefix(String infix) {
		char testCh;
		exp = infix;
		int expSize = 10;
		int j=expSize-1;
		char prefix[] = new char[expSize];
		LinkedStack S = new LinkedStack();
		
		for(int i =expSize; i>=0; i--) {
			testCh = this.exp.charAt(i);
			
			switch(testCh) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				prefix[j--] = testCh;
				break;
			case '+':
			case '-':
			case '*':
			case '/':
				S.push(testCh);
				break;
			case '(':
				prefix[j--] = S.pop();
				break;
			default:		
			}
		}
		prefix[j] = S.pop(); //괄호밖에있었던 연산기호 마지막에 빼서 넣기 
		return prefix;
	}
	
	public char[] toPostfix(String infix) {
		char testCh;
		exp = infix;
		int expSize=10;
		char postfix[] = new char[expSize];
		int j = 0;
		LinkedStack S = new LinkedStack();
		
		for(int i=0; i<=expSize; i++) {
			
			testCh = this.exp.charAt(i);
			
			switch(testCh) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				postfix[j++] = testCh;
				break;
			case '+':
			case '-':
			case '*':
			case '/':
				S.push(testCh);
				break;
			case ')':
				postfix[j++]= S.pop();
				break;
			default :	
			}
		}
		
		postfix[j] = S.pop();
		return postfix;
	}
}



