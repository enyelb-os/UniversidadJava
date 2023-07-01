package union_find;

public class Menu {
	public static void main(String[] args) {
		int N = 10;
		UnionFind uf = new UnionFind(N);
		
		uf.union(4,3);
		uf.union(3,8);
		uf.union(6,5);
		uf.union(9,4);
		uf.union(2,1);
		uf.union(8,9);
		uf.union(5,0);
		uf.union(7,2);
		uf.union(6,1);
		uf.union(1,0);
		uf.union(6,7);
		
		uf.mostrarIDs();
		
		System.out.println(uf.count());
	}

}
