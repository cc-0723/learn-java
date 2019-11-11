publi class booktest{
	public static void main (String[] args) {
		book book1 = new book("流浪记","三毛",50,"北京出版社");
		book book2 = new book("老人与海","海明威",100,"西安出版社");
		
		System.out.println(book1);
		System.out.println(book1.getDiscount(0.5));
		System.out.println(book2);
		System.out.println(book2.getDiscount(2));
	}
}