public class Hanoi{

public static void hanoi(int n, int form, int to) {
		if(n == 1) {
			System.out.printf("从 %d 移动到 %d%n", form, to);
		}else {
			int other = 3 - form - to;
			hanoi(n - 1, form, to);
			System.out.printf("从 %d 移动到 %d%n", form, to);
			hanoi(n - 1, other, to);
		}
	}
	
	public static void main(String[] main) {
		hanoi(4,0,2);
	}
}