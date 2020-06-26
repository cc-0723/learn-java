public static void DFS(int index, int n, int[] box, int[] book) {
	if(index == n + 1) {
		for(int i = 1; i <= n; i++) {
			System.out.print(box[i] + " ");
		}
		System.out.println();
		return;
	}
	
	for(int i = 1; i <= n; i++) {
		if(book[i] == 0) {
			box[index] = i;
			book[i] = 1;
			DFS(index + 1; n; box; book);
			book[i] = 0;
		}
	}
}

public static void main(String[] args) {
	int n;
	Scanner sc = new Scanner(System.in);
	n = sc.nextInt();
	int[] box = new int[n + 1];
	int[] book = new int[n + 1];
	DFS(1, n, box, book);
}







