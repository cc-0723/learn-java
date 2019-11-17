import java.util.Arrays;

public class MyArrayList{
	private int[] array;
	private int size;

	public MyArrayList( int capacity){
		array = new int[capacity];
		size = 0;
	}
	
	public MyArrayList(){
		this(10);
	}
	
	//插入
	public void insert(int index,int element){
		//抛出异常
		if(index < 0 || index > size ){
			throw new ArrayIndexOutOfBoundsException(index);
		}
			if(!checkCapacity(1)){
				ensureCapacity();
			}
			for(int i = size;i > index;i -- ){
				array[ i ] = array [ i - 1];
			}
			array[ index ] = element;
			size++;
	}
	
	public void erase(int index){
		if(size == 0){
		System.out.println("空的");
			return;
		}
		for(int i =index + 1; i <= size; i ++){
			array[ i - 1] = array [ i ];
		}
		array[--size] = 0;
	}
	
	public void pushBack(int element){
		insert(size,element);
	}
	
	public void pushFront(int element){
		insert(0,element);
	}
	
	public void popBack(){
		erase(size - 1);
	}
	
	public void popFront(){
		erase(0);
	}
	
	@Override
	public String toString(){
		return Arrays.toString(Arrays.copyOf(array,size));
	} 
	
	private boolean checkCapacity(int num){
		return size + num <= array.length;
	}
	
	public void ensureCapacity(){
		//通常，如果不够用，扩大为2倍
		int newLength = array.length * 2;
		int[] newArray = new int[newLength];
		for(int i = 0;i < size; i ++ ){
			newArray[i] = array[i];
		}
		this.array = newArray;
	}
	
	public int get(int index){
		if(index < 0 || index >= size ){
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return array[index];
	}
	
	public int set(int index,int element){
		if(index < 0 || index >= size ){
			throw new ArrayIndexOutOfBoundsException(index);
		}
		int old = array[index];
		array[index] = element;
		return old;
	}
	
	public static void main(String[] args){
		
		MyArrayList list = new MyArrayList(2);
		list.pushBack(1);
		list.pushBack(2);
		System.out.println(list.array.length);
		list.pushBack(3);
		System.out.println(list.array.length);
		list.pushBack(4);
		System.out.println(list.array.length);
		list.pushBack(5);
		list.pushBack(6);
		System.out.println(list.array.length);
	}	
}