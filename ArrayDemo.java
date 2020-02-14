import java.util.Arrays;

public class ArrayDemo {
	
	public static void swap(int a, int b) {
		int t = a;
		a = b;
		b = t;
	}
	
	public static void swap(int[] arr,int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	public static void main(String[] args) {
		int[] array = { 8, 12 };
		System.out.println(Arrays.toString(array));
		swap(array, 0, 1);
		System.out.println(Arrays.toString(array));
	}
}