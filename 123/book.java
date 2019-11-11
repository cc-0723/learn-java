public class book{
	//属性
	private string title;
	private string author;
	private double price;
	private string publisher;
	
	//构造方法
	book(string title,string author,double price,string publisher){
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;	
	}
	
	//getter 
	String getTitle(){
		return title;
	}
	String getAuthor(){
		return author;
	}
	String getPrice(){
		return price;
	}
	String getPublisher(){
		return publisher;
	}
	
	
	//setter
	void setTitle(String title){
		this.title = title;
	}
	void setAuthor(String author){
		this.author = author;
	}
	void setPrice(String price){
		this.price = price;
	}
	void setPublisher(String publisher){
		this.publisher = publisher;
	}
	
	//普通方法
	void appendAuthor(String author){
		this.author = this.author + " " + auther;
	double getDiscount(double discount){
		return this.price * discount;
	}
	
	//覆写一个方法
	@Override
	public String toString(){
		return String.format("《%s》by %s",title,author);
	}
		
	}
}
