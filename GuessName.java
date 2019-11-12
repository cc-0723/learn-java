import java.util.Random;
import java.util.Scanner;

public class GuessName{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		System.out.println("==================");
		System.out.println("欢迎进入猜数字游戏");
		int n = random.nextInt(100);
		System.out.println("随机数已经生成");
		int times = 5;
		System.out.println("您有" + times + "次机会");
		System.out.println("==================");
		for(int i = 1; i <= times; i ++ ){
			System.out.print(">>>>");
			int a = scanner.nextInt();
			if( a == n ){
				System.out.println("恭喜你，猜对了！你用了" + i + "次机会");
				return;
			}else if( a < n ) {
				System.out.println("第" + i + "次猜测，你猜的数小了");
			}else{
				System.out.println("第" + i + "次猜测，你猜的数大了");
			}
		}
		System.out.println("==================");
		System.out.println("很遗憾，游戏结束！！");
		System.out.println("正确的数为：" + n );
		System.out.println("==================");
	}
}