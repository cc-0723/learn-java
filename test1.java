import java.util.Arrays;

public class test1 {
	public static void Bubble(int[] a){
		for(int i = 0; i < a.length; i ++ ){
			//冒泡次数
			for(int j = 1; j < a.length - i; j ++ ){
				if(a[ j ] < a[ j - 1 ]){
					int temp = 0;
					temp = a[ j ];
					a[ j ] = a[ j -1 ];
					a[ j -1 ] = temp;
				}
			}
		}
	}
	public static void main(String[] args){
		int[] a = {3,8,5,6,2,1};
		int[] a1 = {2,8,6,5,7,3,1};
		int[] a2 = {9,5,2,3,4,7,6};
			Bubble(a);
			Bubble(a1);
			Bubble(a2);
            System.out.println(Arrays.toString(a));
			System.out.println(Arrays.toString(a1));	
			System.out.println(Arrays.toString(a2));				
	}
}