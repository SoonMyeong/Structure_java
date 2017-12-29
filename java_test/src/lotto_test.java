import java.util.Random;
import java.util.Arrays;
public class lotto_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int user_num[] = {10,20,30,17,23,22};
		int user_auto[];
		Lotto lotto = new Lotto();
		
		for(int i=0; i<5; i++) {
			System.out.printf("\n ∑로또 당첨번호: ");
			lotto.print_num(lotto.generate_num());
		}
		/*
		System.out.printf("\n 내가 선택한 수동번호: ");
		lotto.print_num(user_num);
		
		System.out.printf("\n 당첨 여부: ");
		lotto.check_num(user_num);
		System.out.println();
		
		System.out.printf("\n 내가 선택한 자동번호: ");
		user_auto = lotto.generate_auto_num(0);
		lotto.print_num(user_auto);
		
		System.out.printf("\n 당첨 여부: ");
		lotto.check_num(user_auto);
		*/
	}

}

class Lotto {
	private int right_num[];
	private int auto_num[];
	
	Lotto(){
		right_num = new int[6];
		auto_num = new int[6];
	}
	
	public int[] generate_num() {
		for(int i=0; i<6; i++) {
			int random_num = (int)(Math.random()*45)+1;
			right_num[i]=random_num;
			for(int j=0; j<i; j++) {
				if(right_num[i]==right_num[j]) {
					i--;
				}
			}
		}
		return right_num;
	}
	
	public int[] generate_auto_num(int i) {
		
		for(int j=i; j<6; j++) {
			int random_num = (int)(Math.random()*45)+1;
			if(auto_num[i]==random_num) {
				generate_num();
			}
			auto_num[j]=random_num;
		}
		return auto_num;
	}
	
	
	public void check_num(int a[]) {
		
		int count =0;
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				if(a[i]==right_num[j]) {
					count++;
				}
			}
		}
		if(count==0) {
			System.out.printf(" 저런! 맞은 수가 하나도 없네요.");
		} else {
			System.out.printf(" %d 개 맞았습니다.",count);	
		}
		
	}
	
	public void print_num(int a[]) {
		for(int i=0; i<6; i++)
			System.out.printf("%d ",a[i]);
		System.out.println();
	}
	
}