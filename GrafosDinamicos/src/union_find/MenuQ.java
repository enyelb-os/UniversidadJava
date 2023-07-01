package union_find;


public class MenuQ {

	public static void main(String[] args) {
		int N = 10;
//		QuickFind qf = new QuickFind(N);
//		
//		qf.union(4,3);
//		qf.union(3,8);
//		qf.union(6,5);
//		qf.union(9,4);
//		qf.union(2,1);
//		qf.union(8,9);
//		qf.union(5,0);
//		qf.union(7,2);
//		qf.union(6,1);
//		qf.union(1,0);
//		qf.union(6,7);
//		
//		qf.mostrarIDs();
//		
//		System.out.println(qf.count());
		
		
//		QuickUnion qu = new QuickUnion(N);
//		
//		qu.union(4,3);
//		qu.union(3,8);
//		qu.union(6,5);
//		qu.union(9,4);
//		qu.union(2,1);
//		qu.union(8,9);
//		qu.union(5,0);
//		qu.union(7,2);
//		qu.union(6,1);
//		qu.union(1,0);
//		qu.union(6,7);
//		
//		qu.mostrarIDs();
//		
//		System.out.println(qu.count());
		
		WeightedQuickUnion wqu = new WeightedQuickUnion(N);
		
		wqu.union(4,3);
		wqu.union(3,8);
		wqu.union(6,5);
		wqu.union(9,4);
		wqu.union(2,1);
		wqu.union(8,9);
		wqu.union(5,0);
		wqu.union(7,2);
		wqu.union(6,1);
		wqu.union(1,0);
		wqu.union(6,7);
		
		wqu.mostrarIDs();
		
		System.out.println(wqu.count());
	}

}
