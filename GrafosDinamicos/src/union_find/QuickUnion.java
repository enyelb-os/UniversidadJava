package union_find;

public class QuickUnion {
	private int[] id;
	private int count;

	public QuickUnion(int n) {
		count = n;
		id = new int[n];
		for (int i = 0; i < n; i++)
			id[i] = i;
	}

	public int count() {
		return count;
	}

	public boolean conectados(int p, int q) {
		return find(p) == find(q);
	}

	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return id[p];
	}

	public void union(int p, int q) {
		int pRaiz = find(p);
		int qRaiz = find(q);
		if (!(pRaiz == qRaiz)) {
			id[pRaiz] = qRaiz;
			System.out.println(pRaiz + " " + qRaiz);
			count--;
		}
	}

	public void mostrarIDs() {
		System.out.println("Ids");
		for (int i = 0; i < id.length; i++) {
			System.out.println(i + " " + id[i]);
		}
	}
}
