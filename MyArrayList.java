import java.util.Arrays;

public class MyArrayList{
	private int[] array;
	private int size;

	public MyArrayList(){
		array = new int[10];
		size = 0;
	}
	//后插
	public void pushBack(int element){
		array[ size++ ] = element;
	}
	//后删
	public void popBack(){
		array[ --size ] = 0;
		if(size <= 0){
			System.out.println("列表空了");
		}
	}
	//前插
	public void pushFront(int element){
		for(int i = size - 1; i >= 0; i --){
			array[ i + 1 ] = array [ i ];
		}
		array[0] = element;
		size++;
	}
	//前删
	public void popFront(){
		if(size == 0){
		System.out.println("空了");
			return;
		}
		for(int i =1; i <= size; i ++){
			array[ i - 1] = array [ i ];
		}
		array[--size] = 0;
	}
	//插入
	public void insert(int element,int index){
			for(int i = size - 1;i >= index;i -- ){
				array[ i +1 ] = array [ i ];
			}
			array[ index ] = element;
			size++;
	}
	
	@Override
	public String toString(){
		return Arrays.toString(Arrays.copyOf(array,size));
	} 
	
	public static void main(String[] args){
		MyArrayList list = new MyArrayList();
		list.pushBack(1);
		list.pushBack(2);
		list.pushBack(3);
		list.pushBack(4);
		list.pushBack(5);
		System.out.println(list);
		list.pushFront(10);
		list.pushFront(20);
		list.pushFront(30);
		System.out.println(list);
		list.popFront();
		list.popFront();
		System.out.println(list);
		list.insert(100,2);
		list.insert(200,0);
		System.out.println(list);
		
	}	
}