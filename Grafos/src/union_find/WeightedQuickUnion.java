package union_find;

public class WeightedQuickUnion {
	private int[] id;
	private int[] sz;
	private int count;

	public WeightedQuickUnion(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
		sz = new int[N];
		for (int i = 0; i < N; i++)
			sz[i] = 1;
	}

	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	private int find(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}

	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (!(i == j)) {
			if (sz[i] < sz[j]) {
				id[i] = j;
				sz[j] += sz[i];
				System.out.println("j"+sz[j]);
			} else {
				id[j] = i;
				sz[i] += sz[j];
				System.out.println("i"+sz[i]);
			}
			System.out.println(p+" "+q);
			count--;
		}
	}
	public void mostrarIDs(){
		System.out.println("Ids");
		for(int i=0;i<id.length;i++){
			System.out.println(i+" "+id[i]);
		}
	}
}
